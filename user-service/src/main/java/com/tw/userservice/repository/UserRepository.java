package com.tw.userservice.repository;

import com.tw.userservice.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Page<User> findByNameLikeAndAgeBetween(String name, Integer minAge, Integer maxAge, Pageable pageInfo);
}
