package com.marondal.springtest.mvc.repository;

import com.marondal.springtest.mvc.domain.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SellerRepository {

    public int insertSeller(
            @Param("nickname") String nickname
            , @Param("temperature") double temperature
            , @Param("profileImage") String profileImage);

    public Seller selectLastSeller();

    public Seller selectSeller(@Param("id") int id);
}
