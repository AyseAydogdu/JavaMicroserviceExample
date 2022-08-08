package com.aydogdu.creditscore.data.repository;

import com.aydogdu.creditscore.data.entity.CreditScore;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Ayse Aydogdu
 * @Date 7/20/2022 7:35 PM
 */
@Repository
public interface CreditScoreRepository extends MongoRepository<CreditScore,String> {
    CreditScore findByIdNumber(Long idNumber);
}
