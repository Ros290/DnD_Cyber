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

import it.main.model.Player;

public class PlayerUtilsDAO {

	private EntityManager em;
	private EntityTransaction tx;
	
	public PlayerUtilsDAO() {
		em = UtilsDAO.getInstance().createEntityManager();
		tx = em.getTransaction();
	}
	
	public void newPlayer (Player player) {
		int columnNameSize = 0;
		try {
			columnNameSize = player.getClass().getDeclaredField("name").getAnnotation(Column.class).length();
		} catch (NoSuchFieldException | SecurityException e1) {
			throw new RollbackException("INTERNAL ERROR!");
		}
		if (player.getName().isEmpty()) {
			String message = "ERROR : Name field is Empty!";
			throw new RollbackException (message);
		}
		if (player.getName().length() > columnNameSize) {
			String message ="ERROR : Name has too many characters (> " + columnNameSize + ")!";
			throw new RollbackException(message);
		}
		
		tx.begin();
		em.merge(player);
		tx.commit();
	}
	
	public List<Player> getListPlayers (){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Player> cq = cb.createQuery(Player.class);
		Root<Player> player = cq.from(Player.class);
		cq.select(player);
		TypedQuery<Player> q = em.createQuery(cq);
		return q.getResultList();
	}
	
	public Player findPlayer (int id) {
		return em.find(Player.class, id);
	}

	public void removePlayer (Player player) {
		tx.begin();
		em.remove(player);
		tx.commit();
	}
}
