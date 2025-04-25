package com.scm.eis.entity;

import com.scm.eis.constant.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "chat_boat")
@NoArgsConstructor
@Getter
@Setter
public class ChatBoat extends SuperEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="ticket_number")
    String ticketNumber;

    @Column(name="service_number")
    String serviceNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "solution_status")
    SolutionStatus solutionStatus;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(targetEntity = Employee.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    Employee employee;

    @Enumerated(EnumType.STRING)
    @Column(name = "escalation_priority")
    EscalationPriority  escalationPriority;

    @Enumerated(EnumType.STRING)
    @Column(name = "query_under")
    QueryUnder queryUnder;

    @Column(name = "user_asked_query")
    @Lob
    String userAskedQuery;

}


