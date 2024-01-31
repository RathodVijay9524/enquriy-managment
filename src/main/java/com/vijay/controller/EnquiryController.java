package com.vijay.controller;

import com.vijay.model.DashboardResponse;
import com.vijay.service.EnquiryService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    @GetMapping("/enquiry")
    public String addEnguiryPage(){
        return "add-enquiry";
    }
    @GetMapping("/enquires")
    public String viewEnquiriesPage(){
        return "view-enquiries";
    }
}
