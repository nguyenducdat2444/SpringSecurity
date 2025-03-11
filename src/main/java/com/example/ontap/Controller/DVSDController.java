package com.example.ontap.Controller;

import com.example.ontap.Entity.DVSD;
import com.example.ontap.Entity.DichVu;
import com.example.ontap.Repository.DVSDrepo;
import com.example.ontap.Repository.DichVuRepo;
import com.example.ontap.Service.DVSDService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/dich-vu")
public class DVSDController {

    @Autowired
    private DVSDrepo dvsDrepo;

    @Autowired
    private DichVuRepo dichVuRepo;

    @Autowired
    private DVSDService dvsdService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<DVSD> dvsd = dvsdService.getAll();
        model.addAttribute("ListDVSD", dvsd);
        model.addAttribute("ListDichVu", dichVuRepo.findAll());
        model.addAttribute("dvsd", new DVSD());
        System.out.println("DU lieu:" + dvsd);
        return "view/index";
    }

    @GetMapping("/delete/{maXoa}")
    public String deleteDV(@PathVariable("maXoa") Long maXoa) {
        dvsDrepo.deleteById(maXoa);
        return "redirect:/dich-vu/hien-thi";
    }

    @PostMapping("/add")
    public String addDV(@Valid @ModelAttribute("dvsd") DVSD dvsd, Errors errors
    ) {
        if (errors.hasErrors()) {
            return "view/index";
        } else {
            dvsDrepo.save(dvsd);
            return "redirect:/dich-vu/hien-thi";
        }
    }

    @GetMapping("/view-update/{idUpdate}")
    public String viewUpdate(@PathVariable("idUpdate") Long idUpdate, Model model) {
        DVSD dvsd = dvsDrepo.findById(idUpdate).orElseThrow(() -> new RuntimeException("Không tìm thấy DVSD"));
        model.addAttribute("ListDichVu", dichVuRepo.findAll());
        model.addAttribute("dvsd", dvsd);
        System.out.println("Ngày tạo: " + dvsd.getNgayTao()); // Kiểm tra log
        System.out.println("Dịch vụ cập nhật: " + dvsd);
        return "view/view-update";
    }

    @PostMapping("/update/{idUpdate}")
    public String update(@PathVariable("idUpdate") Long idUpdate,@Valid
                         @ModelAttribute DVSD dvsd, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("ListDichVu", dichVuRepo.findAll());
            return "view/view-update";
        }
        if (dvsd.getNgayTao().isAfter(LocalDate.now())) {
            throw new RuntimeException("Ngày tạo không hợp lệ!");
        }
        Optional<DVSD> existingDVSD = dvsDrepo.findById(idUpdate);
        if (existingDVSD.isPresent()) {
            DVSD dv = existingDVSD.get();
            dv.setMa(dvsd.getMa());
            dv.setTen(dvsd.getTen());
            dv.setNgayTao(dvsd.getNgayTao());
            dv.setGhiChu(dvsd.getGhiChu());
            dv.setTrangThai(dvsd.getTrangThai());
            dv.setDichVu(dvsd.getDichVu());

            dvsDrepo.save(dv);
        }
        return "redirect:/dich-vu/hien-thi";
    }

}
