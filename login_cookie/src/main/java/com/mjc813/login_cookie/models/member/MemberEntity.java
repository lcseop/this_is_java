package com.mjc813.login_cookie.models.member;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "member")
public class MemberEntity implements IMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sing_id", length = 20, nullable = false,  unique = true)
    private String signId;

    @Column(length = 200, nullable = false)
    private String password;

    @Column(length = 200, nullable = false, unique = true)
    private String email;

    @Column(name = "is_valid_email", nullable = false)
    private Boolean isValidEmail;

    @Column(name = "create_dt", nullable = false)
    private LocalDateTime createDt;

    @Column(name = "update_dt")
    private LocalDateTime updateDt;

    @Column(name = "delete_dt")
    private LocalDateTime deleteDt;
}
