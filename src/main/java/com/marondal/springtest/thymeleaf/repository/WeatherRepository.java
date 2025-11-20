package com.marondal.springtest.thymeleaf.repository;

import com.marondal.springtest.thymeleaf.domain.Weather;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface WeatherRepository {

    public List<Weather> selectWeatherList();

    public int insertWeather(
            @Param("date") LocalDate date
            , @Param("weather") String weather
            , @Param("temperatures") double temperatures
            , @Param("precipitation") double precipitation
            , @Param("microDust") String microDust
            , @Param("windSpeed") double windSpeed);

    public int insertWeatherByObject(Weather weather);

}
