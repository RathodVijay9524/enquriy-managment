package com.vijay.controller;

import com.vijay.model.DashboardResponse;
import com.vijay.model.EnquiryForm;
import com.vijay.service.EnquiryService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EnquiryController {

    @Autowired
    private EnquiryService enquiryService;
    @Autowired
    private HttpSession session;

    @GetMapping("/logout")
    public String logout(){
        session.invalidate();
        return "index";
    }
    @GetMapping("/dashboard")
    public String dashboardPage(Model model){
        Integer userId =(Integer) session.getAttribute("userId");
        DashboardResponse dashboardData = enquiryService.getDashBoardDtata(userId);
        model.addAttribute("dashboardData",dashboardData);
        return "dashboard";
    }
    @PostMapping("/addEnq")
    public String addEnquiry(@ModelAttribute("formObject") EnquiryForm formObject, Model model){
        System.out.println(formObject);
        boolean status= enquiryService.addEnquiry(formObject);
        if(status){
            model.addAttribute("succMsg","Enq added.");
        }else {
            model.addAttribute("errMsg","Problem occurred");
        }
        return "add-enquiry";
    }

    @GetMapping("/enquiry")
    public String addEnquiryPage(Model model){
        List<String> coursesName= enquiryService.getCoursesName();
        List<String> enqStatus= enquiryService.getEnqStatus();
        EnquiryForm formObjct=new EnquiryForm();
        model.addAttribute("coursesName", coursesName);
        model.addAttribute("enqStatus", enqStatus);
        model.addAttribute("formObject", formObjct);

        return "add-enquiry";
    }



    @GetMapping("/enquires")
    public String viewEnquiriesPage(){
        return "view-enquiries";
    }
}
