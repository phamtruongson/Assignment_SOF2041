package repositories;

import domainmodels.HoaDon;
import utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import viewmodels.SaleViewHoaDonResponse;

/**
 *
 * @author sonpt_ph19600
 */

public class HoaDonRepository extends Repository<HoaDon, UUID, SaleViewHoaDonResponse>{

    public List<SaleViewHoaDonResponse> getAll() {        
        List<SaleViewHoaDonResponse> list = new ArrayList<>();
        try {            
            session = HibernateUtil.getSession();          
            String hql = "SELECT new viewmodels.SaleViewHoaDonResponse "
                    + " (a.id, a.ma, a.ngayTao, b.ten, a.tinhTrang) "
                    + " FROM HoaDon a LEFT JOIN a.nhanVien b ORDER BY CONVERT(BIGINT,SUBSTRING(a.ma, 3,10)) DESC";
            Query query = session.createQuery(hql);   
            list = query.getResultList();            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<SaleViewHoaDonResponse> findByTinhTrang(int tinhTrang) {        
        List<SaleViewHoaDonResponse> list = new ArrayList<>();
        try {            
            session = HibernateUtil.getSession();
            String hql = "SELECT new viewmodels.SaleViewHoaDonResponse "
                    + " (a.id, a.ma, a.ngayTao, b.ten, a.tinhTrang) "
                    + " FROM HoaDon a LEFT JOIN a.nhanVien b WHERE a.tinhTrang = :tinhTrang";
            Query query = session.createQuery(hql); 
            query.setParameter("tinhTrang", tinhTrang);
            list = query.getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

//    public HoaDon save(HoaDon hoaDon) {
//        try {
//            session
//            session.save(hoaDon);
//            return hoaDon;
//        } catch (Exception e) {
//            e.printStackTrace();
//            trans.rollback();
//            session.close();
//            return null;
//        }
//    }   
    
    public boolean updateTinhTrang(UUID id, int tinhTrang){
        try {     
            session = HibernateUtil.getSession(); 
            trans = session.beginTransaction();
            String hql = "UPDATE HoaDon SET tinhTrang = :tinhTrang WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("tinhTrang", tinhTrang);
            query.setParameter("id", id);
            if (query.executeUpdate() < 1) {
                return false;
            }
            trans.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
