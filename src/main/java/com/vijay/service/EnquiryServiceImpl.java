package com.vijay.service;

import com.vijay.entities.*;
import com.vijay.model.DashboardResponse;
import com.vijay.model.EnquiryForm;
import com.vijay.model.EnquirySearchCriteria;
import com.vijay.repo.CourseRepo;
import com.vijay.repo.EnqStatusRepo;
import com.vijay.repo.StudentEnqRepo;
import com.vijay.repo.UserDtlsRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EnquiryServiceImpl implements EnquiryService{

    @Autowired
    private UserDtlsRepo userDtlsRepo;
    @Autowired
    private EnqStatusRepo enqStatusRepo;

    @Autowired
    private StudentEnqRepo studentEnqRepo;

    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private HttpSession session;

    @Override
    public List<String> getCoursesName() {
        List<CourseEntity> all= courseRepo.findAll();
        List<String> names=new ArrayList<>();
        for(CourseEntity course: all){
            names.add(course.getCourseName());
        }
        return names;
    }

    @Override
    public List<String> getEnqStatus() {
        List<EnqStatusEntity> all = enqStatusRepo.findAll();
        List<String> states=new ArrayList<>();
        for(EnqStatusEntity status: all){
            states.add(status.getStatusName());
        }
        return states;
    }

    @Override
    public DashboardResponse getDashBoardDtata(Integer userId) {
        DashboardResponse dashboardResponse=new DashboardResponse();
        Optional<UserDtlsEntity> user= userDtlsRepo.findById(userId);

        if(user.isPresent()){
            UserDtlsEntity entity= user.get();
            List<StudentEnqEntity> enquiries= entity.getEnquiries();

            Integer totalCnt= enquiries.size();
            Integer enrolled = enquiries.stream().filter(e -> e.getEnquiryStatus().equals("Enrolled")).collect(Collectors.toList()).size();
            Integer lost = enquiries.stream().filter(e -> e.getEnquiryStatus().equals("Lost")).collect(Collectors.toList()).size();
            dashboardResponse.setEnqCnt(totalCnt);
            dashboardResponse.setEnrolledCnt(enrolled);
            dashboardResponse.setLostCnt(lost);
            dashboardResponse.setEmail(entity.getEmail());
            dashboardResponse.setName(entity.getName());
            dashboardResponse.setUserId(entity.getUserId());

        }
        return dashboardResponse;
    }

    @Override
    public boolean addEnquiry(EnquiryForm form) {
        StudentEnqEntity entity=new StudentEnqEntity();
        BeanUtils.copyProperties(form,entity);
        Integer userId = (Integer) session.getAttribute("userId");
        UserDtlsEntity userEntity= userDtlsRepo.findById(userId).get();
        entity.setUser(userEntity);
        studentEnqRepo.save(entity);
        return true;
    }




    @Override
    public List<StudentEnqEntity> getEnquiries() {
        Integer userId=(Integer) session.getAttribute("userId");
        Optional<UserDtlsEntity> byId= userDtlsRepo.findById(userId);
        if(byId.isPresent()){
            UserDtlsEntity entity= byId.get();
            List<StudentEnqEntity> enquiries= entity.getEnquiries();
            return enquiries;
        }
        return null;
    }
    @Override
    public List<StudentEnqEntity> getFilteredEnq(EnquirySearchCriteria criteria) {
        Integer userId =(Integer) session.getAttribute("userId");
        Optional<UserDtlsEntity> userDtlsOptional = userDtlsRepo.findById(userId);

        if (userDtlsOptional.isPresent()) {
            UserDtlsEntity entity = userDtlsOptional.get();
            List<StudentEnqEntity> enquiries = entity.getEnquiries();

            if (StringUtils.hasText(criteria.getCourseName())) {
                enquiries = enquiries.stream()
                        .filter(e -> e.getCourseName().equals(criteria.getCourseName()))
                        .collect(Collectors.toList());
            }

            if (StringUtils.hasText(criteria.getEnquiryStatus())) {
                enquiries = enquiries.stream()
                        .filter(e -> e.getEnquiryStatus().equals(criteria.getEnquiryStatus()))
                        .collect(Collectors.toList());
            }

            if (StringUtils.hasText(criteria.getClassMode())) {
                enquiries = enquiries.stream()
                        .filter(e -> e.getClassMode().equals(criteria.getClassMode()))
                        .collect(Collectors.toList());
            }
            System.out.println("Enq List :" +enquiries);

            return enquiries;
        }

        return Collections.emptyList(); // Return an empty list if user not present
    }

}
