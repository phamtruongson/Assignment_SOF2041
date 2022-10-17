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

    private NSXRepository repository;
    
    public NSXServiceImpl() {
        repository = new NSXRepository();
    }   

    @Override
    public List<NSXResponse> getAll() {
        return repository.getAll();
    }

    @Override
    public String save(NSX nsx) {
        NSX nsxFind = repository.findByMa(nsx.getMa());
        if (nsxFind != null) {
            return "Trùng mã sản phẩm";
        }
        if (repository.saveOrUpdate(nsx)) {
            return "Thêm thành công";
        } else {
            return "Lỗi hệ thống. Thêm thất bại";
        }
    }

    @Override
    public String update(NSX nsx) {
        NSX nsxFind = repository.findById(nsx.getId());
        if (nsxFind == null) {
            return "NSX không tồn tại";
        }
        nsxFind.setMa(nsx.getMa());
        nsxFind.setTen(nsx.getTen());
        if (repository.saveOrUpdate(nsxFind)) {
            return "Sửa thành công";
        } else {
            return "Lỗi. Sửa thất bại";
        }
    }

    @Override
    public String delete(UUID id) {
        NSX nsxFind = repository.findById(id);
        if (nsxFind == null) {
            return "NSX không tồn tại";
        }
        if (repository.detele(nsxFind)) {
            return "Xóa thành công";
        } else {
            return "Lỗi. Xóa thất bại";
        }
    }
    
}
