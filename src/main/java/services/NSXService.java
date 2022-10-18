package services;

import domainmodels.NSX;
import java.util.List;
import java.util.UUID;
import viewmodels.NSXResponse;

/**
 *
 * @author sonpt_ph19600
 */
public interface NSXService {
    
    List<NSXResponse> getAll();
    
    String insert(NSX nsx);
    
    String update(NSX nsx);
    
    String delete(UUID id);
    
}
