package com.marondal.springtest.database.service;

import com.marondal.springtest.database.domain.Store;
import com.marondal.springtest.database.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    // 가게정보 리스트 얻어오기
    public List<Store>  getStoreList() {

        // store 테이블 모든 행 조회
        List<Store> storeList = storeRepository.selectStoreList();

        return storeList;

    }

}
