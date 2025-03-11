package com.example.ontap.Controller;

import com.example.ontap.Entity.TaiKhoan;
import com.example.ontap.Service.TaiKhoanService;
import com.example.ontap.dto.LoginRequest;
import com.example.ontap.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final TaiKhoanService taikhoanService;

    public AuthController(TaiKhoanService taikhoanService) {
        this.taikhoanService = taikhoanService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        taikhoanService.register(request);
        System.out.println("Username: " + request.getTenTaiKhoan());
        System.out.println("Password: " + request.getMatKhau());
        System.out.println("Email: " + request.getEmail());
        return ResponseEntity.ok("Dang ky thanh cong!");
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getTenTaiKhoan(), request.getMatKhau()));
            String token = jwtUtils.generateToken(request.getTenTaiKhoan());
            return ResponseEntity.ok(token);
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().body("Sai thông tin đăng nhập");
        }
    }
}
