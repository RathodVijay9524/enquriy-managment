package com.vijay.service;

import com.vijay.model.DashboardResponse;
import com.vijay.model.EnquiryForm;
import com.vijay.model.EnquirySearchCriteria;
import com.vijay.repo.CourseRepo;
import com.vijay.repo.EnqStatusRepo;
import com.vijay.repo.StudentEnqRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnquiryServiceImpl implements EnquiryService{

    @Autowired
    private EnqStatusRepo enqStatusRepo;

    @Autowired
    private StudentEnqRepo studentEnqRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<String> getCoursesName() {
        return null;
    }

    @Override
    public List<String> getEnqStatus() {
        return null;
    }

    @Override
    public DashboardResponse getDashBoardDtat(Integer userId) {
        return null;
    }

    @Override
    public String addEnquiry(EnquiryForm form) {
        return null;
    }

    @Override
    public List<EnquiryForm> getEnquries(Integer userId, EnquirySearchCriteria criteria) {
        return null;
    }

    @Override
    public EnquiryForm getEnquiry(Integer enqId) {
        return null;
    }
}
