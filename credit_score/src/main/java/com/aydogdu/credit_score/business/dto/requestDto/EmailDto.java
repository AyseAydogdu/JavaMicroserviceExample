package com.aydogdu.credit_score.business.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Ayse Aydogdu
 * @Date 8/10/2022 11:07 PM
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmailDto {

    Long id;

    String recipient;

    String subject;

    String msgBody;
}
