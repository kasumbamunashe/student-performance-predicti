package com.zw.jimfish.service.jwt.auth;

import com.zw.jimfish.domain.enums.UserRole;
import com.zw.jimfish.domain.enums.repository.UserRepository;
import com.zw.jimfish.domain.enums.user.SignupRequest;
import com.zw.jimfish.domain.enums.user.User;
import com.zw.jimfish.domain.enums.user.UserDto;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    @Autowired
    private JavaMailSender mailSender;
    @PostConstruct
    public void createAdmin() {
        Optional<User> optionaluser = userRepository.findByUserRole(UserRole.ADMIN);
        if (!optionaluser.isPresent()) {
            User user = new User();
            user.setName("admin");
            user.setEmail("admin@test.co.zw");
            user.setPassword(new BCryptPasswordEncoder().encode("password"));
            user.setUserRole(UserRole.ADMIN);
            userRepository.save(user);
            System.out.println("Admin created successfully");
        }
        else {
            System.out.println("Admin already exists");
        }
    }

    @Override
    public UserDto signupUser(SignupRequest signupRequest) {
        User user = new User();
        user.setId(signupRequest.getId());
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setUserRole(UserRole.EMPLOYEE);
        User createdUser = userRepository.save(user);
        String to = signupRequest.getEmail();
        String subject = "Account Created Successfully";
        String text = "Dear " + signupRequest.getName() + ",\n\n" +
                "Your account has been successfully created. You can now proceed to login.\n\n" +
                "Best regards,\nWorkTrack Team";
        sendEmail(to, subject, text);
        return createdUser.getUserDto();
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}
