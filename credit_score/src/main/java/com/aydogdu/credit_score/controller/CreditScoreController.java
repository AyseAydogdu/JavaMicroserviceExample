package com.aydogdu.credit_score.controller;

import com.aydogdu.credit_score.business.service.impl.CreditScoreServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Ayse Aydogdu
 * @Date 7/20/2022 7:26 PM
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("credit-score")
public class CreditScoreController {

    private final CreditScoreServiceImpl creditScoreServiceImpl ;

    // https://locallhost:8080/credit-score/idNumber
    @GetMapping("/{idNumber}")
    public ResponseEntity<Long> getCreditScore(@PathVariable Long idNumber)
    {
        return ResponseEntity.ok(creditScoreServiceImpl.getCreditScore(idNumber));
    }

    // https://locallhost:8083/credit-score/idNumber
    @PostMapping("/{idNumber}")
    public ResponseEntity<String> createCreditScore(@PathVariable Long idNumber)
    {
      return ResponseEntity.ok(creditScoreServiceImpl.createCreditScore(idNumber));
    }


}
