package com.aydogdu.credit_score.business.service.impl;

import com.aydogdu.credit_score.business.dto.CreditScoreDto;
import com.aydogdu.credit_score.business.dto.requestDto.EmailDto;
import com.aydogdu.credit_score.business.service.CreditScoreService;
import com.aydogdu.credit_score.data.entity.CreditScore;
import com.aydogdu.credit_score.data.repository.CreditScoreRepository;

import com.aydogdu.credit_score.util.CreditScoreGenerator;
import com.aydogdu.customer.business.dto.CustomerDto;
import com.aydogdu.customer.data.entity.Customer;
import com.aydogdu.customer.data.repository.CustomerRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Ayse Aydogdu
 * @Date 7/20/2022 7:41 PM
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class CreditScoreServiceImpl implements CreditScoreService {
    private final CreditScoreRepository creditScoreRepository;
    private final CreditScoreGenerator creditScoreGenerator;
    @Autowired
    CustomerDto customerDto;
    private final ModelMapper modelMapper;
    String subject = "Kredi Skorunuz";

    @Autowired
    RestTemplate restTemplate;
    @Value("${url.mail-service}")
    String url2;

    @Value("${url.customer-service}")
    String url;

    public Long getCreditScore(Long idNumber) {
        return creditScoreRepository.findByIdNumber(idNumber).getCreditScore();
    }

    public String createCreditScore(Long idNumber) {

        try {

            Long customerCreditScore = creditScoreGenerator.GenerateCreditScoreByIdNumber(idNumber);

            if (creditScoreRepository.findByIdNumber(idNumber) == null) {
                CreditScore creditScore = CreditScore.builder().idNumber(idNumber).creditScore(customerCreditScore).build();
                creditScoreRepository.save(creditScore);
                sendMail(idNumber, customerCreditScore);
                return "Customer credit score succesfully saved";

            }
        } catch (Exception e) {
            log.error(e.getMessage());

        }
        return "This identity number is already in use";
    }

    public String sendMail(Long idNumber, Long customerCreditScore) {

        try {
            customerDto = restTemplate.getForObject(url + "/" + idNumber, CustomerDto.class);
            String message = "Sayın " + customerDto.getName() + " Kredi Skorunuz " + customerCreditScore + ". İyi günlerde kullanın.";
            log.error(message);

            EmailDto emailDto = EmailDto.builder().id(0L).recipient(customerDto.getMail()).subject(subject).msgBody(message).build();
            log.error(emailDto.toString());
            HttpEntity<EmailDto> request = new HttpEntity<>(emailDto);

            if (restTemplate.postForObject(url2, request, String.class) != null) {
                return "mail sended";
            }
        } catch (Exception e) {
            log.error(e.getMessage());

        }
        return "mail could not be sent";
    }


    public CreditScoreDto entityToDto(CreditScore creditScore){
        return modelMapper.map(creditScore,CreditScoreDto.class);
    }
    public CustomerDto entityToCustomerDto(Customer customer){
        return modelMapper.map(customer,CustomerDto.class);
    }
}
