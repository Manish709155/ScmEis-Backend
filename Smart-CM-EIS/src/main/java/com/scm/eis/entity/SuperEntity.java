package com.scm.eis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.time.LocalDateTime;
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SuperEntity implements Serializable {

    static final long serialVersionUID = 1L;

    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    LocalDateTime createdOn;

    @Column(name = "updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    LocalDateTime updatedOn;

    @Column(name = "active")
    @ColumnDefault(value = "0")
    Boolean active = Boolean.FALSE;

    @ColumnDefault(value = "0")
    @Column(name = "deleted")
    Boolean deleted = Boolean.FALSE;
}
