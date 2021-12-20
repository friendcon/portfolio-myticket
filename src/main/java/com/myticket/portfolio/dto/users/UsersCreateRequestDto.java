package com.myticket.portfolio.dto.users;

import com.myticket.portfolio.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersCreateRequestDto {
    private String userId;
    private String passwd;
    private String email;

    @Builder
    public UsersCreateRequestDto(String userId, String passwd, String email){
        this.userId = userId;
        this.passwd = passwd;
        this.email = email;
    }

    public Users toEntity() {
        return Users.builder().userId(userId).
                passwd(passwd).email(email).build();
    }
}
