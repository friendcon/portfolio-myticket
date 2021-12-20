package com.myticket.portfolio.dto.users;

import com.myticket.portfolio.domain.users.Users;
import lombok.Getter;

@Getter
public class UsersResponseDto {
    private Long id;
    private String userId;
    private String passwd;
    private String email;

    public UsersResponseDto(Users entity) {
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.passwd = entity.getPasswd();
        this.email = entity.getEmail();
    }
}
