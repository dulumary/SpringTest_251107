package com.marondal.springtest.jpa.repository;

import com.marondal.springtest.jpa.domain.Company;
import com.marondal.springtest.jpa.domain.Recruit;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RecruitRepository extends JpaRepository<Recruit, Integer> {

    // 특정 company id와 일치하는 행 조회
    // WHERE `company_id` = #{}
    public List<Recruit> findByCompanyId(int companyId);

    // WHERE `position` = #{} AND `type` = #{}
    public List<Recruit> findByPositionAndType(String position, String type);

    // WHERE `type` = #{} OR `salary` >= #{}
    public List<Recruit> findByTypeOrSalaryGreaterThanEqual(String type, int salary);

    // WHERE `type` = #{} ORDER BY `salary` DESC LIMIT 3
    public List<Recruit> findTop3ByTypeOrderBySalaryDesc(String type);

    // WHERE `region` = #{} AND `salary` BETWEEN #{} AND #{}
    public List<Recruit> findByRegionAndSalaryBetween(String region, int start, int end);

//    마감일이 2026-04-10 이후이고 연봉이 8100 이상인 정규직 공고를 연봉 내림차순으로 조회하세요.

    @Query(value="SELECT * FROM `recruit` " +
            "WHERE `deadline` > :deadline " +
            "AND `salary` >= :salary " +
            "AND `type` = :type " +
            "ORDER BY `salary` DESC", nativeQuery=true)
    public List<Recruit> selectByQuery(
            @Param("deadline") LocalDateTime deadline
            , @Param("salary") int salary
            , @Param("type") String type);
}
