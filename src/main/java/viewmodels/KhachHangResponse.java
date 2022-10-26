package viewmodels;

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
@AllArgsConstructor
@NoArgsConstructor
public class KhachHangResponse {

    private UUID id;
    private String ma;
    private String ten;
    private String tenDem;
    private String ho;
    private Date ngaySinh;
    private String sdt;
    private String diaChi;
    private String thanhPho;
    private String quocGia;
    private String matKhau;

    public Object[] toDataRow(int index) {
        return new Object[]{index, ma, ten, tenDem, ho, ngaySinh, sdt, diaChi, thanhPho, quocGia, matKhau};
    }
}
