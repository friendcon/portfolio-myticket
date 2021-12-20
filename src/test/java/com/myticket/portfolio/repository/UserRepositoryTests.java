package com.myticket.portfolio.repository;

import com.myticket.portfolio.domain.users.Users;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTests {
    @Autowired
    private UsersRepository usersRepository;
    // 단위테스트 종료 시 수행되는 메서드 지정

    @After
    public void cleanUp(){
        usersRepository.deleteAll();
    }

    @Test
    public void 회원가입() {
        String user_id = "sleep1216";
        String password = "sleep1216";
        String email = "sleep1216@gmail.com";

        // save : insert, update
        usersRepository.save(Users.builder().userId(user_id).passwd(password)
        .email(email).build());

        // findAll : 테이블 전체 조회
        List<Users> usersList = usersRepository.findAll();

        Users users = usersList.get(0);
        assertThat(users.getUserId()).isEqualTo(user_id);
        assertThat(users.getEmail()).isEqualTo(email);
    }

    @Test
    public void 회원정보수정() {
        String user_id = "sleep1216";
        String password = "sleep1216";
        String email = "sleep1216@gmail.com";

        Users users = usersRepository.save(Users.builder().userId(user_id)
                .passwd(password).email(email).build());

        users.update("sleep1217@gmail.com");
        usersRepository.save(users);

        assertThat(users.getEmail()).isEqualTo("sleep1217@gmail.com");
    }
}
