package viewmodels;

import domainmodels.NhanVien;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author sonpt_ph19600
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienResponse {
    
    private UUID id;
    private String ma;
    private String ten;
    private String tenDem;
    private String ho;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String matKhau;
    private String tenCH;
    private String tenCV;
    private UUID idGuiBC;
    private Integer trangThai;
    
    public Object[] toDataRow(int index) {
        return new Object[]{index, ma, ten, tenDem, ho, gioiTinh, ngaySinh, diaChi, sdt, matKhau, tenCH, tenCV, idGuiBC, trangThai};
    }
    
}
