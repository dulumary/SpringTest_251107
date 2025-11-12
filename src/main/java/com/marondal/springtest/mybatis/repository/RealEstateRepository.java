package com.marondal.springtest.mybatis.repository;

import com.marondal.springtest.mybatis.domain.RealEstate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RealEstateRepository {

    // real_estate 테이블에서 전달 받은 id와 일치하는 행 조회
    public RealEstate selectRealEstate(@Param("id") int id);

    // real_estate 테이블에서 전달받은 월세보다 낮은 행들 조회
    public List<RealEstate> selectRealEstateListByRentPrice(@Param("rentPrice") int rentPrice);

    public List<RealEstate> selectRealEstateListByAreaAndPrice(
            @Param("area") int area
            , @Param("price") int price);

    public int insertRealEstateByObject(RealEstate realEstate);

}
