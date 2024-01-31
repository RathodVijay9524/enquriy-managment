package com.vijay.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class DashboardResponse {

    private String email;
    private String name;
    private Integer totalEnquriesCnt;
    private Integer enrolledCnt;
    private Integer lostCnt;
}
