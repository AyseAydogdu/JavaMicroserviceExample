package com.aydogdu.creditscore.business.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Author Ayse Aydogdu
 * @Date 7/20/2022 7:34 PM
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreditScoreDto {

    String id;

    Long idNumber;

    Long creditScore;
}
