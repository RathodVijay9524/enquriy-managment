package com.vijay.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
public class SignUpForm {

    private String name;
    private String email;

    private Integer phoNo;
}
