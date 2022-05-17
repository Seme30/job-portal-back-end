package com.sengg4.job_portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sengg4.job_portal.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUserName(String username);
}
