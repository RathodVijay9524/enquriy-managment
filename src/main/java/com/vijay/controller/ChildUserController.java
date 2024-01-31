package com.vijay.controller;

import com.vijay.model.LoginForm;
import com.vijay.model.SignUpForm;
import com.vijay.service.ChildUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChildUserController {

    @Autowired
    private ChildUserService childUserService;



    @GetMapping("/childsignup")
    public String createChildUserPage(@RequestParam Integer userId, Model model){
        SignUpForm signUpForm=new SignUpForm();
        System.out.println("user ID :"+userId);
        signUpForm.setUserId(userId);
        model.addAttribute("user", signUpForm);
     return "childsignup";
    }

    @PostMapping("/workingUser")
    public String createChildUser(@ModelAttribute("user") SignUpForm user, Model model){
        System.out.println("User ::" +user);
        boolean status= childUserService.createWorkingUser(user);
        if(status){
            model.addAttribute("succMsg","Account Created Successfully !");
        }else{
            model.addAttribute("errMsg","Use Valid Account ! ");
        }
        return "childsignup";
    }
}
