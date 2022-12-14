package services.impl;

import domainmodels.HoaDon;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import repositories.HoaDonRepository;
import repositories.HoaDonRepository;
import services.HoaDonService;
import viewmodels.SaleViewHoaDonResponse;

/**
 *
 * @author sonpt_ph19600
 */

public class HoaDonServiceImpl implements HoaDonService{
    
    private HoaDonRepository hoaDonRepository;

    public HoaDonServiceImpl() {
        hoaDonRepository = new HoaDonRepository();
    }
    
    @Override
    public List<SaleViewHoaDonResponse> getAll() {
        return hoaDonRepository.getAllResponse();
    }
    
    @Override
    public List<SaleViewHoaDonResponse> search(int tinhTrang) {
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
        HoaDon check = hoaDonRepository.saveOrUpdate(hoaDon);
        return check;
    }
    
}
