package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.Stuffy;

public class StuffyDB implements DAO<Stuffy>{
	
	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/stuffydb";
		String username = "stuffy";
		String password = "sesame";
		Connection connection = DriverManager.getConnection(dbURL, username, password);
		return connection;

	}
	
	public Stuffy get(int ID) {
		// test ALL sql statements (i.e. SELECT) in sql workbench before adding to java
		// code
		String sql = "SELECT * FROM stuffydb.product" + " where ID = ?"; // '?' is placeholder for code to be added later
		List<Stuffy> products = new ArrayList<>();
		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String type = rs.getString("Type");
				String color = rs.getString("Color");
				String size = rs.getString("Size");
				int limbs = rs.getInt("Limbs");
				Stuffy s = new Stuffy(ID, type, color, size, limbs);
				return s;
			}
			else {
				rs.close();
				return null;
		}
	}
		catch (SQLException e) {
			System.err.println(e);
			return null;
	}

		}
	
	@Override
	public List<Stuffy> getAll() {
		String sql = "SELECT * FROM Product";
		List<Stuffy> products = new ArrayList<>();
		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				int ID = rs.getInt("ID");
				String type = rs.getString("Type");
				String color = rs.getString("Color");
				String size = rs.getString("Size");
				int limbs = rs.getInt("Limbs");

				Stuffy s = new Stuffy(ID, type, color, size, limbs);
				products.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
			products = null;
		}

		return products;
	}
	
	@Override
	public boolean add(Stuffy t) {
		String sql = "INSERT INTO Product (Type, Color, Size, Limbs) " + "VALUES (?, ?, ?, ?)";
		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, t.getType());
			ps.setString(2, t.getColor());
			ps.setString(3, t.getSize());
			ps.setInt(4, t.getLimbs());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
	
	@Override
	public boolean update(Stuffy t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean delete(Stuffy t) {
		String sql = "delete from product " +
				"where ID = ?";
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, t.getId());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
				
	}
	
	

}
