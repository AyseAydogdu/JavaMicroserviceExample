package com.aydogdu.email_service.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Ayse Aydogdu
 * @Date 8/10/2022 9:14 AM
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EMailDto {

    Long id;

    String recipient;

    String subject;

    String msgBody;
}
