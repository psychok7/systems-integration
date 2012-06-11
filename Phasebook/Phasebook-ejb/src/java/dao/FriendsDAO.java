package dao;

import entities.Friends;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import util.PersistanceDBManager;

public class FriendsDAO {

    public PersistanceDBManager dbManager;

    public FriendsDAO() {
        dbManager = new PersistanceDBManager();
    }

    public boolean addAsFriend(Friends f) {

        EntityManager em = this.dbManager.getConnectionUpdate();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(f);
            tx.commit();
        } catch (Exception e) {
            System.out.println("SOMETHING WENT WRONG!!!!");
            e.printStackTrace();
            return false;

        } finally {
            em.close();
        }
        return true;
    }

    public boolean acceptRequest(Friends f) {
        System.out.println("WRITE ACCEPT !!!");
        EntityManager em = this.dbManager.getConnectionUpdate();
        EntityTransaction tx = em.getTransaction();
        Query qry = null;
        int userId = f.getUser().getIduser();
        int userId1 = f.getUser1().getIduser();
        try {
            tx.begin();
            System.out.println("STATUS " + f.getStatus());
            String q = "UPDATE Friends f SET f.status = :status ";
            q+= "where (f.user.iduser = :idUser and f.user1.iduser = :idUser1) ";
            q+= "or (f.user.iduser = :idUser1 and f.user1.iduser = :idUser) ";
            qry = em.createQuery(q);
            qry.setParameter("idUser", userId);
            qry.setParameter("idUser1", userId1);
            qry.setParameter("status", (Character) 'y');
            qry.executeUpdate();
            
            tx.commit();
        } catch (Exception e) {
            System.out.println("SOMETHING WENT WRONG!!!!");
            e.printStackTrace();
            return false;

        } finally {
            em.close();
        }
        return true;
    }
    
    public List<Friends> listFriends(int userId) {
        EntityManager em = this.dbManager.getConnectionUpdate();
        Query qry = null;
        List<Friends> list = null;

        try {

            qry = em.createQuery(" select f from Friends f where (f.user.iduser = :idUser or f.user1.iduser = :idUser) and f.status = :status");
            qry.setParameter("idUser", userId);
            qry.setParameter("status", (Character) 'y');

            list = qry.getResultList();
            System.out.println("FRIENDS SIZE " + list.size());

        } finally {
            em.close();
        }
        return list;

    }
    
        public List<Friends> listPendingRequests(int userId) {

        EntityManager em = this.dbManager.getConnectionUpdate();
        Query qry = null;
        List<Friends> list = null;

        try {

            qry = em.createQuery(" select f from Friends f where (f.user.iduser = :idUser or f.user1.iduser = :idUser) and f.status = :status");
            qry.setParameter("idUser", userId);
            qry.setParameter("status", (Character) 'p');

            list = qry.getResultList();
            System.out.println("REQUESTS SIZE " + list.size());

        } finally {
            em.close();
        }
        return list;
    }

}
