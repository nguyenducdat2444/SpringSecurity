package com.example.ontap.Service;


import com.example.ontap.Entity.TaiKhoan;
import com.example.ontap.Repository.TaiKhoanRepo;
import com.example.ontap.dto.LoginRequest;
import com.example.ontap.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaiKhoanService {

    private final TaiKhoanRepo taiKhoanRepo;
    private final PasswordEncoder passwordEncoder;

    public TaiKhoanService(TaiKhoanRepo taiKhoanRepo, PasswordEncoder passwordEncoder) {
        this.taiKhoanRepo = taiKhoanRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public TaiKhoan register (RegisterRequest request) {
        if (taiKhoanRepo.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists"); //Kiem tra email da ton tai
        }
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setTenTaiKhoan(request.getTenTaiKhoan());
        taiKhoan.setEmail(request.getEmail());
        taiKhoan.setMatKhau(passwordEncoder.encode( request.getMatKhau()));
        System.out.println("Tài khoản đã lưu: " + taiKhoan);
        return taiKhoanRepo.save(taiKhoan);
        System.out.println("Tài khoản đã lưu: " + taiKhoan);
    }

    public TaiKhoan login (LoginRequest request) {
        TaiKhoan taiKhoan = taiKhoanRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Email not found"));

        if (!passwordEncoder.matches(request.getMatKhau() , taiKhoan.getMatKhau())) { //kiem tra co trung mk ko
            throw new RuntimeException("Password incorrect");
        }
        return taiKhoan;
    }

    public TaiKhoan loadUserByUsername(String username) {
        return new TaiKhoan();
    }
}
