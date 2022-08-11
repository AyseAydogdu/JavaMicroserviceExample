package com.aydogdu.email_service.business.impl;

import com.aydogdu.email_service.data.entity.EMail;
import com.aydogdu.email_service.business.EMailService;
import com.aydogdu.email_service.business.dto.EMailDto;
import com.aydogdu.email_service.data.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author Ayse Aydogdu
 * @Date 8/10/2022 9:13 AM
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class EMailServiceImpl implements EMailService {
    private final EmailRepository emailRepository;

    private final JavaMailSender javaMailSender ;
    private final ModelMapper modelMapper;
   // String sender = "ayseaydogdu122@gmail.com";
    @Autowired
    RestTemplate restTemplate;
    @Value("${spring.mail.username}")
    String sender;
    public String sendMail(EMailDto eMailDto) {

        try{

            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setTo(eMailDto.getRecipient());
            simpleMailMessage.setSubject(eMailDto.getSubject());
            simpleMailMessage.setText(eMailDto.getMsgBody());
            javaMailSender.send(simpleMailMessage);
            saveSendMail(eMailDto);
            return "Email send successfuly";
        }
        catch (Exception e){
            log.error("Error while Sending Mail "+ e.getMessage());
            return "Error while Sending Mail ";
        }

    }
    public EMailDto saveSendMail(EMailDto emailDto){
     return entityToDto(emailRepository.save(dtoToEntity(emailDto)));
   }
    public EMailDto entityToDto(EMail eMail){
        return modelMapper.map(eMail,EMailDto.class);
    }
    public EMail dtoToEntity(EMailDto emailDto){
        return modelMapper.map( emailDto,EMail.class);
    }
    public List<EMailDto> entityToDtoList(List<EMail> emails){
        List<EMailDto> emailDtos = null;
        for (EMail email:emails) {
            emailDtos.add(entityToDto(email));
        }
        return emailDtos;
    }
    public List<EMailDto> findAllEMail() {
       return entityToDtoList((List<EMail>) emailRepository.findAll());
   }
}
