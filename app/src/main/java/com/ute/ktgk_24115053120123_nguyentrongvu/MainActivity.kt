package com.ute.ktgk_24115053120123_nguyentrongvu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Khai báo các view giao diện với hậu tố _123
    private lateinit var edtTenKhoanChi_123: EditText
    private lateinit var edtSoTien_123: EditText
    private lateinit var edtGhiChu_123: EditText
    private lateinit var btnThemKhoanChi_123: Button
    private lateinit var btnXemChiTiet_123: Button

    // Đối tượng KhoanChi lưu trữ dữ liệu hiện tại (Câu 4)
    // Khởi tạo dữ liệu mẫu ban đầu để tránh trùng lặp
    private var khoanChiHienTai_123: KhoanChi? = KhoanChi(
        maKhoanChi = "KC_VU_123",
        tenKhoanChi = "Học phí ôn thi chứng chỉ CNTT",
        soTien = 1850000.0,
        ghiChu = "Thanh toán qua chuyển khoản ngân hàng",
        daThanhToan = true
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tiêu đề Toolbar / ActionBar bắt buộc theo định dạng đề bài:
        // [Họ tên SV] - [MSSV] - Quản lý chi tiêu cá nhân
        supportActionBar?.title = "Nguyen Trong Vu - 24115053120123 - Quản lý chi tiêu cá nhân"

        khoiTaoView_123()
        hienThiDuLieuBanDau_123()
        xuLySuKien_123()
    }

    // Ánh xạ các thành phần View từ XML
    private fun khoiTaoView_123() {
        edtTenKhoanChi_123 = findViewById(R.id.edtTenKhoanChi_123)
        edtSoTien_123 = findViewById(R.id.edtSoTien_123)
        edtGhiChu_123 = findViewById(R.id.edtGhiChu_123)
        btnThemKhoanChi_123 = findViewById(R.id.btnThemKhoanChi_123)
        btnXemChiTiet_123 = findViewById(R.id.btnXemChiTiet_123)
    }

    // Điền sẵn dữ liệu mẫu lên giao diện ban đầu
    private fun hienThiDuLieuBanDau_123() {
        khoanChiHienTai_123?.let {
            edtTenKhoanChi_123.setText(it.tenKhoanChi)
            edtSoTien_123.setText(it.soTien.toLong().toString())
            edtGhiChu_123.setText(it.ghiChu)
        }
    }

    // Xử lý sự kiện click cho các nút chức năng
    private fun xuLySuKien_123() {
        // Nút Thêm khoản chi (Câu 1 & Câu 5: Kiểm tra tính hợp lệ dữ liệu)
        btnThemKhoanChi_123.setOnClickListener {
            val tenNhap_123 = edtTenKhoanChi_123.text.toString().trim()
            val tienNhapStr_123 = edtSoTien_123.text.toString().trim()
            val ghiChuNhap_123 = edtGhiChu_123.text.toString().trim()

            // 1. Kiểm tra tên không được để trống hoặc chỉ chứa khoảng trắng
            if (tenNhap_123.isEmpty()) {
                edtTenKhoanChi_123.error = "Tên khoản chi không được để trống"
                edtTenKhoanChi_123.requestFocus()
                return@setOnClickListener
            }

            // 2. Kiểm tra số tiền phải hợp lệ và lớn hơn 0
            val tienNhap_123 = tienNhapStr_123.toDoubleOrNull()
            if (tienNhap_123 == null || tienNhap_123 <= 0) {
                edtSoTien_123.error = "Số tiền phải là số lớn hơn 0"
                edtSoTien_123.requestFocus()
                return@setOnClickListener
            }

            // Khởi tạo đối tượng KhoanChi mới (Câu 4)
            val maMoi_123 = "KC_" + System.currentTimeMillis().toString().takeLast(4)
            khoanChiHienTai_123 = KhoanChi(
                maKhoanChi = maMoi_123,
                tenKhoanChi = tenNhap_123,
                soTien = tienNhap_123,
                ghiChu = ghiChuNhap_123,
                daThanhToan = false
            )

            Toast.makeText(this, "Thêm khoản chi thành công!", Toast.LENGTH_SHORT).show()
        }

        // Nút Xem chi tiết khoản chi (Câu 2: Truyền dữ liệu bằng Intent)
        btnXemChiTiet_123.setOnClickListener {
            val duLieu_123 = khoanChiHienTai_123
            if (duLieu_123 == null) {
                Toast.makeText(this, "Chưa có khoản chi nào để xem!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Truyền cả đối tượng KhoanChi sang màn hình chi tiết
            val intent_123 = Intent(this, ChiTietChiTieuActivity::class.java).apply {
                // Truyền đối tượng model qua Serializable
                putExtra("DU_LIEU_KHOAN_CHI", duLieu_123)

                // Đồng thời truyền các trường rời rạc để hỗ trợ kiểm thử Intent ở Câu 2
                putExtra("EXTRA_TEN_123", duLieu_123.tenKhoanChi)
                putExtra("EXTRA_TIEN_123", duLieu_123.soTien)
                putExtra("EXTRA_GHICHU_123", duLieu_123.ghiChu)
                putExtra("EXTRA_THANHTOAN_123", duLieu_123.daThanhToan)
            }
            startActivity(intent_123)
        }
    }
}