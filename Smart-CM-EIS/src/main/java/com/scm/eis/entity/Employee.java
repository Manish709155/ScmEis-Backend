package com.scm.eis.entity;

import com.scm.eis.constant.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee extends SuperEntity implements Serializable {

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

    @Column(name = "sapCard")
    String sapCard;


    @Column(name = "salary")
    BigDecimal salary;


    @Column(name = "joining_date")
    LocalDateTime joiningDate;

    @Column(name = "dob")
    LocalDateTime dob;

    @Column(name = "company_emailid")
    String companyEmailId;

    @Column(name = "personal_emailid")
    String personalEmailId;

    @Column(name = "mobile_number")
    String mobileNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender_type")
    GenderEnum genderType;

    @Enumerated(EnumType.STRING)
    @Column(name = "any_disability")
    AnyDisability anyDisability;

    @Enumerated(EnumType.STRING)
    @Column(name = "blood_group")
    BloodGroup bloodGroup;

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_department")
    EmployeeDepartment employeeDepartment;

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_category")
    EmployeeCategory employeeCategory;

    @ManyToOne(targetEntity = Company.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    Company company;

    @Enumerated(EnumType.STRING)
    @Column(name = "country")
    CountryEnum countryEnum;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    List<UserServiceRegistration> userServiceRegistrations;

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_level")
    EmployeeLevel employeeLevel;
}
