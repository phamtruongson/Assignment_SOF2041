# Assignment_SOF2041
#Bài Assignment môn Dự án mẫu - SOF2041 FPoly Kỳ FALL 2022

#Mô tả Luồng:

##Bắt đầu:

1.Để thêm sản phẩm và thanh toán cần tạo hóa đơn mới hoặc chọn một hóa đơn có trạng thái là chờ thánh toán
2.Khi ấn tạo hóa đơn chương trình sẽ tạo một hóa đơn mới với mã hóa đơn chương trình tự gen, ngày tạo là 
	thời gian hệ thông, trạng thái là chờ thanh toán, idNhanVien có thể fix cứng là một nhân viên nào đó trong bảng nhân viên hoặc để null.
	sau đó insert hóa đơn vừa tạo vào trong DB
3. Load lại table hóa đơn để hiển thị hóa đơn vừa tạo. Và đẩy thông tin hóa đơn vừa được thêm lên Form hóa đơn
4. Chọn SP ở bảng SP và nhập số lượng và thêm vào bảng giỏ hàng và tính tổng ở Form hóa đơn, tính thành tiền của sp vừa đc thêm ở bảng giỏ hàng
5. Chọn nút thanh toán
 5.1 Check xem đã nhập số tiền khách đưa chưa
 5.2 và check xem hóa đơn đang đc chọn có trạng thái là chờ thanh toán không
 5.3 Insert tất cả các SP ở bảng Giỏ hàng với IdHoaDon là hóa đơn đang được chọn vào bảng Hóa đơn chi tiết trong DB
 5.4 Update Trạng thái hóa đơn đang được chọn thành đã thanh toán
 5.5 Cập lại số lượng của các SP có trong Jtable giỏ hàng.
