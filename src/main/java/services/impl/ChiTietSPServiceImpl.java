package services.impl;

import domainmodels.ChiTietSP;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import repositories.ChiTietSPRepository;
import services.ChiTietSPService;
import viewmodels.ChiTietSPResponse;
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

    @Override
    public List<ChiTietSPResponse> getAllResponse() {
        return chiTietSPRepository.getAllResponse();
    }

    @Override
    public List<ChiTietSP> getAll() {
        return chiTietSPRepository.getAll();
    }
    
    public static void main(String[] args) {
        ChiTietSPService sv = new ChiTietSPServiceImpl();
        List<ChiTietSP> lst = sv.getAll();
        for (ChiTietSP x : lst) {
            System.out.println(x.getDongSP().toString());
        }
    }

    @Override
    public String insert(ChiTietSP chiTietSP) {
        if (chiTietSP.getNamBH() <= 0) {
            return "Năm bảo hành phải lớn hơn 0";
        }
        if (chiTietSP.getSoLuongTon() <= 0) {
            return "Số lượng tồn phải lớn hơn 0";
        }
        if (chiTietSP.getGiaBan().compareTo(BigDecimal.ZERO) == -1) {
            return "Giá bán phải là số nguyên dương";
        }
        if (chiTietSP.getGiaNhap().compareTo(BigDecimal.ZERO) == -1) {
            return "Giá nhập phải là số nguyên dương";
        }
        chiTietSP = chiTietSPRepository.saveOrUpdate(chiTietSP);
        if (chiTietSP != null) {
            return "Thêm thành công";
        } else {
            return "Lỗi. Thêm thất bại";
        }
    }

    @Override
    public String update(ChiTietSP chiTietSP) {
        ChiTietSP chiTietSPFind = chiTietSPRepository.findById(chiTietSP.getId());
        System.out.println(chiTietSPFind.toString());
        if (chiTietSPFind == null) {
            return "Chi tiết sản phẩm không tồn tại";
        }
        if (chiTietSP.getNamBH() <= 0) {
            return "Năm bảo hành phải lớn hơn 0";
        }
        if (chiTietSP.getSoLuongTon() <= 0) {
            return "Số lượng tồn phải lớn hơn 0";
        }
        if (chiTietSP.getGiaBan().compareTo(BigDecimal.ZERO) == -1) {
            return "Giá bán phải là số nguyên dương";
        }
        if (chiTietSP.getGiaNhap().compareTo(BigDecimal.ZERO) == -1) {
            return "Giá nhập phải là số nguyên dương";
        }
        chiTietSPFind.setSanPham(chiTietSP.getSanPham());
        chiTietSPFind.setNsx(chiTietSP.getNsx());
        chiTietSPFind.setMauSac(chiTietSP.getMauSac());
        chiTietSPFind.setDongSP(chiTietSP.getDongSP());
        chiTietSPFind.setNamBH(chiTietSP.getNamBH());
        chiTietSPFind.setMoTa(chiTietSP.getMoTa());
        chiTietSPFind.setSoLuongTon(chiTietSP.getSoLuongTon());
        chiTietSPFind.setGiaNhap(chiTietSP.getGiaNhap());
        chiTietSPFind.setGiaBan(chiTietSP.getGiaBan());
        chiTietSP = chiTietSPRepository.saveOrUpdate(chiTietSPFind);
        if (chiTietSP != null) {
            return "Sửa thành công";
        } else {
            return "Lỗi. Sửa thất bại";
        }
    }

    @Override
    public String delete(UUID id) {
        ChiTietSP chiTietSP = chiTietSPRepository.findById(id);
        if (chiTietSP == null) {
            return "Chi tiết sản phẩm không tồn tại";
        }
        if (chiTietSPRepository.detele(chiTietSP)) {
            return "Xóa thành công";
        } else {
            return "Lỗi. Xóa thất bại";
        }
    }
    
    
   
}
