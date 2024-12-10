package com.project.uber.uberApp.services.impl;

import com.project.uber.uberApp.dto.DriverDto;
import com.project.uber.uberApp.dto.SignupDto;
import com.project.uber.uberApp.dto.UserDto;
import com.project.uber.uberApp.entities.User;
import com.project.uber.uberApp.entities.enums.Role;
import com.project.uber.uberApp.repositories.UserRepository;
import com.project.uber.uberApp.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    @Override
    public String login(String email, String password) {
        return null;
    }

    @Override
    public UserDto signup(SignupDto signupDto) {
        User user = userRepository.findByEmail(signupDto.getEmail());
        if(user !=null){
            throw new RuntimeException("user already exist with email"+signupDto.getEmail());
        }
        User user = modelMapper.map(signupDto, User.class);
        user.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(user);
        return null;
    }

    @Override
    public DriverDto onBoardNewDriver(Long userId) {
        return null;
    }
}
