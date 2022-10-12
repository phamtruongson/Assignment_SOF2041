package services;

import domainmodels.HoaDon;
import java.util.List;
import viewmodels.HoaDonResponse;

public interface HoaDonService {
    
    List<HoaDonResponse> getAll();
    
    List<HoaDonResponse> search(int tinhTrang);
    
    HoaDon createBill();
    
}
