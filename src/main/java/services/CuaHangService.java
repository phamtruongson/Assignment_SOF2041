package services;

import viewmodels.CuaHangResponse;
import domainmodels.CuaHang;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author sonpt_ph19600
 */

public interface CuaHangService {

    List<CuaHangResponse> getAllResponse();

    String insert(CuaHang cuaHang);

    String delete(UUID id);

    String update(CuaHang cuaHang);
}
