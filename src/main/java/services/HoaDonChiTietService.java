package services;

import java.util.List;
import java.util.UUID;
import viewmodels.HoaDonChiTietResponse;

/**
 *
 * @author sonpt_ph19600
 */
public interface HoaDonChiTietService {
    
    List<HoaDonChiTietResponse> search(UUID idHoaDon);
    
    String pay(List<HoaDonChiTietResponse> list);
    
}
