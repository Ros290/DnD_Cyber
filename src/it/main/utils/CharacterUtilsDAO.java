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

import it.main.model.Character;

public class CharacterUtilsDAO {

	private EntityManager em;
	private EntityTransaction tx;
	
	public CharacterUtilsDAO() {
		em = UtilsDAO.getInstance().createEntityManager();
		tx = em.getTransaction();
	}
	
	public void newCharacter (Character character) {
		int columnNameSize = 0;
		try {
			columnNameSize = character.getClass().getDeclaredField("name").getAnnotation(Column.class).length();
		} catch (NoSuchFieldException | SecurityException e1) {
			throw new RollbackException("INTERNAL ERROR!");
		}
		if (character.getName().isEmpty()) {
			String message = "ERROR : Name field is Empty!";
			throw new RollbackException (message);
		}
		if (character.getName().length() > columnNameSize) {
			String message ="ERROR : Name has too many characters (> " + columnNameSize + ")!";
			throw new RollbackException(message);
		}
		
		tx.begin();
		em.merge(character);
		tx.commit();
	}
	
	public List<Character> getListCharacters (){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Character> cq = cb.createQuery(Character.class);
		Root<Character> character = cq.from(Character.class);
		cq.select(character);
		TypedQuery<Character> q = em.createQuery(cq);
		return q.getResultList();
	}
	
	public Character findCharacter (int id) {
		return em.find(Character.class, id);
	}

	public void removeCharacter (Character character) {
		tx.begin();
		em.remove(character);
		tx.commit();
	}
}
