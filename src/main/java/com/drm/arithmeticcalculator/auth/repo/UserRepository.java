package com.drm.arithmeticcalculator.auth.repo;

import com.drm.arithmeticcalculator.auth.entity.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserPO, Long> {
    Optional<UserPO> findByUsername(String username);
}
