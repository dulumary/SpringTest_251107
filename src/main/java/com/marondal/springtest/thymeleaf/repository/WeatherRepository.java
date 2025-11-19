package com.marondal.springtest.thymeleaf.repository;

import com.marondal.springtest.thymeleaf.domain.Weather;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WeatherRepository {

    public List<Weather> selectWeatherList();

}
