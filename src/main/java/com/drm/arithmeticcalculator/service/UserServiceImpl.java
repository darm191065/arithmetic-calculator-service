package com.drm.arithmeticcalculator.service;

import com.drm.arithmeticcalculator.auth.entity.RolePO;
import com.drm.arithmeticcalculator.auth.entity.UserPO;
import com.drm.arithmeticcalculator.auth.entity.enums.RoleType;
import com.drm.arithmeticcalculator.auth.repo.RoleRepository;
import com.drm.arithmeticcalculator.auth.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public List<UserPO> getAllUsers(){
        return userRepository.findAll();
    }
}
