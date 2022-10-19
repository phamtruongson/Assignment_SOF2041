/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietSPResponse {
    private UUID id;
    private String tenSP;
    private String tenNSX;
    private String tenMauSac;
    private String tenDongSP;
    private Integer namBH;
    private String moTa;
    private Integer soLuongTon;
    private BigDecimal giaBan;
    private BigDecimal giaNhap;
    
    public Object[] toDataRow(int index){
        return new Object[]{index, tenSP, tenNSX, tenMauSac, tenDongSP, namBH, moTa, soLuongTon, giaBan, giaNhap};
    }
}
