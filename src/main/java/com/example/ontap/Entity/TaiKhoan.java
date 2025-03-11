package com.example.ontap.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tai_khoan")
@Data
public class TaiKhoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @ManyToOne
//    @JoinColumn(name = "co_so_id")
//    private CoSo coSo;
//
//    @ManyToOne
//    @JoinColumn(name = "phong_ban_id")
//    private PhongBan phongBan;
//
//    @ManyToOne
//    @JoinColumn(name = "chuc_vu_id")
//    private ChucVu chucVu;

    @Column(name = "ten_tai_khoan")
    private String tenTaiKhoan;

    @Column(name = "mat_khau")
    private String matKhau;

    @Column(name = "ho")
    private String ho;

    @Column(name = "ten_dem")
    private String tenDem;

    @Column(name = "ten")
    private String ten;

    @Column(name = "gioi_tinh")
    private String gioiTinh;

    @Column(name = "ngay_sinh")
    private LocalDateTime ngaySinh;

    @Column(name = "email")
    private String email;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "cmnd")
    private String cmnd;

    @Column(name = "trang_thai")
    private Integer trangThai;

//    @Column(name = "ngay_tao")
//    private LocalDateTime ngayTao;
//    @Column(name = "ngay_tao", columnDefinition = "datetime2(6) default getdate()")
//    private LocalDateTime ngayTao = LocalDateTime.now();
    @Column(name = "ngay_tao", updatable = false)
    private LocalDateTime ngayTao = LocalDateTime.now();

    @Column(name = "ngay_chinh_sua")
    private LocalDateTime ngayChinhSua;

    @Column(name = "role")
    private String role = "USER";

}