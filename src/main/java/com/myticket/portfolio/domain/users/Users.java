package com.myticket.portfolio.domain.users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String userId;

    @Column(nullable = false)
    private String passwd;

    @Column(nullable = false)
    private String email;

    @Builder
    public Users(String userId, String passwd, String email){
        this.userId = userId;
        this.passwd = passwd;
        this.email = email;
    }

    public void update(String email){
        this.email = email;
    }
}
