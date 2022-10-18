package repositories;

import domainmodels.HoaDonChiTiet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.lang.model.SourceVersion;
import javax.persistence.Query;
import viewmodels.SaleViewHoaDonChiTietResponse;
import repositories.Repository;
import utils.HibernateUtil;

/**
 *
 * @author sonpt_ph19600
 */
public class HoaDonChiTietRepository extends Repository<HoaDonChiTiet, UUID, SaleViewHoaDonChiTietResponse>{

    public List<SaleViewHoaDonChiTietResponse> findCustomById(UUID idHoaDon) {
        List<SaleViewHoaDonChiTietResponse> list = new ArrayList<>();
        try{
            session = HibernateUtil.getSession();
            String hql = "SELECT new viewmodels.SaleViewHoaDonChiTietResponse "
                    + "(a.IdChiTietSP.id, a.IdHoaDon.id, a.IdChiTietSP.sanPham.ma, "
                    + "a.IdChiTietSP.sanPham.ten, a.soLuong, a.donGia) "
                    + "FROM HoaDonChiTiet a WHERE a.IdHoaDon.id = :id";

            Query query = session.createQuery(hql);
            query.setParameter("id", idHoaDon);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
