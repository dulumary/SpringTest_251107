package com.marondal.springtest.thymeleaf.service;

import com.marondal.springtest.thymeleaf.domain.Weather;
import com.marondal.springtest.thymeleaf.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public int createWeather(
            LocalDate date
            , String weather
            , double temperatures
            , double precipitation
            , String microDust
            , double windSpeed) {

        int count = weatherRepository.insertWeather(date, weather, temperatures, precipitation, microDust, windSpeed);

        return count;
    }

    public int createWeatherByObject(Weather weather) {
        int count = weatherRepository.insertWeatherByObject(weather);
        return count;
    }
}
