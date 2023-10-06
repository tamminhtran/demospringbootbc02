# demospringbootbc02
cybersoft

Warehouse validation rule: 
- Chỉ cho phép generate serial nếu số lượng serial yêu cầu tạo <= sức chứa hiện tại của warehouse. Sức chứa hiện tại = capacity - tổng số lượng serial đã nhập kho
- Chỉ cho phép serial nhập kho nếu effective from <= thời gian nhập kho <= effective to của warehouse
- Một warehouse chỉ có 1 discount type duy nhất, không cho phép cập nhật discount type của warehouse


Serial
- Thời gian valid của serial thuộc khoảng effective from - effective to của warehouse
- Một serial tại 1 thời điểm chỉ có 1 status duy nhất. Khi mới nhập kho serial ở stt: new. Khi được user mua -> stt = owned. Khi user sử dụng -> stt = used. Khi hết hạn (xét theo effective to của warehouse) -> stt = expired
- User chỉ được phép sử dụng serial khi ở trạng thái owned. Khi user sử dụng serial, kiểm tra effective from-to, stt của warehouse, stt của store/ merchant/ chain (stt của cả issuer/ acquirer). Nếu valid thì cho phép user sử dụng
- Khi generate serial, dùng logic gen random. 1 serial có độ dài 12 kí tự, bao gồm A-Z và 0-9. Không được phép gen theo dạng auto_increment để tránh trường hợp cheat hack


Ticket: 
- Trạng thái của ticket = owned khi user đang sở hữu và = expired khi serial hết hạn

Ticket history:
- Ghi nhận từng sự kiện. Ví dụ: Khi user mua serial -> ghi nhận 1 dòng dữ liệu ticket_id 1 + stt = owned + thời điểm user sở hữu. Khi user sử dụng, ghi nhận 1 dòng dữ liệu ticket_id 1 + stt = used + thời điểm used. Tương tự đối với trường hợp expired

Order: 
- Có 2 trạng thái: thành công/ thất bại
