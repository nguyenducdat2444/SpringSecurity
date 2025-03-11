package com.example.ontap.Repository;

import com.example.ontap.Entity.DichVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DichVuRepo extends JpaRepository<DichVu, Long> {

}
