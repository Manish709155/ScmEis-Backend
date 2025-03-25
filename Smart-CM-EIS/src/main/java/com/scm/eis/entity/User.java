package com.scm.eis.entity;

import com.scm.eis.constant.CountryEnum;
import com.scm.eis.constant.GenderEnum;
import com.scm.eis.constant.RoleTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends SuperEntity implements Serializable {

    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Size(min = 1, max = 255)
    @Column(name = "first_Name")
    String firstName;

    @Size(min = 1, max = 255)
    @Column(name = "middle_name")
    String middleName;

    @Size(min = 1, max = 255)
    @Column(name = "last_name")
    String lastName;

    @Size(min = 1, max = 255)
    @Column(name = "password")
    String password;

    @Size(min = 1, max = 255)
    @Column(name = "email_id")
    String emailId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "mobile_no")
    String mobileNo;

    @Size(min = 0, max = 1000)
    @Column(name = "consumer_id")
    String consumerId;

    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    RoleTypeEnum roleType;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender_type")
    private GenderEnum genderType;

}
