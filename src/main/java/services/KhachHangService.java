package services;

import domainmodels.KhachHang;
import java.util.List;
import java.util.UUID;
import viewmodels.KhachHangResponse;

/**
 *
 * @author sonpt_ph19600
 */

public interface KhachHangService {

    List<KhachHangResponse> getAllResponse();

    String insert(KhachHang khachHang);

    String delete(UUID id);

    String update(KhachHang khachHang);
}
