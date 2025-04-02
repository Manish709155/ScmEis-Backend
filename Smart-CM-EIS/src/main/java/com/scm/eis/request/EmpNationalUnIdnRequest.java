package com.scm.eis.request;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
@Getter@Setter@AllArgsConstructor@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class EmpNationalUnIdnRequest implements Serializable {
    static final long serialVersionUID = 1L;

    String panNumber;

    String adharNumber;

    Long employeeId;

}