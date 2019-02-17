package it.main.utils;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import it.main.model.Adventure;

public class AdvUtilsDAO {

	private EntityManager em;
	private EntityTransaction tx;

	public AdvUtilsDAO() {
		em = UtilsDAO.getInstance().createEntityManager();
		tx = em.getTransaction();
	}

	public void newAdv(Adventure adv) throws RollbackException {

		int columnNameSize = 0;
		try {
			columnNameSize = adv.getClass().getDeclaredField("name").getAnnotation(Column.class).length();
		} catch (NoSuchFieldException | SecurityException e1) {
			throw new RollbackException("INTERNAL ERROR!");
		}
		if (adv.getName().isEmpty()) {
			String message = "ERROR : Name field is Empty!";
			throw new RollbackException (message);
		}
		if (adv.getName().length() > columnNameSize) {
			String message ="ERROR : Name has too many characters (> " + columnNameSize + ")!";
			throw new RollbackException(message);
		}

		tx.begin();
		em.merge(adv);
		tx.commit();

	}

	public List<Adventure> getListAdv (){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Adventure> cq = cb.createQuery(Adventure.class);
		Root<Adventure> Adventure = cq.from(Adventure.class);
		cq.select(Adventure);
		TypedQuery<Adventure> q = em.createQuery(cq);
		return q.getResultList();
	}

	public Adventure findAdv (int id) {
		return em.find(Adventure.class, id);
	}

	public void removeAdv (Adventure adv) {
		tx.begin();
		em.remove(adv);
		tx.commit();
	}
}
