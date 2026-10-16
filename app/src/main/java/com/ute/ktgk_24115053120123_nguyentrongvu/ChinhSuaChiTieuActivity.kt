package com.ute.ktgk_24115053120123_nguyentrongvu

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaChiTieuActivity : AppCompatActivity() {

    private lateinit var edtSuaTen_123: EditText
    private lateinit var edtSuaSoTien_123: EditText
    private lateinit var edtSuaGhiChu_123: EditText
    private lateinit var cbSuaThanhToan_123: CheckBox
    private lateinit var btnLuuChinhSua_123: Button
    private lateinit var btnHuyChinhSua_123: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_chi_tieu)

        supportActionBar?.title = "Nguyen Trong Vu - 24115053120123 - Quản lý chi tiêu cá nhân"

        edtSuaTen_123 = findViewById(R.id.edtSuaTen_123)
        edtSuaSoTien_123 = findViewById(R.id.edtSuaSoTien_123)
        edtSuaGhiChu_123 = findViewById(R.id.edtSuaGhiChu_123)
        cbSuaThanhToan_123 = findViewById(R.id.cbSuaThanhToan_123)
        btnLuuChinhSua_123 = findViewById(R.id.btnLuuChinhSua_123)
        btnHuyChinhSua_123 = findViewById(R.id.btnHuyChinhSua_123)

        // Hiển thị dữ liệu hiện tại nhận từ màn hình Chi tiết
        val tenHienTai_123 = intent.getStringExtra("EXTRA_TEN_123") ?: ""
        val tienHienTai_123 = intent.getDoubleExtra("EXTRA_TIEN_123", 0.0)
        val ghiChuHienTai_123 = intent.getStringExtra("EXTRA_GHICHU_123") ?: ""
        val daThanhToanHienTai_123 = intent.getBooleanExtra("EXTRA_THANHTOAN_123", false)

        edtSuaTen_123.setText(tenHienTai_123)
        edtSuaSoTien_123.setText(tienHienTai_123.toLong().toString())
        edtSuaGhiChu_123.setText(ghiChuHienTai_123)
        cbSuaThanhToan_123.isChecked = daThanhToanHienTai_123

        // Bấm Lưu
        btnLuuChinhSua_123.setOnClickListener {
            val tenMoi_123 = edtSuaTen_123.text.toString().trim()
            val tienMoiStr_123 = edtSuaSoTien_123.text.toString().trim()
            val ghiChuMoi_123 = edtSuaGhiChu_123.text.toString().trim()

            if (tenMoi_123.isEmpty()) {
                edtSuaTen_123.error = "Tên không được bỏ trống"
                return@setOnClickListener
            }

            val tienMoi_123 = tienMoiStr_123.toDoubleOrNull()
            if (tienMoi_123 == null || tienMoi_123 <= 0) {
                edtSuaSoTien_123.error = "Số tiền phải lớn hơn 0"
                return@setOnClickListener
            }

            val resultIntent_123 = Intent().apply {
                putExtra("EXTRA_TEN_123", tenMoi_123)
                putExtra("EXTRA_TIEN_123", tienMoi_123)
                putExtra("EXTRA_GHICHU_123", ghiChuMoi_123)
                putExtra("EXTRA_THANHTOAN_123", cbSuaThanhToan_123.isChecked)
            }
            setResult(Activity.RESULT_OK, resultIntent_123)
            Toast.makeText(this, "Đã lưu chỉnh sửa!", Toast.LENGTH_SHORT).show()
            finish()
        }

        // Bấm Hủy
        btnHuyChinhSua_123.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}