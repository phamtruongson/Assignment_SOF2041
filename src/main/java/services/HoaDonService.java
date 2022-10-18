package services;

import domainmodels.HoaDon;
import java.util.List;
import viewmodels.SaleViewHoaDonResponse;

/**
 *
 * @author sonpt_ph19600
 */

public interface HoaDonService {
    
    List<SaleViewHoaDonResponse> getAll();
    
    List<SaleViewHoaDonResponse> search(int tinhTrang);
    
    HoaDon createBill();
    
}
