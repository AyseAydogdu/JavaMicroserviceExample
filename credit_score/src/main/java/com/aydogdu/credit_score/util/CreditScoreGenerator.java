package com.aydogdu.credit_score.util;

import org.springframework.stereotype.Component;

/**
 * @Author Ayse Aydogdu
 * @Date 7/20/2022 9:04 PM
 */
@Component
public class CreditScoreGenerator {
    public Long GenerateCreditScoreByIdNumber(Long idNumber)
    {
        Long customerCreditScore = 0L;
        int lastDigit= (int)(idNumber % 10);
        switch (lastDigit)
        {
            case 0: case 2:
            customerCreditScore = 1000L;
            break;
            case 4:
                customerCreditScore = 1400L ;
                break;
            case 6: case 8:
            customerCreditScore = 1600L ;
            break;
            default:
                customerCreditScore = 0L ;
        }
        return customerCreditScore;
    }

}
