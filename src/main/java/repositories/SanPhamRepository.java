package repositories;

import utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import repositories.Repository;
import viewmodels.SanPhamResponse;

/**
 *
 * @author sonpt_ph19600
 */

public class SanPhamRepository extends Repository{

    public List<SanPhamResponse> findAllByName(String name) {
        List<SanPhamResponse> list = new ArrayList<>();
        try {
            session = HibernateUtil.getFACTORY().openSession();
            String hql = "SELECT new viewmodels.SanPhamResponse"
                    + "(a.id, a.sanPham.ma, a.sanPham.ten, a.namBH, a.moTa, a.soLuongTon, a.giaNhap, a.giaBan) "
                    + " FROM ChiTietSP a WHERE a.sanPham.ten LIKE CONCAT('%',:name,'%')";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);           
            list = query.getResultList();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
