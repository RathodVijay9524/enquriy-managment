package com.vijay.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="enquries_tbl")
public class StudentEnqEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer enquiryId;
    private String studentName;

    private  Integer phoNo;
    private String classMode;
    private String CourseName;
    private String enquiryStatus;
    private Date createdDate;
    private Date updatedDate;
    private Integer userId;

}
