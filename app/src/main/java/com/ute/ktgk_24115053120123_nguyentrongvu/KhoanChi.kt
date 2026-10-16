package com.ute.ktgk_24115053120123_nguyentrongvu

import java.io.Serializable

data class KhoanChi(
    var maKhoanChi: String,
    var tenKhoanChi: String,
    var soTien: Double,
    var ghiChu: String,
    var daThanhToan: Boolean = false
) : Serializable {

    fun layThongTin_123(): String {
        val trangThai_123 = if (daThanhToan) "Đã thanh toán" else "Chưa thanh toán"
        return "Mã khoản chi: $maKhoanChi\n" +
                "Tên khoản chi: $tenKhoanChi\n" +
                "Số tiền: ${soTien.toLong()} VNĐ\n" +
                "Ghi chú: $ghiChu\n" +
                "Trạng thái: $trangThai_123"
    }

    fun laSoTienHopLe_123(): Boolean {
        return soTien > 0
    }
}