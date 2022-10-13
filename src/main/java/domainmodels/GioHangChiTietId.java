package domainmodels;

import java.io.Serializable;
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
public class GioHangChiTietId implements Serializable{
    
    private UUID IdGioHang;
    
    private UUID IdChiTietSP;
}
