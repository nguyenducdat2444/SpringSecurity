package com.example.ontap.Repository;

import com.example.ontap.Entity.TaiKhoan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaiKhoanRepo extends CrudRepository<TaiKhoan, Long> {

        Optional<TaiKhoan> findByEmail(String email);
        Boolean existsByEmail(String email);
        Boolean existsByTenTaiKhoan(String tenTaiKhoan);
}
