package com.scm.eis.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum CompanyServices
{
 NON_TECH_SOLUTION_TYPES("Non Tech Solutions Types"),
 TechSolutionsTypes("Tech Solution Types");

  final  String  displayName;
}
