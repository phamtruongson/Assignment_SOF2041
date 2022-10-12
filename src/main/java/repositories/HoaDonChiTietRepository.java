package repositories;

import domainmodels.HoaDonChiTiet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.lang.model.SourceVersion;
import javax.persistence.Query;
import viewmodels.HoaDonChiTietResponse;
import repositories.Repository;
import utils.HibernateUtil;

/**
 *
 * @author sonpt_ph19600
 */
public class HoaDonChiTietRepository extends Repository{

    public List<HoaDonChiTietResponse> search(UUID idHoaDon) {
        List<HoaDonChiTietResponse> list = new ArrayList<>();
        try{
            session = HibernateUtil.getFACTORY().openSession();
            String hql = "SELECT new viewmodels.HoaDonChiTietResponse "
                    + "(a.IdChiTietSP.id, a.IdHoaDon.id, a.IdChiTietSP.sanPham.ma, "
                    + "a.IdChiTietSP.sanPham.ten, a.soLuong, a.donGia) "
                    + "FROM HoaDonChiTiet a WHERE a.IdHoaDon.id = :id";

            Query query = session.createQuery(hql);
            query.setParameter("id", idHoaDon);
            list = query.getResultList();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean save(HoaDonChiTiet hoaDonChiTiet) {
        try {
            session.save(hoaDonChiTiet);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            session.close();
            return false;
        }
    }
}
