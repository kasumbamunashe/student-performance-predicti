package com.zw.jimfish.domain.enums.repository;

import com.zw.jimfish.domain.enums.UserRole;
import com.zw.jimfish.domain.enums.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserRole(UserRole userRole);

    Optional<User> findFirstByEmail(String email);
}
