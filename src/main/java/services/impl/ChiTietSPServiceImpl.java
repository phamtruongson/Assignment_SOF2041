package services.impl;

import java.util.UUID;
import repositories.ChiTietSPRepository;
import services.ChiTietSPService;

public class ChiTietSPServiceImpl implements ChiTietSPService{
    
    private ChiTietSPRepository chiTietSPRepository;
    
    public ChiTietSPServiceImpl() {
        chiTietSPRepository = new ChiTietSPRepository();
    }
}
