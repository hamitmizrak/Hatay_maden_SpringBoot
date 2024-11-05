package com.hamitmizrak.audit;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Getter
@Setter

abstract public class AuditingAwareBaseEntity implements Serializable {

    // SERILEŞTIRME
    public static final Long serialVersionUID = 1L;

    // Kim Ekledi
    private String createdBy;

    // Kim Ne zaman Ekledi
    private Date createdDate;

    // Kim Güncelledi
    private String lastUserBy;

    // Kim Ne Zaman Güncelledi
    private Date lastUserDate;
}
