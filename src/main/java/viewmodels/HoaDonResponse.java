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
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonResponse {

    private UUID id;
    private String maHD;
    private Date ngayTao;
    private String tenNV;
    private Integer tinhTrang;

    public Object[] toDataRow(int index) {
        return new Object[]{index, 
            maHD, 
            ngayTao, 
            "sonpt", 
            tinhTrang == 0 ? "Chờ thanh toán" : tinhTrang == 1 ? "Đã thanh toán" : "Hủy"};
    }

}
