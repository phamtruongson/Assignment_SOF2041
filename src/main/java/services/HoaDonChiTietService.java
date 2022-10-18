package services;

import java.util.List;
import java.util.UUID;
import viewmodels.SaleViewHoaDonChiTietResponse;

/**
 *
 * @author sonpt_ph19600
 */

public interface HoaDonChiTietService {
    
    List<SaleViewHoaDonChiTietResponse> search(UUID idHoaDon);
    
    String pay(List<SaleViewHoaDonChiTietResponse> list);
    
}
