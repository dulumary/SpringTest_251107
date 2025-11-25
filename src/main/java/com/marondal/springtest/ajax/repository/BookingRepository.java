package com.marondal.springtest.ajax.repository;

import com.marondal.springtest.ajax.domain.Booking;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface BookingRepository {

    public List<Booking> selectBookingList();

    public int deleteBooking(@Param("id") int id);

    public int insertBooking(
            @Param("name") String name
            , @Param("headcount") int headcount
            , @Param("day") int day
            , @Param("date") LocalDate date
            , @Param("phoneNumber") String phoneNumber
            , @Param("state") String state);


    public Booking selectBooking(
            @Param("name") String name
            , @Param("phoneNumber") String phoneNumber);

}
