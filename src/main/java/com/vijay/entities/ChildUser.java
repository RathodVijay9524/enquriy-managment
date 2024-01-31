package com.vijay.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class ChildUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer childUserId;
    private String name;
    private String email;
    private Integer phoNo;
    private String pwd;
    private String accStatus;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserDtlsEntity user;

}
