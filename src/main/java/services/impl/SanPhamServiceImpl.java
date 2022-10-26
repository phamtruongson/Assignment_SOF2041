package services.impl;

import domainmodels.SanPham;
import java.util.List;
import java.util.UUID;
import repositories.SanPhamRepository;
import services.SanPhamService;
import viewmodels.SanPhamResponse;

/**
 *
 * @author sonpt_ph19600
 */

public class SanPhamServiceImpl implements SanPhamService {

    private SanPhamRepository sanPhamRepository;

    public SanPhamServiceImpl() {
        sanPhamRepository = new SanPhamRepository();
    }

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.getAll();
    }

    @Override
    public List<SanPhamResponse> getAllResponse() {
        return sanPhamRepository.getAllResponse();
    }

    @Override
    public String insert(SanPham sanPham) {
        if (sanPham.getMa().trim().isEmpty()) {
            return "Mã không được trống";
        }
        if (sanPham.getTen().trim().isEmpty()) {
            return "Tên không được trống";
        }
        SanPham sanPhamFind = sanPhamRepository.findByMa(sanPham.getMa());
        if (sanPhamFind != null) {
            return "Mã không được trùng";
        }
        sanPham = sanPhamRepository.saveOrUpdate(sanPham);
        if (sanPham != null) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String delete(UUID id) {
        SanPham sanPhamFind = sanPhamRepository.findById(id);
        if (sanPhamFind == null) {
            return "Không tìm thấy";
        }
        boolean delete = sanPhamRepository.detele(sanPhamFind);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String update(SanPham sanPham) {
        SanPham sanPhamFindById = sanPhamRepository.findById(sanPham.getId());
        if (sanPhamFindById == null) {
            return "Không tìm thấy";
        }
        if (sanPham.getMa().isEmpty()) {
            return "Tên trống";
        }
        if (sanPham.getTen().isEmpty()) {
            return "Tên trống";
        }
        if (!sanPham.getMa().equals(sanPhamFindById.getMa())) {
            SanPham sanPhamFindByMa = sanPhamRepository.findByMa(sanPham.getMa());
            if (sanPhamFindByMa != null) {
                return "Mã không được trùng";
            } else {
                sanPhamFindById.setMa(sanPham.getMa());
            }
        }
        sanPhamFindById.setTen(sanPham.getTen());
        sanPham = sanPhamRepository.saveOrUpdate(sanPhamFindById);
        if (sanPham != null) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }
}
