package com.marondal.springtest.mvc.service;

import com.marondal.springtest.mvc.domain.Realtor;
import com.marondal.springtest.mvc.repository.RealtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealtorService {

    @Autowired
    private RealtorRepository realtorRepository;

    public int createRealtor(Realtor realtor) {

        int count = realtorRepository.insertRealtor(realtor);

        return count;

    }
}
