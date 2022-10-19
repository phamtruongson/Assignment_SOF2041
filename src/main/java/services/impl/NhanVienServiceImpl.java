package services.impl;

import domainmodels.NhanVien;
import java.sql.Date;
import java.util.List;
import java.util.UUID;
import repositories.NhanVienRepository;
import services.NhanVienService;
import viewmodels.NhanVienResponse;

/**
 *
 * @author sonpt_ph19600
 */
public class NhanVienServiceImpl implements NhanVienService {

    private NhanVienRepository nhanVienRepository;

    public NhanVienServiceImpl() {
        nhanVienRepository = new NhanVienRepository();
    }

    @Override
    public List<NhanVienResponse> getAllResponse() {
        return nhanVienRepository.getAllResponse();
    }

    @Override
    public String insert(NhanVien nhanVien) {
        if (nhanVien.getMa().isEmpty()) {
            return "Mã không được để trống";
        }
        NhanVien nhanVienFind = nhanVienRepository.findByMa(nhanVien.getMa());
        if (nhanVienFind != null) {
            return "Trùng mã nhân viên";
        }
        if (nhanVien.getTen().isEmpty()) {
            return "Tên không được để trống";
        }
        if (nhanVien.getTenDem().isEmpty()) {
            return "Tên đệm không được để trống";
        }
        if (nhanVien.getHo().isEmpty()) {
            return "Họ không được để trống";
        }
        if (nhanVien.getGioiTinh().isEmpty()) {
            return "Giới tính không được để trống";
        }
        if (nhanVien.getDiaChi().isEmpty()) {
            return "Địa chỉ không được để trống";
        }
        if (nhanVien.getSdt().isEmpty()) {
            return "Số điện thoại không được để trống";
        }
        if (nhanVien.getMatKhau().isEmpty()) {
            return "Mật khẩu không được để trống";
        }
        if (nhanVienRepository.saveOrUpdate(nhanVien) == null) {
            return "Lỗi. Thêm thất bại";
        } else {
            return "Thêm thành công";
        }
    }

    @Override
    public String update(NhanVien nhanVien) {
        NhanVien nhanVienFindById = nhanVienRepository.findById(nhanVien.getId());
        if (nhanVienFindById == null) {
            return "Nhân viên không tồn tại";
        }
        if (nhanVien.getMa().isEmpty()) {
            return "Mã không được để trống";
        }
        System.out.println("find: " + nhanVienFindById.getMa());
        System.out.println("a: " + nhanVien.getMa());
        if (!nhanVien.getMa().equals(nhanVienFindById.getMa())) {
            NhanVien nhanVienFindByMa = nhanVienRepository.findByMa(nhanVien.getMa());
            if (nhanVienFindByMa != null) {
                return "Trùng mã nhân viên";
            } else {
                nhanVienFindById.setMa(nhanVien.getMa());
            }
        }
        if (nhanVien.getTen().isEmpty()) {
            return "Tên không được để trống";
        }
        if (nhanVien.getTenDem().isEmpty()) {
            return "Tên đệm không được để trống";
        }
        if (nhanVien.getHo().isEmpty()) {
            return "Họ không được để trống";
        }
        if (nhanVien.getGioiTinh().isEmpty()) {
            return "Giới tính không được để trống";
        }
        if (nhanVien.getDiaChi().isEmpty()) {
            return "Địa chỉ không được để trống";
        }
        if (nhanVien.getSdt().isEmpty()) {
            return "Số điện thoại không được để trống";
        }
        if (nhanVien.getMatKhau().isEmpty()) {
            return "Mật khẩu không được để trống";
        }
        nhanVienFindById.setTen(nhanVien.getTen());
        nhanVienFindById.setTenDem(nhanVien.getTenDem());
        nhanVienFindById.setHo(nhanVien.getHo());
        nhanVienFindById.setGioiTinh(nhanVien.getGioiTinh());
        nhanVienFindById.setNgaySinh(nhanVien.getNgaySinh());
        nhanVienFindById.setDiaChi(nhanVien.getDiaChi());
        nhanVienFindById.setSdt(nhanVien.getSdt());
        nhanVienFindById.setMatKhau(nhanVien.getMatKhau());
        nhanVienFindById.setCuaHang(nhanVien.getCuaHang());
        nhanVienFindById.setChucVu(nhanVien.getChucVu());
        nhanVienFindById.setTrangThai(nhanVien.getTrangThai());
        if (nhanVienRepository.saveOrUpdate(nhanVienFindById) == null) {
            return "Lỗi. Sửa thất bại";
        } else {
            return "Sửa thành công";
        }
    }
    
    public static void main(String[] args) {
        NhanVienRepository repo = new NhanVienRepository();
        
        NhanVien nv = new NhanVien();
        NhanVienService sv = new NhanVienServiceImpl();
        nv.setId(repo.findByMa("a1").getId());
        nv.setMa("a1");
        nv.setTen("b");
        nv.setHo("b");
        nv.setTenDem("c");
        nv.setGioiTinh("d");
        nv.setNgaySinh(new java.util.Date());
        nv.setDiaChi("e");
        nv.setSdt("abc");
        nv.setMatKhau("f");
        nv.setNhanVien(nv);
        nv.setTrangThai(1);
        System.out.println(sv.delete(nv.getId()));
        List<NhanVien> lst = sv.getAll();
        System.out.println(lst.size());
        for (NhanVien nhanVien : lst) {
            
                System.out.println(nhanVien.getNhanVien().toString());            
            
        }
    }

    @Override
    public String delete(UUID id) {
        NhanVien nhanVien = nhanVienRepository.findById(id);
        if (nhanVien == null) {
            return "Nhân viên không tồn tại";
        }
        if (nhanVienRepository.detele(nhanVien)) {
            return "Xóa thành công";
        } else {
            return "Lỗi. Xóa thất bại";
        }
    }

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.getAll();
    }

}
