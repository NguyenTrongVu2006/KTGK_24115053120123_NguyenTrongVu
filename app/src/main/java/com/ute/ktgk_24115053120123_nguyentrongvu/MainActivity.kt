package com.ute.ktgk_24115053120123_nguyentrongvu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Khai báo biến giao diện có hậu tố _123 theo quy tắc
    private lateinit var edtTenKhoanChi_123: EditText
    private lateinit var edtSoTien_123: EditText
    private lateinit var edtGhiChu_123: EditText
    private lateinit var btnThemKhoanChi_123: Button
    private lateinit var btnXemChiTiet_123: Button

    // Các biến lưu trữ dữ liệu tạm thời cho Câu 1
    private var tenKhoanChi_123: String = "Tiền thuê trọ tháng 10"
    private var soTien_123: Double = 1500000.0
    private var ghiChu_123: String = "Đã chuyển khoản qua Internet Banking"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tiêu đề Toolbar bắt buộc theo đề bài
        supportActionBar?.title = "Nguyen Trong Vu - 24115053120123 - Quản lý chi tiêu cá nhân"

        khoiTaoView_123()
        xuLySuKien_123()
    }

    private fun khoiTaoView_123() {
        edtTenKhoanChi_123 = findViewById(R.id.edtTenKhoanChi_123)
        edtSoTien_123 = findViewById(R.id.edtSoTien_123)
        edtGhiChu_123 = findViewById(R.id.edtGhiChu_123)
        btnThemKhoanChi_123 = findViewById(R.id.btnThemKhoanChi_123)
        btnXemChiTiet_123 = findViewById(R.id.btnXemChiTiet_123)

        // Điền sẵn dữ liệu mẫu ban đầu tránh trùng lặp
        edtTenKhoanChi_123.setText(tenKhoanChi_123)
        edtSoTien_123.setText(soTien_123.toLong().toString())
        edtGhiChu_123.setText(ghiChu_123)
    }

    private fun xuLySuKien_123() {
        // Xử lý nút Thêm khoản chi
        btnThemKhoanChi_123.setOnClickListener {
            val tenNhap_123 = edtTenKhoanChi_123.text.toString().trim()
            val tienNhapStr_123 = edtSoTien_123.text.toString().trim()
            val ghiChuNhap_123 = edtGhiChu_123.text.toString().trim()

            // Kiểm tra dữ liệu hợp lệ
            if (tenNhap_123.isEmpty()) {
                edtTenKhoanChi_123.error = "Tên khoản chi không được để trống"
                return@setOnClickListener
            }

            val tienNhap_123 = tienNhapStr_123.toDoubleOrNull()
            if (tienNhap_123 == null || tienNhap_123 <= 0) {
                edtSoTien_123.error = "Số tiền phải là số lớn hơn 0"
                return@setOnClickListener
            }

            // Cập nhật giá trị
            tenKhoanChi_123 = tenNhap_123
            soTien_123 = tienNhap_123
            ghiChu_123 = ghiChuNhap_123

            Toast.makeText(this, "Thêm khoản chi thành công!", Toast.LENGTH_SHORT).show()
        }

        // Xử lý nút Xem chi tiết khoản chi
        btnXemChiTiet_123.setOnClickListener {
            val intent_123 = Intent(this, ChiTietChiTieuActivity::class.java).apply {
                putExtra("EXTRA_TEN_123", tenKhoanChi_123)
                putExtra("EXTRA_TIEN_123", soTien_123)
                putExtra("EXTRA_GHICHU_123", ghiChu_123)
                putExtra("EXTRA_THANHTOAN_123", false)
            }
            startActivity(intent_123)
        }
    }
}