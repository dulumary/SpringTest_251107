package com.marondal.springtest.mybatis;

import com.marondal.springtest.mybatis.domain.RealEstate;
import com.marondal.springtest.mybatis.service.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/mybatis/real-estate")
@Controller
public class RealEstateController {

    @Autowired
    private RealEstateService realEstateService;

    @ResponseBody
    @RequestMapping("/select/1")
    public RealEstate realEstate(@RequestParam("id") int id) {
        
        // 전달 받은 id와 일치하는 매물 정보 얻어오기
        RealEstate realEstate = realEstateService.getRealEstate(id);

        return realEstate;
    }

    @ResponseBody
    @RequestMapping("/select/2")
    public List<RealEstate> realEstateByRentPrice(@RequestParam("rent") int rentPrice) {
        
        // 전달받은 월세 보다 낮은 매물 리스트 얻어오기
        List<RealEstate> realEstateList = realEstateService.getRealEstateListByRentPrice(rentPrice);

        return realEstateList;
    }

    @ResponseBody
    @RequestMapping("/select/3")
    public List<RealEstate> realEstateAreaAndPrice(
            @RequestParam("area") int area
            , @RequestParam("price") int price) {

        List<RealEstate> realEstateList = realEstateService.getRealEstateListByAreaAndPrice(area, price);

        return realEstateList;

    }

    @ResponseBody
    @RequestMapping("/insert/1")
    public String addRealEstate() {
//        realtorId : 3
//        address : 푸르지용 리버 303동 1104호
//        area : 89
//        type : 매매
//        price : 100000

        RealEstate realEstate = new RealEstate();
        realEstate.setRealtorId(3);
        realEstate.setAddress("푸르지용 리버 303동 1104호");
        realEstate.setArea(89);
        realEstate.setType("매매");
        realEstate.setPrice(100000);

        int count = realEstateService.createRealEstateByObject(realEstate);

        return "입력 성공 : " + count;
    }

    @ResponseBody
    @RequestMapping("/insert/2")
    public String addRealEstateByRealtorId(@RequestParam("realtorId") int realtorId) {
//        address : 썅떼빌리버 오피스텔 814호
//        area : 45
//        type : 월세
//        price : 100000
//        rentPrice : 120

        int count = realEstateService.createRealEstate(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);

        return "입력 성공 : " + count;

    }

    @ResponseBody
    @RequestMapping("/modify")
    public String modifyRealEstate() {
//        id가 22인 행의 type을 전세로 바꾸고 price를 70000으로 변경하세요.

        int count = realEstateService.updateRealEstate(22, "전세", 70000);

        return "수정 성공 : " + count;
    }

    @ResponseBody
    @RequestMapping("/remove")
    public String removeRealEstate(@RequestParam("id") int id) {

        int count = realEstateService.deleteRealEstate(id);
        return "삭제 성공 : " + count;
    }



}
