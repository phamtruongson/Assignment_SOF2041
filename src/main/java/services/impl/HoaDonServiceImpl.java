package services.impl;

import domainmodels.HoaDon;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import repositories.HoaDonRepository;
import repositories.HoaDonRepository;
import services.HoaDonService;
import viewmodels.HoaDonResponse;

public class HoaDonServiceImpl implements HoaDonService{
    
    private HoaDonRepository hoaDonRepository;

    public HoaDonServiceImpl() {
        hoaDonRepository = new HoaDonRepository();
    }
    
    @Override
    public List<HoaDonResponse> getAll() {
        return hoaDonRepository.getAll();
    }
    
    @Override
    public List<HoaDonResponse> search(int tinhTrang) {
        return hoaDonRepository.findByTinhTrang(tinhTrang);
    }

    @Override
    public HoaDon createBill() {
        LocalDateTime time = LocalDateTime.now();
        String maHd = "HD" + String.valueOf(time.getYear()).substring(2) + time.getMonthValue()
                + time.getDayOfMonth() + time.getHour() + time.getMinute() + time.getSecond();       
        HoaDon hoaDon = new HoaDon();
        hoaDon.setMa(maHd);
        hoaDon.setNgayTao(new Date(new java.util.Date().getTime()));
        hoaDon.setTinhTrang(0);        
        hoaDonRepository.openTranSaction();
        HoaDon check = hoaDonRepository.save(hoaDon);
        hoaDonRepository.save(hoaDon);
        hoaDonRepository.commitTranSaction();
        return check;
    }
    
}
