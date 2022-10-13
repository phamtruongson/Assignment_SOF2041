package repositories;

import domainmodels.ChiTietSP;
import utils.HibernateUtil;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repositories.Repository;

/**
 *
 * @author sonpt_ph19600
 */

public class ChiTietSPRepository extends Repository{
    
    public boolean updateSoLuong(int soLuong, UUID id) {
        try {
            Query query = session.createQuery("UPDATE ChiTietSP SET SoLuongTon = SoLuongTon - :soLuong"
                    + " WHERE id = :id");
            query.setParameter("soLuong", soLuong);
            query.setParameter("id", id);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            trans.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }
    
}
