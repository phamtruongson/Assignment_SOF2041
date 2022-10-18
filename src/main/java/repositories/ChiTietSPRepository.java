package repositories;

import domainmodels.ChiTietSP;
import java.util.ArrayList;
import utils.HibernateUtil;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repositories.Repository;
import viewmodels.ChiTietSPResponse;
import viewmodels.SaleViewHoaDonChiTietResponse;
import viewmodels.SaleViewSanPhamResponse;

/**
 *
 * @author sonpt_ph19600
 */
public class ChiTietSPRepository extends Repository<ChiTietSP, UUID, ChiTietSPResponse> {

    public boolean updateSoLuong(List<SaleViewHoaDonChiTietResponse> list) {
        try {
            String hql = "UPDATE ChiTietSP SET SoLuongTon = SoLuongTon - :soLuong"
                        + " WHERE id = :id";
            session = HibernateUtil.getSession();
            trans = session.beginTransaction();            
            for (SaleViewHoaDonChiTietResponse item : list) {   
                Query query = session.createQuery(hql);
                query.setParameter("soLuong", item.getSoLuongSP());
                query.setParameter("id", item.getIdChiTietSP());
                query.executeUpdate();
            }
            trans.commit();
            return true;
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public List<SaleViewSanPhamResponse> findAllByName(String name) {
        List<SaleViewSanPhamResponse> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT new viewmodels.SaleViewSanPhamResponse"
                    + "(a.id, a.sanPham.ma, a.sanPham.ten, a.namBH, a.moTa, a.soLuongTon, a.giaNhap, a.giaBan) "
                    + " FROM ChiTietSP a WHERE a.sanPham.ten LIKE CONCAT('%',:name,'%')";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ChiTietSP findByMa(String ma) {
        throw new UnsupportedOperationException("Chua ho tro ham nay");
    }
    
}
