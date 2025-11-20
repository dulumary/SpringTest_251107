package com.marondal.springtest.thymeleaf;

import com.marondal.springtest.thymeleaf.domain.Weather;
import com.marondal.springtest.thymeleaf.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/thymeleaf/weather")
@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/history")
    public String weatherHistory(Model model) {

        // 날씨 기록 얻어 오기
        List<Weather> weatherHistory = weatherService.getWeatherHistory();

        model.addAttribute("weatherHistory", weatherHistory);
        return "thymeleaf/weather/list";
    }

    @GetMapping("/form")
    public String weatherForm() {
        return "thymeleaf/weather/form";
    }

    @GetMapping("/add")
    public String addWeather(@ModelAttribute Weather weather) {

//            @RequestParam("date") @DateTimeFormat(pattern="yyyy년 M월 d일") LocalDate date  // 2025년 11월 20일
//        , @RequestParam("weather") String weather
//        , @RequestParam("temperatures") double temperatures
//        , @RequestParam("precipitation") double precipitation
//        , @RequestParam("microDust") String microDust
//        , @RequestParam("windSpeed") double windSpeed) {


//        int count = weatherService.createWeather(date, weather, temperatures, precipitation, microDust, windSpeed);

        int count = weatherService.createWeatherByObject(weather);

        return "redirect:/thymeleaf/weather/history";

    }
}
