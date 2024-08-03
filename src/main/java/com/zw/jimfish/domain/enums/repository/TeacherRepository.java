package com.zw.jimfish.domain.enums.repository;

import com.zw.jimfish.domain.enums.teacher.Teacher;
import com.zw.jimfish.domain.enums.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
  Optional<User> findFirstByEmail(String Email);
}
