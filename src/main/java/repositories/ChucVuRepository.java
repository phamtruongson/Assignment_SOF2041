package repositories;

import domainmodels.ChucVu;
import java.util.UUID;
import repositories.Repository;
import viewmodels.ChucVuResponse;

/**
 *
 * @author sonpt_ph19600
 */

public class ChucVuRepository extends Repository<ChucVu, UUID, ChucVuResponse> {

    public ChucVuRepository() {
        className = ChucVu.class.getName();
        resCon = "new viewmodels.ChucVuResponse(a.id, a.ma, a.ten)";
    }

}
