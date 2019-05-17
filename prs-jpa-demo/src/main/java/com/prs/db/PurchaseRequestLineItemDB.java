package com.prs.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.prs.business.PurchaseRequestLineItem;


public class PurchaseRequestLineItemDB {
	
	public static List<PurchaseRequestLineItem> getAll() {
		List<PurchaseRequestLineItem> line = null;

		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		try {
			Query q = em.createQuery("Select l from PurchaseRequestLineItem l");
			line = q.getResultList();

		} finally {
			em.close();
		}

		return line;
	}

}
