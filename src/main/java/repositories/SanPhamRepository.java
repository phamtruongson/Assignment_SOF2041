package repositories;

import domainmodels.SanPham;
import java.util.UUID;
import viewmodels.SanPhamResponse;

/**
 *
 * @author sonpt_ph19600
 */

public class SanPhamRepository extends Repository<SanPham, UUID, SanPhamResponse> {

    public SanPhamRepository() {
        className = SanPham.class.getName();
        resCon = "new viewmodels.SanPhamResponse(a.id, a.ma, a.ten)";
    }

}
