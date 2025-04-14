package com.scm.eis.request;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeUpdateRequest implements Serializable{

    Long id;

    String personalEmailId;

    String mobileNumber;
}
