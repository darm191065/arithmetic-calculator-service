package com.drm.arithmeticcalculator.auth.repo;

import com.drm.arithmeticcalculator.auth.entity.RolePO;
import com.drm.arithmeticcalculator.auth.entity.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RolePO, Long> {

    Optional<RolePO> findByName(RoleType roleType);

}
