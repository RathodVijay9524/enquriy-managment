package com.vijay.service;

import com.vijay.entities.ChildUser;
import com.vijay.entities.StudentEnqEntity;
import com.vijay.entities.UserDtlsEntity;
import com.vijay.model.DashboardResponse;
import com.vijay.model.EnquiryForm;
import com.vijay.model.EnquirySearchCriteria;
import com.vijay.repo.CourseRepo;
import com.vijay.repo.EnqStatusRepo;
import com.vijay.repo.StudentEnqRepo;
import com.vijay.repo.UserDtlsRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<String> getCoursesName() {
        return null;
    }

    @Override
    public List<String> getEnqStatus() {
        return null;
    }

    @Override
    public DashboardResponse getDashBoardDtata(Integer userId) {
        DashboardResponse dashboardResponse=new DashboardResponse();
        Optional<UserDtlsEntity> user= userDtlsRepo.findById(userId);

        if(user.isPresent()){
            UserDtlsEntity entity= user.get();
            List<StudentEnqEntity> enquiries= entity.getEnquiries();
            List<ChildUser> childUsers = entity.getChildUsers();
            Integer totalCnt= enquiries.size();
            Integer enrolled = enquiries.stream().filter(e -> e.getEnquiryStatus().equals("ENROLLED")).collect(Collectors.toList()).size();
            Integer lost = enquiries.stream().filter(e -> e.getEnquiryStatus().equals("LOST")).collect(Collectors.toList()).size();
            dashboardResponse.setTotalEnquriesCnt(totalCnt);
            dashboardResponse.setEnrolledCnt(enrolled);
            dashboardResponse.setLostCnt(lost);
            dashboardResponse.setEmail(entity.getEmail());
            dashboardResponse.setName(entity.getName());
            dashboardResponse.setUserId(entity.getUserId());
            dashboardResponse.setChildUsers(childUsers);
        }
        return dashboardResponse;
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
