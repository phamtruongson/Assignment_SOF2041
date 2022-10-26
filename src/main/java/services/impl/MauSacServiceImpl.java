package services.impl;

import domainmodels.MauSac;
import java.util.List;
import java.util.UUID;
import repositories.MauSacRepository;
import services.MauSacService;
import viewmodels.MauSacResponse;

/**
 *
 * @author sonpt_ph19600
 */

public class MauSacServiceImpl implements MauSacService{
    
    private MauSacRepository mauSacRepository;

    public MauSacServiceImpl() {
        mauSacRepository = new MauSacRepository();
    }

    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.getAll();
    }

    @Override
    public List<MauSacResponse> getAllResponse() {
        return mauSacRepository.getAllResponse();
    }

    @Override
    public String insert(MauSac mauSac) {
        if (mauSac.getMa().trim().isEmpty()) {
            return "Mã không được trống";
        }
        if (mauSac.getTen().trim().isEmpty()) {
            return "Tên không được trống";
        }
        MauSac mauSacFind = mauSacRepository.findByMa(mauSac.getMa());
        if (mauSacFind != null) {
            return "Mã không được trùng";
        }
        mauSac = mauSacRepository.saveOrUpdate(mauSac);
        if (mauSac != null) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String delete(UUID id) {
        MauSac mauSacFind = mauSacRepository.findById(id);
        if (mauSacFind == null) {
            return "Không tìm thấy";
        }
        boolean delete = mauSacRepository.detele(mauSacFind);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String update(MauSac mauSac) {
        MauSac mauSacFindById = mauSacRepository.findById(mauSac.getId());
        if (mauSacFindById == null) {
            return "Không tìm thấy";
        }
        if (mauSac.getMa().isEmpty()) {
            return "Tên trống";
        }
        if (mauSac.getTen().isEmpty()) {
            return "Tên trống";
        }
        if (!mauSac.getMa().equals(mauSacFindById.getMa())) {
            MauSac mauSacFindByMa = mauSacRepository.findByMa(mauSac.getMa());
            if (mauSacFindByMa != null) {
                return "Mã không được trùng";
            } else {
                mauSacFindById.setMa(mauSac.getMa());
            }
        }
        mauSacFindById.setTen(mauSac.getTen());
        mauSac = mauSacRepository.saveOrUpdate(mauSacFindById);
        if (mauSac != null) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }
}
