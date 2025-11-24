package com.marondal.springtest.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ajax/booking")
@Controller
public class BookingController {

    @GetMapping("/main")
    public String main() {
        return "ajax/booking/main";
    }

    @GetMapping("/list")
    public String bookingList() {
        return "ajax/booking/list";
    }

    @GetMapping("/form")
    public String bookingForm() {
        return "ajax/booking/form";
    }
}
