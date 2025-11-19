package com.marondal.springtest.thymeleaf;

import com.marondal.springtest.thymeleaf.domain.Weather;
import com.marondal.springtest.thymeleaf.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
