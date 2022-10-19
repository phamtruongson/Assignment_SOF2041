package services;

import domainmodels.DongSP;
import java.util.List;
import java.util.UUID;
import viewmodels.DongSPResponse;

/**
 *
 * @author sonpt_ph19600
 */
public interface DongSPService {
    
      
    List<DongSPResponse> getAllResponse();
    
    String insert(DongSP nsx);
    
    String update(DongSP nsx);
    
    String delete(UUID id);
    
    List<DongSP> getAll();
    
}
