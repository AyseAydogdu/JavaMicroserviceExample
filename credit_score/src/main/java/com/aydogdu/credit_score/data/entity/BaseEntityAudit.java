package com.aydogdu.creditscore.data.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @Author Ayse Aydogdu
 * @Date 7/21/2022 11:30 AM
 */
public abstract class BaseEntityAudit {

    @Id
    private Long id;

    @CreatedBy
    private String createdBy;


    @CreatedDate
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


    @LastModifiedBy
    private String updateBy;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updateDate;
}
