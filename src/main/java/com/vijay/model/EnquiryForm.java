package com.vijay.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class EnquiryForm {
    private String studentName;
    private Integer phoNo;
    private String classMode;
    private String courseName;
    private String enquiryStatus;
}
