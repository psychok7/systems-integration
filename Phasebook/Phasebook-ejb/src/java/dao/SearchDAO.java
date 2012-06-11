/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.PersistanceDBManager;

/**
 *
 * @author Nickerson
 */
public class SearchDAO {

    public PersistanceDBManager dbManager;

    public SearchDAO() {
        dbManager = new PersistanceDBManager();
    }

    public List<User> searchPeople(String pattern) {

        EntityManager em = this.dbManager.getConnectionUpdate();
        Query qry = null;
        List<User> list = null;
        
            try {
                String query = "select u from User u where u.name LIKE '%";
                query += pattern;
                query += "%'";
                qry = em.createQuery(query);
                list = qry.getResultList();

            } finally {
                em.close();
            }
       
       

        return list;

    }
}
