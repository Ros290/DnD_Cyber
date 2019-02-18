package it.main.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import it.main.model.Dm;

public class DmUtilsDAO {

	private EntityManager em;
	private EntityTransaction tx;
	
	public DmUtilsDAO() {
		em = UtilsDAO.getInstance().createEntityManager();
		tx = em.getTransaction();
	}
	
	public void newDm (Dm dm) {
		if (dm.getName().isEmpty()) {
			String message = "ERROR : Name field is Empty!";
			throw new RollbackException (message);
		}
		tx.begin();
		em.merge(dm);
		tx.commit();
	}
	
	public List<Dm> getListDm (){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Dm> cq = cb.createQuery(Dm.class);
		Root<Dm> dm = cq.from(Dm.class);
		cq.select(dm);
		TypedQuery<Dm> q = em.createQuery(cq);
		return q.getResultList();
	}
	
	public Dm findDm (int id) {
		return em.getReference(Dm.class, id);
	}
	
	public void removeDm (Dm dm ) {
		tx.begin();
		em.remove(dm);
		tx.commit();
	}
}
