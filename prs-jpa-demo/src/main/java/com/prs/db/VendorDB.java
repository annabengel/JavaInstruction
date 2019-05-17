package com.prs.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.prs.business.User;
import com.prs.business.Vendor;

public class VendorDB {
	
	public static List<Vendor> getAll() {
		List<Vendor> vendors = null;

		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		try {
			Query q = em.createQuery("Select v from Vendor v");
			vendors = q.getResultList();

		} finally {
			em.close();
		}

		return vendors;
	}
	
	public static boolean add(Vendor v) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(v);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		
		return true;
	}

	public static boolean delete(Vendor v) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(v));
			trans.commit();			
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		
		return true;
	}
	
	public static Vendor selectVendor(String email) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT v FROM Vendor v " + 
						"WHERE v.email = :email";
		TypedQuery<Vendor> q =em.createQuery(qString, Vendor.class);
		q.setParameter("email", email);
		try {
			Vendor vendor = q.getSingleResult();
			return vendor;
		} catch (Exception e) {
			return null;
		} finally {
			em.close();
		}
	}
}
