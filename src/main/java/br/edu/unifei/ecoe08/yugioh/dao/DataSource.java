package br.edu.unifei.ecoe08.yugioh.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataSource {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("yugiohPU");
	
	public static EntityManager createEntityManager() {
		return emf.createEntityManager();
	}
	
	public static void closeFactory() {
		emf.close();
	}
}
