package services.impl;

import java.util.List;
import java.util.UUID;
import repositories.ChiTietSPRepository;
import services.ChiTietSPService;
import viewmodels.SaleViewSanPhamResponse;

/**
 *
 * @author sonpt_ph19600
 */

public class ChiTietSPServiceImpl implements ChiTietSPService{
    
    private ChiTietSPRepository chiTietSPRepository;
    
    public ChiTietSPServiceImpl() {
        chiTietSPRepository = new ChiTietSPRepository();
    }
    
    public List<SaleViewSanPhamResponse> findAllByName(String name){
        return chiTietSPRepository.findAllByName(name);
    }
    
}
