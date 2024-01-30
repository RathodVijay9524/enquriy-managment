package com.vijay.controller;

import com.vijay.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnquiryController {

    @Autowired
    private EnquiryService enquiryService;
    @GetMapping("/dashboard")
    public String dashboardPage(){

        return "dashboard";
    }
    @GetMapping("/enquiry")
    public String addEnguiryPage(){
        return "add-enquiry";
    }
    @GetMapping("/enquires")
    public String viewEnquiriesPage(){
        return "view-enquiries";
    }
}
