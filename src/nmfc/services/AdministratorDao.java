package nmfc.services;

import javax.persistence.EntityManager;

import nmfc.entities.Administrator;


public class AdministratorDao {

private EntityManager entityManager; 
	
	public AdministratorDao() { 
	    entityManager = JPAUtil.getEntityManager(); 
	}	
	
	public Administrator findAdministratorByName(String name) {
		// TODO Auto-generated method stub
		Administrator administrator = entityManager.find(Administrator.class, name); 
	    return administrator;
	}
	
	public Administrator findAdministratorByPassword(String password) {
		// TODO Auto-generated method stub
		Administrator administrator = entityManager.find(Administrator.class, password); 
	    return administrator;
	}
}
