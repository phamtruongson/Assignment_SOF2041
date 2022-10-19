package repositories;

import domainmodels.NhanVien;
import java.util.UUID;
import viewmodels.NhanVienResponse;

/**
 *
 * @author sonpt_ph19600
 */
public class NhanVienRepository extends Repository<NhanVien, UUID, NhanVienResponse>{

    public NhanVienRepository() {
        className = NhanVien.class.getName();
        resCon = "new viewmodels.NhanVienResponse (a.id, a.ma, a.ten, a.tenDem, a.ho, "
                + "a.gioiTinh, a.ngaySinh, a.diaChi, a.sdt, a.matKhau, "
                + "a.cuaHang.ten, a.chucVu.ten, a.nhanVien.id, a.trangThai)";
    }
    
}
