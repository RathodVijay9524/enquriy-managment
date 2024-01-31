package com.vijay.repo;

import com.vijay.entities.ChildUser;
import com.vijay.entities.UserDtlsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildUserRepo extends JpaRepository<ChildUser, Integer> {

    public ChildUser findByEmailAndPwd(String email, String pwd);
}
