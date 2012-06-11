/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author psychok7
 */
public class PersistanceDBManager {
    
    
    public PersistanceDBManager(){
        
    }
    
    public EntityManager getConnectionUpdate(){
        return Persistence.createEntityManagerFactory("Phasebook-ejbPU").createEntityManager();
    }
    public EntityManager getConnectionCreate(){
        return Persistence.createEntityManagerFactory("Phasebook-ejbPUCreate").createEntityManager();
    }
}
