package com.marondal.springtest.database.repository;


import com.marondal.springtest.database.domain.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreRepository {

    // store 테이블 모든 행 조회
    public List<Store> selectStoreList();
}
