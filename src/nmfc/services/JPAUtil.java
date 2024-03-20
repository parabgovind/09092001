package nmfc.services;

import javax.persistence.EntityManager; 
import javax.persistence.EntityManagerFactory; 
import javax.persistence.Persistence; 

public class JPAUtil{
	
	private static EntityManagerFactory factory; 
	private static EntityManagerFactory factory1; 
	private static EntityManager entityManager; 
	private static EntityManager entityManager1;
	
	static  
	{ 
		factory = null;
	    factory = Persistence.createEntityManagerFactory("JPA-PU");
	} 
	
	static  
	{ 
	    factory1 = Persistence.createEntityManagerFactory("JPA-PU");
	} 
	
	public static EntityManager getEntityManager() 
	{ 
		entityManager = null;
	    if(entityManager==null || !entityManager.isOpen()) { 
	        entityManager = factory.createEntityManager(); 
	    } 
	return entityManager; 
	} 
	
	public static EntityManager getEntityManager1() 
	{ 
	    if(entityManager1==null || !entityManager1.isOpen()) { 
	        entityManager1 = factory1.createEntityManager(); 
	    } 
	return entityManager1; 
	} 
}