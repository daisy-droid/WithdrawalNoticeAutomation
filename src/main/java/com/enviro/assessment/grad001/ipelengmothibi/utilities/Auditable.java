package com.enviro.assessment.grad001.ipelengmothibi.utilities;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import static jakarta.persistence.TemporalType.TIMESTAMP;

// The auditable class helps with adding the created and lastModified date to any entity that extends it (inheritance)
public abstract class Auditable<T> {
    @Column(name = "created_date", updatable = false)
    @Temporal(TIMESTAMP)
    @CreatedDate
    protected Date creationDate;

    @Column(name = "lastModified_date", updatable = false)
    @Temporal(TIMESTAMP)
    @LastModifiedDate
    protected Date lastModifiedDate;
}
