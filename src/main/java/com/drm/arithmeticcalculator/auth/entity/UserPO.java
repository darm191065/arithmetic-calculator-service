package com.drm.arithmeticcalculator.auth.entity;


import com.drm.arithmeticcalculator.auth.entity.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS", catalog = "AUTHORIZATION")
public class UserPO implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String username;

    private String name;
//    @Column
//    private String username;
//    @Column
//    private String email;
    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorityList = new java.util.ArrayList<>(role.getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .toList());

        authorityList.add(new SimpleGrantedAuthority("ROLE_" + this.role));

        return authorityList;
    }

}
