package domainmodels;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "ChiTietSP")
public class ChiTietSP implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private UUID id;
    
    @ManyToOne
    @JoinColumn(name = "IdSP")
    private SanPham sanPham;
    
    @ManyToOne
    @JoinColumn(name = "IdNsx")
    private NSX nsx;
    
    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;
    
    @ManyToOne
    @JoinColumn(name = "IdDongSP")
    private DongSP dongSP;
    
    @Column(name = "NamBH")
    private Integer namBH;
    
    @Column(name = "MoTa")
    private String moTa;
    
    @Column(name = "SoLuongTon")
    private Integer soLuongTon;
    
    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;
    
    @Column(name = "GiaBan")
    private BigDecimal giaBan;
    
}
