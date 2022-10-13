package services.impl;

import java.util.UUID;
import repositories.ChiTietSPRepository;
import services.ChiTietSPService;

/**
 *
 * @author sonpt_ph19600
 */

public class ChiTietSPServiceImpl implements ChiTietSPService{
    
    private ChiTietSPRepository chiTietSPRepository;
    
    public ChiTietSPServiceImpl() {
        chiTietSPRepository = new ChiTietSPRepository();
    }
}
