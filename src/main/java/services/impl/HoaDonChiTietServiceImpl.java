/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.ChiTietSP;
import domainmodels.HoaDon;
import domainmodels.HoaDonChiTiet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repositories.ChiTietSPRepository;
import repositories.HoaDonChiTietRepository;
import repositories.HoaDonChiTietRepository;
import repositories.HoaDonRepository;
import services.HoaDonChiTietService;
import viewmodels.SaleViewHoaDonChiTietResponse;

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
    public List<SaleViewHoaDonChiTietResponse> search(UUID idHoaDon) {
        return hoaDonChiTietRepository.findCustomById(idHoaDon);
    }

    @Override
    public String pay(List<SaleViewHoaDonChiTietResponse> list) {
        try {
            boolean check = true;
            check = hoaDonRepository.updateTinhTrang(list.get(0).getIdHoaDon(), 1);
            check = chiTietSPRepository.updateSoLuong(list);
            List<HoaDonChiTiet> listHoaDonChiTiet = new ArrayList<>();
            for (SaleViewHoaDonChiTietResponse item : list) {
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                
                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setId(item.getIdChiTietSP());
                hoaDonChiTiet.setIdChiTietSP(chiTietSP);
                
                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(item.getIdHoaDon());
                
                hoaDonChiTiet.setIdHoaDon(hoaDon);
                hoaDonChiTiet.setSoLuong(item.getSoLuongSP());
                hoaDonChiTiet.setDonGia(item.getDonGia());
                
                listHoaDonChiTiet.add(hoaDonChiTiet);
            }
            check = hoaDonChiTietRepository.saveAll(listHoaDonChiTiet);
            if (check == false) {                
                return "Thanh to??n th???t b???i";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Thanh to??n th???t b???i";
        }
        return "Thanh to??n th??nh c??ng";
    }
    
}
