package com.scm.eis.entity;

import com.scm.eis.constant.*;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
@Entity
@Table(name = "User_service_registration")
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceRegistration extends SuperEntity implements Serializable {

    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "query_type")
    QueryType queryType;

    @Enumerated(EnumType.STRING)
    @Column(name = "non_tech_solutions_types")
    NonTechSolutionsTypes nonTechSolutionsTypes;

    @Enumerated(EnumType.STRING)
    @Column(name = "tech_solutions_types")
    TechSolutionsTypes techSolutionsTypes;

    @Column(name="ticket_number")
    String ticketNumber;

    @Column(name="service_number")
    String serviceNumber;


    @Enumerated(EnumType.STRING)
    @Column(name = "solution_status")
    SolutionStatus solutionStatus;
}
