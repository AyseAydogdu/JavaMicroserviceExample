package com.aydogdu.creditscore.business.service.impl;

import com.aydogdu.creditscore.business.service.CreditScoreService;
import com.aydogdu.creditscore.data.entity.CreditScore;
import com.aydogdu.creditscore.data.repository.CreditScoreRepository;
import com.aydogdu.creditscore.util.CreditScoreGenerator;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author Ayse Aydogdu
 * @Date 7/20/2022 7:41 PM
 */
@Service
@RequiredArgsConstructor
public class CreditScoreServiceImpl implements CreditScoreService {
    private final CreditScoreRepository creditScoreRepository;
    private final  CreditScoreGenerator creditScoreGenerator ;
    public Long getCreditScore(Long idNumber) {
        return creditScoreRepository.findByIdNumber(idNumber).getCreditScore();
    }

    public String createCreditScore(Long idNumber) {


        Long customerCreditScore = creditScoreGenerator.GenerateCreditScoreByIdNumber(idNumber);

       if (creditScoreRepository.findByIdNumber(idNumber)==null){
           CreditScore creditScore = CreditScore.builder().idNumber(idNumber).creditScore(customerCreditScore).build();
           creditScoreRepository.save(creditScore);
           return "Customer credit score succesfully saved";

       }

        else {
            return "This identity number is already in use";
        }
    }
}
