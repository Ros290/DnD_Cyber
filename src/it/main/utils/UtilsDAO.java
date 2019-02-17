package it.main.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilsDAO {
	protected static EntityManagerFactory emf;
	
	public static EntityManagerFactory getInstance() {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory("persistence");
		return emf;
	}
}
