package com.aydogdu.creditscore.data.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Author Ayse Aydogdu
 * @Date 7/20/2022 7:27 PM
 */
@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreditScore {

    @Id
    String id;

    @Field(name = "id_number")
    Long idNumber;

    @Field(name = "credit_score")
    Long creditScore;

}
