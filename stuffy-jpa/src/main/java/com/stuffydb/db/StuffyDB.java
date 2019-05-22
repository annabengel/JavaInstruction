package com.stuffydb.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.stuffydb.business.Stuffy;


public class StuffyDB {
	public static List<Stuffy> getAll() {
		List<Stuffy> stuffies = null;

		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		try {
			Query q = em.createQuery("Select s from Stuffy s");
			stuffies = q.getResultList();

		} finally {
			em.close();
		}

		return stuffies;
	}
	
	public static boolean add(Stuffy s) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(s);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		
		return true;
	}
	
	public static void update(Stuffy stuffy) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(stuffy);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static boolean delete(Stuffy s) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(s));
			trans.commit();			
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		
		return true;
	}
	
	public static Stuffy selectStuffy(String type) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT s FROM Stuffy s " + 
						"WHERE s.type = :type";
		TypedQuery<Stuffy> q =em.createQuery(qString, Stuffy.class);
		q.setParameter("type", type);
		try {
			Stuffy stuffy = q.getSingleResult();
			return stuffy;
		} catch (Exception e) {
			return null;
		} finally {
			em.close();
		}
	}
	
	
}
