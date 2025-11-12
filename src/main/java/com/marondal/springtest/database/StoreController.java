package com.marondal.springtest.database;

import com.marondal.springtest.database.domain.Store;
import com.marondal.springtest.database.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StoreController {

    @Autowired
    private StoreService storeService;

    // 가게 정보 리스트 response에 담기
    @ResponseBody
    @RequestMapping("/db/store/list")
    public List<Store> storeList() {
        
        // 가게 정보 리스트 얻어오기
        List<Store> storeList = storeService.getStoreList();


        return storeList;
    }
}
