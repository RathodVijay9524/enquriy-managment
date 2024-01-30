package com.vijay.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class DashboardResponse {

    private Integer totalEnquriesCnt;
    private Integer enrolledCnt;
    private Integer lostCnt;
}
