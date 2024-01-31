package com.vijay.model;

import com.vijay.entities.ChildUser;
import com.vijay.entities.UserDtlsEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
public class SignUpForm {

    private Integer userId;
    private String name;
    private String email;
    private Integer phoNo;
    private ChildUser user;
}
