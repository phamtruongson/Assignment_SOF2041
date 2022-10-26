package repositories;

import domainmodels.CuaHang;
import java.util.List;
import java.util.UUID;
import viewmodels.CuaHangResponse;

/**
 *
 * @author sonpt_ph19600
 */

public class CuaHangRepository extends Repository<CuaHang, UUID, CuaHangResponse>{

    public CuaHangRepository() {
        className = CuaHang.class.getName();
        resCon = "new viewmodels.CuaHangResponse(a.id, a.ma, a.ten, a.diaChi, a.thanhPho, a.quocGia)";
    }
    
}
