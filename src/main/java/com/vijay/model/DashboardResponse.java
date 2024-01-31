package com.vijay.model;

import com.vijay.entities.ChildUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
public class DashboardResponse {

    private Integer userId;
    private String email;
    private String name;
    private Integer totalEnquriesCnt;
    private Integer enrolledCnt;
    private Integer lostCnt;
    private List<ChildUser> childUsers;
}
