package com.marondal.springtest.mvc;

import com.marondal.springtest.mvc.domain.Seller;
import com.marondal.springtest.mvc.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/mvc/seller")
@Controller
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @ResponseBody
    @PostMapping("/add")
    public String addSeller(
            @RequestParam("nickname") String nickname
            , @RequestParam("temperature") double temperature
            , @RequestParam("profileImage") String profileImage) {


        int count = sellerService.createSeller(nickname, temperature, profileImage);

        return "입력 결과 : " + count;

    }

    @GetMapping("/form")
    public String sellerForm() {
        return "mvc/sellerForm";
    }


    @GetMapping("/info")
    public String sellerInfo(
            @RequestParam(value="id", required=false) Integer id
            , Model model) {

        Seller seller = null;
        if(id == null) {
            seller = sellerService.getLastSeller();
        } else {
            seller = sellerService.getSeller(id);
        }

        model.addAttribute("seller", seller);

        return "mvc/sellerInfo";
    }

}
