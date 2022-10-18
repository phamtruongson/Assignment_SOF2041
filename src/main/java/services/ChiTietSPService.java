package services;

import java.util.List;
import java.util.UUID;
import viewmodels.SaleViewSanPhamResponse;

/**
 *
 * @author sonpt_ph19600
 */

public interface ChiTietSPService {
    
    List<SaleViewSanPhamResponse> findAllByName(String name);
    
}
