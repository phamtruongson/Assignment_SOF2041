package services.impl;

import java.util.List;
import java.util.UUID;
import repositories.SanPhamRepository;
import services.SanPhamService;
import viewmodels.SanPhamResponse;

/**
 *
 * @author sonpt_ph19600
 */

public class SanPhamServiceImpl implements SanPhamService{
    
    private SanPhamRepository chiTietSPRepository;

    public SanPhamServiceImpl() {
        chiTietSPRepository = new SanPhamRepository();
    }
    
    @Override
    public List<SanPhamResponse> findAllByName(String name) {
        return chiTietSPRepository.findAllByName(name);
    }
    
}
