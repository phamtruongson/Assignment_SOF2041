package services;

import domainmodels.ChucVu;
import java.util.List;
import java.util.UUID;
import viewmodels.ChucVuResponse;

/**
 *
 * @author sonpt_ph19600
 */

public interface ChucVuService {

    List<ChucVuResponse> getAllResponse();

    String insert(ChucVu chucVu);

    String delete(UUID id);

    String update(ChucVu chucVu);
    
    List<ChucVu> getAll();
}
