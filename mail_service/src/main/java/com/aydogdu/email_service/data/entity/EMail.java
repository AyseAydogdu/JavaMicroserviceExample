package com.aydogdu.email_service.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author Ayse Aydogdu
 * @Date 8/10/2022 9:16 AM
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "email_table")
//@Table(name = "email_table")
public class EMail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String recipient;
    String subject;
    String msgBody;

}
