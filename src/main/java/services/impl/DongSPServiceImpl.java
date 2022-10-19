package services.impl;

import domainmodels.DongSP;
import java.util.List;
import java.util.UUID;
import repositories.DongSPRepository;
import services.DongSPService;
import viewmodels.DongSPResponse;

/**
 *
 * @author sonpt_ph19600
 */
public class DongSPServiceImpl implements DongSPService{
private DongSPRepository dongSPRepository;
    
    public DongSPServiceImpl() {
        dongSPRepository = new DongSPRepository();
    }   

    @Override
    public List<DongSPResponse> getAllResponse() {
        return dongSPRepository.getAllResponse();
    }

    @Override
    public List<DongSP> getAll() {
        return dongSPRepository.getAll();
    }

    @Override
    public String insert(DongSP dongSP) {
        if (dongSP.getMa().isEmpty()) {
            return "Mã không được để trống";
        }
        if (dongSP.getTen().isEmpty()) {
            return "Tên không được để trống";
        }
        DongSP nsxFind = dongSPRepository.findByMa(dongSP.getMa());
        if (nsxFind != null) {
            return "Trùng mã sản phẩm";
        }
        dongSP = dongSPRepository.saveOrUpdate(dongSP);
        if (dongSP != null) {
            return "Thêm thành công";
        } else {
            return "Lỗi hệ thống. Thêm thất bại";
        }
    }

    @Override
    public String update(DongSP dongSP) {
        DongSP dongSPFindByID = dongSPRepository.findById(dongSP.getId());
        if (dongSPFindByID == null) {
            return "NSX không tồn tại";
        }        
        if (dongSP.getMa().isEmpty()) {
            return "Mã không được trống";
        }
        if (dongSP.getTen().isEmpty()) {
            return "Tên không được trống";
        }
        if (!dongSP.getMa().equals(dongSPFindByID.getMa())) {
            DongSP nsxFindByMa = dongSPRepository.findByMa(dongSP.getMa());
            if (nsxFindByMa != null) {
                return "Trùng mã sản phẩm";
            } else {
                dongSPFindByID.setMa(dongSP.getMa());
            }
        }        
        dongSPFindByID.setTen(dongSP.getTen());
        dongSP = dongSPRepository.saveOrUpdate(dongSPFindByID);
        if (dongSP != null) {
            return "Sửa thành công";
        } else {
            return "Lỗi. Sửa thất bại";
        }
    }

    @Override
    public String delete(UUID id) {
        DongSP dongSP = dongSPRepository.findById(id);
        if (dongSP == null) {
            return "NSX không tồn tại";
        }
        if (dongSPRepository.detele(dongSP)) {
            return "Xóa thành công";
        } else {
            return "Lỗi. Xóa thất bại";
        }
    }
    
}
