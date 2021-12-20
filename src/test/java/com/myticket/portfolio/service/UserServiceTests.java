package com.myticket.portfolio.service;

import com.myticket.portfolio.domain.users.Users;
import com.myticket.portfolio.dto.users.UsersCreateRequestDto;
import com.myticket.portfolio.dto.users.UsersResponseDto;
import com.myticket.portfolio.dto.users.UsersUpdateRequestDto;
import com.myticket.portfolio.repository.UsersRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTests {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersRepository usersRepository;

    private UsersCreateRequestDto requestDto = UsersCreateRequestDto.builder().userId("sleep1217")
            .passwd("sleep1217")
            .email("sleep1217@gmail.com").build();

    @After
    public void cleanUp() {
        usersRepository.deleteAll();
    }

    @Test
    @DisplayName("회원가입 성공")
    public void createUserTest() {
        usersService.createUser(requestDto);

        List<Users> usersList = usersRepository.findAll();
        Users users = usersList.get(0);
        assertThat(requestDto.getUserId()).isEqualTo(users.getUserId());
        assertThat(requestDto.getEmail()).isEqualTo(users.getEmail());
        assertThat(requestDto.getPasswd()).isEqualTo(users.getPasswd());
    }

    @Test
    @DisplayName("회원정보 수정")
    public void updateUserTest() {
        Long id = usersService.createUser(requestDto);
        UsersUpdateRequestDto updateRequestDto =
                UsersUpdateRequestDto.builder().email("sleepwow@gmail.com").build();
        usersService.updateUser(id, updateRequestDto);

        List<Users> usersList = usersRepository.findAll();
        Users users = usersList.get(0);

        assertThat(users.getEmail()).isEqualTo("sleepwow@gmail.com");
    }

    @Test
    @DisplayName("회원정보 조회")
    public void getUserTest(){
        Long id = usersService.createUser(requestDto);
        UsersResponseDto responseDto = usersService.getUser(id);
        assertThat("sleep1217").isEqualTo(responseDto.getUserId());
        assertThat("sleep1217@gmail.com").isEqualTo(responseDto.getEmail());
    }

    @Test
    @DisplayName("아이디 중복 조회")
    public void checkUserIdDuplicateTest() {
        usersService.createUser(requestDto);
        boolean checkResult = usersService.checkUserIdDuplicate("sleep1217");
        boolean checkResult2 = usersService.checkUserIdDuplicate("sleep1218");
        assertThat(checkResult).isTrue();
        assertThat(checkResult2).isFalse();
    }
}
