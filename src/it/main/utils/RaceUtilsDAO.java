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

import it.main.model.Race;

public class RaceUtilsDAO {

	private EntityManager em;
	private EntityTransaction tx;
	
	public RaceUtilsDAO() {
		em = UtilsDAO.getInstance().createEntityManager();
		tx = em.getTransaction();
	}
	
	public void newRace (Race race) {
		int columnNameSize = 0;
		try {
			columnNameSize = race.getClass().getDeclaredField("name").getAnnotation(Column.class).length();
		} catch (NoSuchFieldException | SecurityException e1) {
			throw new RollbackException("INTERNAL ERROR!");
		}
		if (race.getName().isEmpty()) {
			String message = "ERROR : Name field is Empty!";
			throw new RollbackException (message);
		}
		if (race.getName().length() > columnNameSize) {
			String message ="ERROR : Name has too many characters (> " + columnNameSize + ")!";
			throw new RollbackException(message);
		}
		
		tx.begin();
		em.merge(race);
		tx.commit();
	}
	
	public List<Race> getListRaces (){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Race> cq = cb.createQuery(Race.class);
		Root<Race> race = cq.from(Race.class);
		cq.select(race);
		TypedQuery<Race> q = em.createQuery(cq);
		return q.getResultList();
	}
	
	public Race findRace (int id) {
		return em.find(Race.class, id);
	}

	public void removeRace (Race race) {
		tx.begin();
		em.remove(race);
		tx.commit();
	}
}
