package services.impl;

import domainmodels.KhachHang;
import java.util.List;
import java.util.UUID;
import repositories.KhachHangRepository;
import services.KhachHangService;
import viewmodels.KhachHangResponse;

/**
 *
 * @author sonpt_ph19600
 */

public class KhachHangServiceImpl implements KhachHangService {

    private KhachHangRepository khachHangRepository;

    public KhachHangServiceImpl() {
        khachHangRepository = new KhachHangRepository();
    }

    @Override
    public List<KhachHangResponse> getAllResponse() {
        return khachHangRepository.getAllResponse();
    }

    String pattern = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
//    String pattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})";
    
    @Override
    public String insert(KhachHang khachHang) {
        if (khachHang.getMa().trim().isEmpty()) {
            return "Mã không được trống";
        }
        if (khachHang.getTen().trim().isEmpty()) {
            return "Tên không được trống";
        }
        if (khachHang.getDiaChi().trim().isEmpty()) {
            return "Địa chỉ không được trống";
        }
        if (khachHang.getThanhPho().trim().isEmpty()) {
            return "Thành phố không được trống";
        }
        if (khachHang.getQuocGia().trim().isEmpty()) {
            return "Quốc gia không được trống";
        }
        if (khachHang.getHo().trim().isEmpty()) {
            return "Ho không được trống";
        }
        if (khachHang.getTenDem().trim().isEmpty()) {
            return "Tên đệm không được trống";
        }
        if (khachHang.getSdt().trim().isEmpty()) {
            return "Số điện thoại không được trống";
        }
        try {
            Long.parseLong(khachHang.getSdt());
        } catch (Exception e) {
            return "Số phải là số";
        }
        if (khachHang.getSdt().length() != 10 || !khachHang.getSdt().startsWith("0")) {
            return "Số điện thoại phải 10 số và bắt đầu bằng 0";
        }
        if (khachHang.getMatKhau().trim().isEmpty()) {
            return "Mật khẩu không được trống";
        }
        if(!khachHang.getMatKhau().matches(pattern)){
            return "Mật khẩu sai";
        }
        KhachHang khachHangFind = khachHangRepository.findByMa(khachHang.getMa());
        if (khachHangFind != null) {
            return "Mã không được trùng";
        }
        khachHang = khachHangRepository.saveOrUpdate(khachHang);
        if (khachHang != null) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String delete(UUID id) {
        KhachHang khachHangFind = khachHangRepository.findById(id);
        if (khachHangFind == null) {
            return "Không tìm thấy";
        }
        boolean delete = khachHangRepository.detele(khachHangFind);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String update(KhachHang khachHang) {
        KhachHang khachHangFindById = khachHangRepository.findById(khachHang.getId());
        if (khachHangFindById == null) {
            return "Không tìm thấy";
        }
        if (khachHang.getMa().trim().isEmpty()) {
            return "Mã không được trống";
        }
        if (khachHang.getTen().trim().isEmpty()) {
            return "Tên không được trống";
        }
        if (khachHang.getDiaChi().trim().isEmpty()) {
            return "Địa chỉ không được trống";
        }
        if (khachHang.getThanhPho().trim().isEmpty()) {
            return "Thành phố không được trống";
        }
        if (khachHang.getQuocGia().trim().isEmpty()) {
            return "Quốc gia không được trống";
        }
        if (khachHang.getHo().trim().isEmpty()) {
            return "Họ không được trống";
        }
        if (khachHang.getTenDem().trim().isEmpty()) {
            return "Tên đệm không được trống";
        }
        if (khachHang.getSdt().trim().isEmpty()) {
            return "Số điện thoại không được trống";
        }
        if (khachHang.getSdt().length() != 10 || !khachHang.getSdt().endsWith("0")) {
            return "Số điện thoại phải 10 số và bắt đầu bằng 0";
        }
        if (khachHang.getMatKhau().trim().isEmpty()) {
            return "Mật khẩu không được trống";
        }
        if (!khachHang.getMa().equals(khachHangFindById.getMa())) {
            KhachHang khachHangFindByMa = khachHangRepository.findByMa(khachHang.getMa());
            if (khachHangFindByMa != null) {
                return "Mã không được trùng";
            } else {
                khachHangFindById.setMa(khachHang.getMa());
            }
        }
        khachHangFindById.setTen(khachHang.getTen());
        khachHangFindById.setSdt(khachHang.getSdt());
        khachHangFindById.setHo(khachHang.getHo());
        khachHangFindById.setTenDem(khachHang.getTenDem());
        khachHangFindById.setMatKhau(khachHang.getMatKhau());
        khachHangFindById.setNgaySinh(khachHang.getNgaySinh());
        khachHangFindById.setDiaChi(khachHang.getDiaChi());
        khachHangFindById.setThanhPho(khachHang.getThanhPho());
        khachHangFindById.setQuocGia(khachHang.getQuocGia());
        khachHang = khachHangRepository.saveOrUpdate(khachHangFindById);
        if (khachHang != null) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

}
