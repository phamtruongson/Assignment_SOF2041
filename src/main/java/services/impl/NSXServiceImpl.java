package services.impl;

import domainmodels.NSX;
import java.util.List;
import java.util.UUID;
import repositories.NSXRepository;
import repositories.Repository;
import services.NSXService;
import viewmodels.NSXResponse;

/**
 *
 * @author sonpt_ph19600
 */
public class NSXServiceImpl implements NSXService{

    private NSXRepository nSXRepository;
    
    public NSXServiceImpl() {
        nSXRepository = new NSXRepository();
    }   

    @Override
    public List<NSXResponse> getAllResponse() {
        return nSXRepository.getAllResponse();
    }

    @Override
    public List<NSX> getAll() {
        return nSXRepository.getAll();
    }

    @Override
    public String insert(NSX nsx) {
        if (nsx.getMa().isEmpty()) {
            return "Mã không được để trống";
        }
        if (nsx.getTen().isEmpty()) {
            return "Tên không được để trống";
        }
        NSX nsxFind = nSXRepository.findByMa(nsx.getMa());
        if (nsxFind != null) {
            return "Trùng mã dòng sản phẩm";
        }
        nsx = nSXRepository.saveOrUpdate(nsx);
        if (nsx != null) {
            return "Thêm thành công";
        } else {
            return "Lỗi hệ thống. Thêm thất bại";
        }
    }

    @Override
    public String update(NSX nsx) {
        NSX nsxFindByID = nSXRepository.findById(nsx.getId());
        if (nsxFindByID == null) {
            return "Dòng sản phẩm không tồn tại";
        }        
        if (nsx.getMa().isEmpty()) {
            return "Mã không được trống";
        }
        if (nsx.getTen().isEmpty()) {
            return "Tên không được trống";
        }
        if (!nsx.getMa().equals(nsxFindByID.getMa())) {
            NSX nsxFindByMa = nSXRepository.findByMa(nsx.getMa());
            if (nsxFindByMa != null) {
                return "Trùng mã dòng sản phẩm";
            } else {
                nsxFindByID.setMa(nsx.getMa());
            }
        }        
        nsxFindByID.setTen(nsx.getTen());
        nsx = nSXRepository.saveOrUpdate(nsxFindByID);
        if (nsx != null) {
            return "Sửa thành công";
        } else {
            return "Lỗi. Sửa thất bại";
        }
    }

    @Override
    public String delete(UUID id) {
        NSX nsxFind = nSXRepository.findById(id);
        if (nsxFind == null) {
            return "Dòng sản phẩm không tồn tại";
        }
        if (nSXRepository.detele(nsxFind)) {
            return "Xóa thành công";
        } else {
            return "Lỗi. Xóa thất bại";
        }
    }
    
}
