package repositories;

import domainmodels.DongSP;
import java.util.UUID;
import viewmodels.DongSPResponse;

/**
 *
 * @author sonpt_ph19600
 */
public class DongSPRepository extends Repository<DongSP, UUID, DongSPResponse>{

    public DongSPRepository() {
        className = DongSP.class.getName();
        resCon = "new viewmodel.DongSPResponse(a.id, a.ten, a.ma)";
    }
        
}
