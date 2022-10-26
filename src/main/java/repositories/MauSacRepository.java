package repositories;

import domainmodels.MauSac;
import java.util.UUID;
import viewmodels.MauSacResponse;

/**
 *
 * @author sonpt_ph19600
 */

public class MauSacRepository extends Repository<MauSac, UUID, MauSacResponse> {

    public MauSacRepository() {
        className = MauSac.class.getName();
        resCon = "new viewmodels.MauSacResponse(a.id, a.ma, a.ten)";
    }

}
