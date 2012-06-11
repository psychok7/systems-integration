
package dao;

import entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import util.PersistanceDBManager;


public class UserDAO {
    

	public PersistanceDBManager dbManager;

	public UserDAO() {
                dbManager = new PersistanceDBManager();
	}
        
        public boolean register (User new_user){
            EntityManager em=this.dbManager.getConnectionUpdate();
            EntityTransaction tx = em.getTransaction();
            
            tx.begin();
            em.persist(new_user);
            tx.commit();
            
            em.close();
            
            return true;
        }
        
        public boolean edit (User new_user){
            EntityManager em=this.dbManager.getConnectionUpdate();
            EntityTransaction tx = em.getTransaction();
            
            tx.begin();
            em.merge(new_user);
            tx.commit();
            
            em.close();
            
            return true;
        }
        
        public User getUserById(int id){
            User new_user=null; 
            EntityManager em=this.dbManager.getConnectionUpdate();
            Query q = em.createQuery("select c from User c where c.iduser = :iduser");
            q.setParameter("iduser", id);
            
            try{
                new_user = (User)q.getSingleResult(); 
            }
            catch (javax.persistence.NoResultException ex ){
                ex.getMessage();              
            }
                
            em.close();
            return new_user;
        }
}
