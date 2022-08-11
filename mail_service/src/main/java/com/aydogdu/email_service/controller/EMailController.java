package com.aydogdu.email_service.controller;

import com.aydogdu.email_service.business.dto.EMailDto;
import com.aydogdu.email_service.business.impl.EMailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Ayse Aydogdu
 * @Date 8/10/2022 9:14 AM
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/mail")
public class EMailController {

    private final EMailServiceImpl emailService;

    @PostMapping
    public ResponseEntity<String> sendMail(@RequestBody EMailDto emailDto){
        return ResponseEntity.ok( emailService.sendMail(emailDto));
    }

    @GetMapping
    public ResponseEntity<List<EMailDto>> findAllEMail(){
        return ResponseEntity.ok(emailService.findAllEMail());
    }
}
