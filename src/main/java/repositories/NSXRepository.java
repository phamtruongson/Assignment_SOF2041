package repositories;

import domainmodels.NSX;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import utils.HibernateUtil;
import viewmodels.NSXResponse;

/**
 *
 * @author sonpt_ph19600
 */
public class NSXRepository extends Repository<NSX, UUID, NSXResponse> {

    public NSXRepository() {
        className = NSX.class.getName();
        resCon = "new viewmodels.NSXResponse (a.id, a.ma, a.ten)";
    }

}
