package com.marondal.springtest.mvc.repository;

import com.marondal.springtest.mvc.domain.Realtor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RealtorRepository {

    public int insertRealtor(Realtor realtor);
}
