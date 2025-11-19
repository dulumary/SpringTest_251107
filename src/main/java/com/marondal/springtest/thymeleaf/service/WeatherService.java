package com.marondal.springtest.thymeleaf.service;

import com.marondal.springtest.thymeleaf.domain.Weather;
import com.marondal.springtest.thymeleaf.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    public List<Weather> getWeatherHistory() {
        // weahterhistory 테이블 모든 행 조회
        List<Weather> weatherList = weatherRepository.selectWeatherList();

        return weatherList;

    }
}
