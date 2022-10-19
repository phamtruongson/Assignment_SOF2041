package services;

import domainmodels.ChiTietSP;
import java.util.List;
import java.util.UUID;
import viewmodels.ChiTietSPResponse;
import viewmodels.SaleViewSanPhamResponse;

/**
 *
 * @author sonpt_ph19600
 */

public interface ChiTietSPService {
    
    List<SaleViewSanPhamResponse> findAllByName(String name);
    
    List<ChiTietSPResponse> getAllResponse();
    
    List<ChiTietSP> getAll();
    
    String insert(ChiTietSP chiTietSP);
    
    String update(ChiTietSP chiTietSP);
    
    String delete(UUID id);
    
}
