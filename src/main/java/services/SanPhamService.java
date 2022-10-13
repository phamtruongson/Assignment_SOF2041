package services;

import java.util.List;
import java.util.UUID;
import viewmodels.SanPhamResponse;

/**
 *
 * @author sonpt_ph19600
 */

public interface SanPhamService {
    
    List<SanPhamResponse> findAllByName(String name);
    
}