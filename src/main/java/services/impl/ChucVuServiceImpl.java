package services.impl;

import domainmodels.ChucVu;
import java.util.List;
import java.util.UUID;
import repositories.ChucVuRepository;
import services.ChucVuService;
import viewmodels.ChucVuResponse;

/**
 *
 * @author sonpt_ph19600
 */

public class ChucVuServiceImpl implements ChucVuService {

    private ChucVuRepository chucVuRepository;

    public ChucVuServiceImpl() {
        chucVuRepository = new ChucVuRepository();
    }

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.getAll();
    }

    @Override
    public List<ChucVuResponse> getAllResponse() {
        return chucVuRepository.getAllResponse();
    }

    @Override
    public String insert(ChucVu chucVu) {
        if (chucVu.getMa().trim().isEmpty()) {
            return "Mã không được trống";
        }
        if (chucVu.getTen().trim().isEmpty()) {
            return "Tên không được trống";
        }
        ChucVu chucVuFind = chucVuRepository.findByMa(chucVu.getMa());
        if (chucVuFind != null) {
            return "Mã không được trùng";
        }
        chucVu = chucVuRepository.saveOrUpdate(chucVu);
        if (chucVu != null) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String delete(UUID id) {
        ChucVu chucVuFind = chucVuRepository.findById(id);
        if (chucVuFind == null) {
            return "Không tìm thấy";
        }
        boolean delete = chucVuRepository.detele(chucVuFind);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String update(ChucVu chucVu) {
        ChucVu chucVuFindById = chucVuRepository.findById(chucVu.getId());
        if (chucVuFindById == null) {
            return "Không tìm thấy";
        }
        if (chucVu.getMa().isEmpty()) {
            return "Tên trống";
        }
        if (chucVu.getTen().isEmpty()) {
            return "Tên trống";
        }
        if (!chucVu.getMa().equals(chucVuFindById.getMa())) {
            ChucVu chucVuFindByMa = chucVuRepository.findByMa(chucVu.getMa());
            if (chucVuFindByMa != null) {
                return "Mã không được trùng";
            } else {
                chucVuFindById.setMa(chucVu.getMa());
            }
        }
        chucVuFindById.setTen(chucVu.getTen());
        chucVu = chucVuRepository.saveOrUpdate(chucVuFindById);
        if (chucVu != null) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

}
