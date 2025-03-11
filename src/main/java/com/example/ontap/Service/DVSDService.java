package com.example.ontap.Service;

import com.example.ontap.Entity.DVSD;
import com.example.ontap.Repository.DVSDrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DVSDService {

    @Autowired
    private DVSDrepo dvsDrepo;

    public List<DVSD> getAll() {
        return dvsDrepo.findAll();
    }
}
