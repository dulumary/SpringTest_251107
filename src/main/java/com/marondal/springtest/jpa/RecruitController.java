package com.marondal.springtest.jpa;

import com.marondal.springtest.jpa.domain.Recruit;
import com.marondal.springtest.jpa.repository.RecruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequestMapping("/jpa/recruit")
@Controller
public class RecruitController {

    @Autowired
    private RecruitRepository recruitRepository;


    @ResponseBody
    @GetMapping("/1")
    public Recruit recruitById() {

        Optional<Recruit> optionalRecruit = recruitRepository.findById(8);

        return optionalRecruit.get();

    }

    @ResponseBody
    @GetMapping("/2")
    public List<Recruit> recruitByCompanyId(@RequestParam("companyId") int companyId) {

        List<Recruit> recruitList = recruitRepository.findByCompanyId(companyId);

        return recruitList;
    }

    @ResponseBody
    @GetMapping("/3")
    public List<Recruit> recruitList() {

        List<Recruit> recruitList = null;
//        웹 back-end 개발자이고 정규직인 공고를 조회
//        recruitList = recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");

//        정규직 이거나 연봉이 9000 이상인 공고를 조회
//        recruitList = recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);

//        계약직 목록을 연봉 기준으로 내림차순 정렬해 3개만 조회하세요.
//        recruitList = recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");

//        성남시 분당구가 지역이고 연봉이 7000 이상 8500 이하인 공고를 조회하세요.
//        recruitList = recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);

//        마감일이 2026-04-10 이후이고 연봉이 8100 이상인 정규직 공고를 연봉 내림차순으로 조회하세요.
        recruitList = recruitRepository.selectByQuery(LocalDateTime.of(2026, 4, 9,23, 59, 59),  8100, "정규직");

        return recruitList;

    }

}
