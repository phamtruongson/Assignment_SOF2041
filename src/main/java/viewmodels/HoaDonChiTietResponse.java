package viewmodels;

import java.math.BigDecimal;
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
public class HoaDonChiTietResponse {

    private UUID idChiTietSP;
    private UUID idHoaDon;
    private String maSP;
    private String tenSP;
    private Integer soLuongSP;
    private BigDecimal donGia;

    public Object[] toDataRow(int index) {
        return new Object[]{index, maSP, tenSP, soLuongSP, donGia,new BigDecimal(soLuongSP).multiply(donGia)};
    }
}
