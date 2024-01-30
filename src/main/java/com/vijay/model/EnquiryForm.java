package com.vijay.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class EnquiryForm {
    private String studentName;
    private Long studentPhno;
    private String classMode;
    private String courseName;
    private String enqStatus;
}
