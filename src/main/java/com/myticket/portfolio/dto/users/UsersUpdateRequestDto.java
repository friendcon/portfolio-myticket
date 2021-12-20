package com.myticket.portfolio.dto.users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersUpdateRequestDto {
    private String passwd;
    private String email;

    @Builder
    public UsersUpdateRequestDto(String passwd, String email) {
        this.passwd = passwd;
        this.email = email;
    }
}
