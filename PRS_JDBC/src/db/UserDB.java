package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.User;

public class UserDB extends ConnectionDB implements DAO<User> {
	

	@Override
	public User get(int ID) {
		String sql = "SELECT * FROM prs.user" + " where ID = ?"; // '?' is placeholder for code to be added later
		List<User> user = new ArrayList<>();
		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String userName = rs.getString("UserName");
				String password = rs.getString("Password");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String phoneNumber = rs.getString("PhoneNumber");
				String email = rs.getString("Email");
				Boolean isReviewer = rs.getBoolean("IsReviewer");
				Boolean isAdmin = rs.getBoolean("IsAdmin");
				User u = new User(ID, userName, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin);
				return u;
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
	public List<User> getAll() {
		String sql = "SELECT * FROM user";
		List<User> user = new ArrayList<>();
		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				int ID = rs.getInt("ID");
				String userName = rs.getString("UserName");
				String password = rs.getString("Password");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String phoneNumber = rs.getString("PhoneNumber");
				String email = rs.getString("Email");
				Boolean isReviewer = rs.getBoolean("IsReviewer");
				Boolean isAdmin = rs.getBoolean("IsAdmin");

				User u = new User(ID, userName, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin);
				user.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
			user = null;
		}

		return user;
	}

	@Override
	public boolean add(User t) {
		String sql = "INSERT INTO User (UserName, Password, FirstName,"
				+ "LastName, PhoneNumber, Email, IsReviewer, IsAdmin) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, t.getUserName());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getFirstName());
			ps.setString(4, t.getLastName());
			ps.setString(5, t.getPhoneNumber());
			ps.setString(6, t.getEmail());
			ps.setBoolean(7, t.getIsReviewer());
			ps.setBoolean(8, t.getIsAdmin());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}

	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User t) {
			String sql = "delete from user " +
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
