package com.vijay.service;

import com.vijay.model.DashboardResponse;
import com.vijay.model.EnquiryForm;
import com.vijay.model.EnquirySearchCriteria;

import java.util.List;

public interface EnquiryService {


    public List<String> getCoursesName();
    public List<String> getEnqStatus();
    public DashboardResponse getDashBoardDtata(Integer userId);
    public boolean addEnquiry(EnquiryForm form);
    public List<EnquiryForm> getEnquries(Integer userId, EnquirySearchCriteria criteria);
    public EnquiryForm getEnquiry(Integer enqId);


}
