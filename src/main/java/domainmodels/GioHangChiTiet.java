package domainmodels;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author sonpt_ph19600
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "GioHangChiTiet")
@IdClass(GioHangChiTietId.class)
public class GioHangChiTiet implements Serializable{
    
    @Id
    @ManyToOne
    @JoinColumn(name = "IdGioHang", nullable = false)
    private GioHang IdGioHang;

    @Id
    @ManyToOne
    @JoinColumn(name = "IdChiTietSP", nullable = false)
    private ChiTietSP IdChiTietSP;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;
    
    @Column(name = "DonGiaKhiGiam")
    private BigDecimal donGiaKhiGiam;
}
