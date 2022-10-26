package repositories;

import domainmodels.KhachHang;
import java.util.UUID;
import viewmodels.KhachHangResponse;

/**
 *
 * @author sonpt_ph19600
 */

public class KhachHangRepository extends Repository<KhachHang, UUID, KhachHangResponse>{

    public KhachHangRepository() {
        className = KhachHang.class.getName();
        resCon = "new viewmodels.KhachHangResponse(a.id, a.ma, a.ten, a.tenDem, a.ho, a.ngaySinh, a.sdt, a.diaChi, a.thanhPho, a.quocGia, a.matKhau)";
    }
    
}
