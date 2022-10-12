package services;

import java.util.List;
import java.util.UUID;
import viewmodels.SanPhamResponse;

public interface SanPhamService {
    
    List<SanPhamResponse> findAllByName(String name);
    
}