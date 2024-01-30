package com.vijay.repo;

import com.vijay.entities.UserDtlsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentEnqRepo extends JpaRepository<UserDtlsEntity, Integer> {
}
