package com.drm.arithmeticcalculator.service;

import com.drm.arithmeticcalculator.auth.entity.UserPO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public interface UserService {

    List<UserPO> getAllUsers();
}
