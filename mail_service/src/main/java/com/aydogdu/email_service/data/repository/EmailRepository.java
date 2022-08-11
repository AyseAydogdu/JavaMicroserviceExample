package com.aydogdu.email_service.data.repository;

import com.aydogdu.email_service.data.entity.EMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Ayse Aydogdu
 * @Date 8/10/2022 2:17 PM
 */
@Repository
public interface EmailRepository extends JpaRepository<EMail,Long> {
}
