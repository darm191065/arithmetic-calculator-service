package com.drm.arithmeticcalculator.auth.mapper;

import com.drm.arithmeticcalculator.auth.entity.RolePO;
import com.drm.arithmeticcalculator.auth.entity.UserPO;
import com.drm.arithmeticcalculator.auth.model.AuthenticatedUser;
import com.drm.arithmeticcalculator.auth.model.AuthenticatedUserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    AuthenticatedUser fromEntityToModel(UserPO user);

    @Mapping(target = "role", source = "role.name")
    AuthenticatedUserRole fromEntityToModel(RolePO role);


}
