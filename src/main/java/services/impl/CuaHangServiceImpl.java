package services.impl;

import domainmodels.CuaHang;
import repositories.CuaHangRepository;
import java.util.List;
import java.util.UUID;
import services.CuaHangService;
import viewmodels.CuaHangResponse;

/**
 *
 * @author sonpt_ph19600
 */

public class CuaHangServiceImpl implements CuaHangService{

    private CuaHangRepository cuaHangRepository;

    public CuaHangServiceImpl() {
        cuaHangRepository = new CuaHangRepository();
    }

    @Override
    public List<CuaHangResponse> getAllResponse() {
        return cuaHangRepository.getAllResponse();
    }

    @Override
    public String insert(CuaHang cuaHang) {
        if (cuaHang.getMa().trim().isEmpty()) {
            return "Mã không được trống";
        }
        if (cuaHang.getTen().trim().isEmpty()) {
            return "Tên không được trống";
        }
        if (cuaHang.getDiaChi().trim().isEmpty()) {
            return "Địa chỉ không được trống";
        }
        if (cuaHang.getThanhPho().trim().isEmpty()) {
            return "Thành phố không được trống";
        }
        if (cuaHang.getQuocGia().trim().isEmpty()) {
            return "Quốc gia không được trống";
        }
        CuaHang cuaHangFind = cuaHangRepository.findByMa(cuaHang.getMa());
        if (cuaHangFind != null) {
            return "Mã không được trùng";
        }
        cuaHang = cuaHangRepository.saveOrUpdate(cuaHang);
        if (cuaHang != null) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String delete(UUID id) {
        CuaHang cuaHangFind = cuaHangRepository.findById(id);
        if (cuaHangFind == null) {
            return "Không tìm thấy";
        }
        boolean delete = cuaHangRepository.detele(cuaHangFind);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String update(CuaHang cuaHang) {
        CuaHang cuaHangFindById = cuaHangRepository.findById(cuaHang.getId());
        if (cuaHangFindById == null) {
            return "Không tìm thấy";
        }
        if (cuaHang.getMa().isEmpty()) {
            return "Tên trống";
        }
        if (cuaHang.getTen().isEmpty()) {
            return "Tên trống";
        }
        if (!cuaHang.getMa().equals(cuaHangFindById.getMa())) {
            CuaHang cuahangFindByMa = cuaHangRepository.findByMa(cuaHang.getMa());
            if (cuahangFindByMa != null) {
                return "Mã không được trùng";
            } else {
                cuaHangFindById.setMa(cuaHang.getMa());
            }
        }
        cuaHangFindById.setTen(cuaHang.getTen());
        cuaHangFindById.setDiaChi(cuaHang.getDiaChi());
        cuaHangFindById.setThanhPho(cuaHang.getThanhPho());
        cuaHangFindById.setQuocGia(cuaHang.getQuocGia());
        cuaHang = cuaHangRepository.saveOrUpdate(cuaHangFindById);
        if (cuaHang != null) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }
    
}
