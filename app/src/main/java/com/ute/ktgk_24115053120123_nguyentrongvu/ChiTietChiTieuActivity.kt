package com.ute.ktgk_24115053120123_nguyentrongvu

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChiTietChiTieuActivity : AppCompatActivity() {

    private lateinit var tvNoiDungChiTiet_123: TextView
    private lateinit var btnChinhSua_123: Button
    private lateinit var btnQuayLai_123: Button

    // Biến lưu thông tin khoản chi nhận được
    var tenKhoanChi_123: String = ""
    var soTien_123: Double = 0.0
    var ghiChu_123: String = ""
    var daThanhToan_123: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_chi_tieu)

        supportActionBar?.title = "Nguyen Trong Vu - 24115053120123 - Quản lý chi tiêu cá nhân"

        tvNoiDungChiTiet_123 = findViewById(R.id.tvNoiDungChiTiet_123)
        btnChinhSua_123 = findViewById(R.id.btnChinhSua_123)
        btnQuayLai_123 = findViewById(R.id.btnQuayLai_123)

        nhanVaHienThiDuLieu_123()

        btnQuayLai_123.setOnClickListener {
            finish()
        }
    }

    private fun nhanVaHienThiDuLieu_123() {
        tenKhoanChi_123 = intent.getStringExtra("EXTRA_TEN_123") ?: ""
        soTien_123 = intent.getDoubleExtra("EXTRA_TIEN_123", -1.0)
        ghiChu_123 = intent.getStringExtra("EXTRA_GHICHU_123") ?: ""
        daThanhToan_123 = intent.getBooleanExtra("EXTRA_THANHTOAN_123", false)

        // Xử lý trường hợp thiếu hoặc sai dữ liệu
        if (tenKhoanChi_123.isBlank() || soTien_123 <= 0) {
            tvNoiDungChiTiet_123.text = "Lỗi: Không nhận được tên khoản chi hoặc số tiền không hợp lệ!"
            Toast.makeText(this, "Dữ liệu không hợp lệ!", Toast.LENGTH_LONG).show()
        } else {
            val trangThai_123 = if (daThanhToan_123) "Đã thanh toán" else "Chưa thanh toán"
            tvNoiDungChiTiet_123.text = "Tên khoản chi: $tenKhoanChi_123\n" +
                    "Số tiền: ${soTien_123.toLong()} VNĐ\n" +
                    "Ghi chú: $ghiChu_123\n" +
                    "Trạng thái: $trangThai_123"
        }
    }
}