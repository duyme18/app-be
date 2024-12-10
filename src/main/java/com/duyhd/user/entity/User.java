package com.duyhd.user.entity;

import com.duyhd.user.enums.RoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@Entity
@Table(name = "users")
@FieldNameConstants
public class User extends BaseEntity {

    @Column(name = "`username`", nullable = false)
    private String username;
    
    @Column(name = "`full_name`", nullable = false)
    private String fullName;

    @Column(name = "`email`", nullable = false)
    @Email
    private String email;

    @Column(name = "`phone_no`", nullable = false)
    private String phoneNo;

    @Column(name = "`avatar_url`")
    private String avatarUrl;

    @Column(name = "`status`")
    private String status;

    @Column(name = "`role`")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @Column(name = "`keycloak_user_id`")
    private String keycloakUserId;

}
