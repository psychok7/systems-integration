package dao;

import entities.Posts;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import util.PersistanceDBManager;

public class PostDAO {

    public PersistanceDBManager dbManager;

    public PostDAO() {
        dbManager = new PersistanceDBManager();
    }

    public boolean insertPost(Posts post) {

        EntityManager em = this.dbManager.getConnectionUpdate();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(post);
            
            tx.commit();
        } catch (Exception e) {
            return false;

        } finally {
            em.close();
        }
        return true;
    }

     
    public List<Posts> listPost(int idUser)  {

        EntityManager em = this.dbManager.getConnectionUpdate();
        Query qry = null;
        List<Posts> lista = null;

        try {

            //qry = em.createQuery("from Posts p where p.userReceiver.iduser = :idUser order by creation_date desc");
            //qry.setParameter("idUser", idUser);
            //lista = qry.getResultList();
            Session session = (Session)em.getDelegate();  
            Criteria criteria = session.createCriteria(Posts.class);  
            lista = criteria.list(); 

        } finally {
            em.close();
        }

        return lista;

    }

    public List listPrivatePost(int idUser) {
        EntityManager em = this.dbManager.getConnectionUpdate();
        Query qry = null;
        List<Posts> lista = null;

        try {

            qry = em.createQuery(" select p from Posts p where p.userReceiver.iduser = :idUser and p.privacy = false order by creation_date desc");
            qry.setParameter("idUser", idUser);
            lista = qry.getResultList();
            System.out.println("Private List: " +lista.size());

        } finally {
            em.close();
        }

        return lista;
    }
}
