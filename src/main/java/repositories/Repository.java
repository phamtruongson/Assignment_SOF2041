package repositories;

import domainmodels.NSX;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import viewmodels.NSXResponse;

/**
 *
 * @author sonpt_ph19600
 */

public abstract class Repository<Entity, Id, Response> {
    
    protected static Session session ;
    protected static Transaction trans;   
    protected static String className;
    protected static String resCon;

    public void openTranSaction() {
        session = HibernateUtil.getFACTORY().openSession();
        trans = session.beginTransaction();
    }


    public void commitTranSaction() {
        trans.commit();
        session.close();
    }
    
    public List<Response> getAll(){
        List<Response> list = new ArrayList<>();
        try {          
            session = HibernateUtil.getFACTORY().openSession();
            String hql = "SELECT " + resCon + " FROM " + className + " a";
            Query query = session.createQuery(hql);
            list = query.getResultList();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            session.close();
            return null;
        }
        return list;
    }
    
    public boolean saveOrUpdate(Entity entity) {
        try {
            openTranSaction();
            session.saveOrUpdate(entity);          
            commitTranSaction();
        } catch (Exception e) {
            e.printStackTrace();
            session.close();
            return false;
        }
        return true;
    }
        
    public boolean detele(Entity entity) {
        try {
            openTranSaction();
            session.delete(entity);          
            commitTranSaction();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public Entity findById(Id id){
        try {
            Entity entity;
            session = HibernateUtil.getFACTORY().openSession();
            String hql = "SELECT a FROM " + className + " a WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            entity = (Entity) query.getSingleResult();
            session.close();
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            session.close();
            return null;
        }
    }
    
    public Entity findByMa(String ma) {
        try {
            Entity entity;
            session = HibernateUtil.getFACTORY().openSession();
            String hql = "SELECT a FROM " + className + " a WHERE ma = :ma";
            Query query = session.createQuery(hql);
            query.setParameter("ma", ma);
            entity = (Entity) query.getSingleResult();
            session.close();
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            session.close();
            return null;
        }     
    }

}
