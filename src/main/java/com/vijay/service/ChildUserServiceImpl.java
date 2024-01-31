package com.vijay.service;

import com.vijay.entities.ChildUser;
import com.vijay.entities.UserDtlsEntity;
import com.vijay.helper.PwdUtils;
import com.vijay.model.LoginForm;
import com.vijay.model.SignUpForm;
import com.vijay.repo.ChildUserRepo;
import com.vijay.repo.UserDtlsRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChildUserServiceImpl implements ChildUserService {

    @Autowired
    private ChildUserRepo childUserRepo;

    @Autowired
    private UserDtlsRepo userDtlsRepo;

    @Autowired
    HttpSession session;



    @Override
    public boolean createWorkingUser(SignUpForm form) {
        if (form != null) {
            // Assuming you have a UserDtlsEntity userEntity available, either from the form or fetched from the repository
            UserDtlsEntity userEntity = userDtlsRepo.findById(form.getUserId()).orElse(null);

            if (userEntity != null) {
                ChildUser childUser = new ChildUser();
                BeanUtils.copyProperties(form, childUser);

                // Set the UserDtlsEntity in ChildUser
                childUser.setUser(userEntity);
                childUser.setPwd("asdf");
                childUser.setAccStatus("Unlocked");
                childUserRepo.save(childUser);
                return true;
            } else {
                return false; // Handle the case where the user with the specified ID is not found
            }
        } else {
            return false;
        }
    }


}