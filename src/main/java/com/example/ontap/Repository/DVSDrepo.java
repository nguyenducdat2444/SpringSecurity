package com.example.ontap.Repository;


import com.example.ontap.Entity.DVSD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DVSDrepo extends JpaRepository<DVSD, Long> {
}
