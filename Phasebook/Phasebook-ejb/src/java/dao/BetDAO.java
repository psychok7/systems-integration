/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Bet;
import entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import util.PersistanceDBManager;

/**
 *
 * @author Nickerson
 */
public class BetDAO {
    
    private PersistanceDBManager dbManager;
    
    public BetDAO(){
        
        dbManager = new PersistanceDBManager();
        
    }
    
    public boolean insertBet(Bet bet){
        
        EntityManager em=this.dbManager.getConnectionUpdate();
        
        EntityTransaction tx = em.getTransaction();
            
        try {
            tx.begin();
            em.persist(bet);
            tx.commit();
        } catch (Exception e){
            
            return false;
            
        } finally {
            em.close();
        }
        
        return true;

        
    }
    
    public List<Bet> listBetsUnpublished(Integer idBet){
        
        EntityManager em=this.dbManager.getConnectionUpdate();
        
        Query qry = em.createQuery("select b from Bet as b where idbet = :bet");
        
        qry.setParameter("bet", idBet);
        
        return qry.getResultList();       
        
    }
    
}
