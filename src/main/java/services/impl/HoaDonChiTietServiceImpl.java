/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.ChiTietSP;
import domainmodels.HoaDon;
import domainmodels.HoaDonChiTiet;
import java.util.List;
import java.util.UUID;
import repositories.ChiTietSPRepository;
import repositories.HoaDonChiTietRepository;
import repositories.HoaDonChiTietRepository;
import repositories.HoaDonRepository;
import services.HoaDonChiTietService;
import viewmodels.HoaDonChiTietResponse;

/**
 *
 * @author sonpt_ph19600
 */
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService{

    private HoaDonChiTietRepository hoaDonChiTietRepository;
    
    private HoaDonRepository hoaDonRepository;
    
    private ChiTietSPRepository chiTietSPRepository;

    public HoaDonChiTietServiceImpl() {
       hoaDonChiTietRepository = new HoaDonChiTietRepository();
       hoaDonRepository = new HoaDonRepository();
       chiTietSPRepository = new ChiTietSPRepository();
    }
    
    @Override
    public List<HoaDonChiTietResponse> search(UUID idHoaDon) {
        return hoaDonChiTietRepository.search(idHoaDon);
    }

    @Override
    public String pay(List<HoaDonChiTietResponse> list) {
        try {
            boolean check = true;
            check = hoaDonRepository.updateTinhTrang(list.get(0).getIdHoaDon(), 1);
            chiTietSPRepository.openTranSaction();
            for (HoaDonChiTietResponse item : list) {
                check = chiTietSPRepository.updateSoLuong(item.getSoLuongSP(), item.getIdChiTietSP());
            }
            chiTietSPRepository.commitTranSaction();
            hoaDonChiTietRepository.openTranSaction();
            for (HoaDonChiTietResponse item : list) {
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setId(item.getIdChiTietSP());
                hoaDonChiTiet.setIdChiTietSP(chiTietSP);
                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(item.getIdHoaDon());
                hoaDonChiTiet.setIdHoaDon(hoaDon);
                hoaDonChiTiet.setSoLuong(item.getSoLuongSP());
                hoaDonChiTiet.setDonGia(item.getDonGia());
                check = hoaDonChiTietRepository.save(hoaDonChiTiet);
            }
            hoaDonChiTietRepository.commitTranSaction();
            if (check == false) {                
                return "Thanh toán thất bại";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Thanh toán thất bại";
        }
        return "Thanh toán thành công";
    }
    
}
