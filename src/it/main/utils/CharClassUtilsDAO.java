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

import it.main.model.CharacterClass;

public class CharClassUtilsDAO {

	private EntityManager em;
	private EntityTransaction tx;
	
	public CharClassUtilsDAO() {
		em = UtilsDAO.getInstance().createEntityManager();
		tx = em.getTransaction();
	}
	
	public void newCharacterClass (CharacterClass characterClass) {
		int columnNameSize = 0;
		try {
			columnNameSize = characterClass.getClass().getDeclaredField("name").getAnnotation(Column.class).length();
		} catch (NoSuchFieldException | SecurityException e1) {
			throw new RollbackException("INTERNAL ERROR!");
		}
		if (characterClass.getName().isEmpty()) {
			String message = "ERROR : Name field is Empty!";
			throw new RollbackException (message);
		}
		if (characterClass.getName().length() > columnNameSize) {
			String message ="ERROR : Name has too many characters (> " + columnNameSize + ")!";
			throw new RollbackException(message);
		}
		
		tx.begin();
		em.merge(characterClass);
		tx.commit();
	}
	
	public List<CharacterClass> getListCharacterClasses (){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CharacterClass> cq = cb.createQuery(CharacterClass.class);
		Root<CharacterClass> characterClass = cq.from(CharacterClass.class);
		cq.select(characterClass);
		TypedQuery<CharacterClass> q = em.createQuery(cq);
		return q.getResultList();
	}
	
	public CharacterClass findCharacterClass (int id) {
		return em.find(CharacterClass.class, id);
	}

	public void removeCharacterClass (CharacterClass characterClass) {
		tx.begin();
		em.remove(characterClass);
		tx.commit();
	}
}
