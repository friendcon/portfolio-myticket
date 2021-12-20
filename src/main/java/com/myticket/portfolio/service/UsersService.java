package com.myticket.portfolio.service;

import com.myticket.portfolio.domain.users.Users;
import com.myticket.portfolio.dto.users.UsersCreateRequestDto;
import com.myticket.portfolio.dto.users.UsersResponseDto;
import com.myticket.portfolio.dto.users.UsersUpdateRequestDto;
import com.myticket.portfolio.exception.users.UserNotFoundException;
import com.myticket.portfolio.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    // 회원가입
    @Transactional
    public Long createUser(UsersCreateRequestDto requestDto) {
        return usersRepository.save(requestDto.toEntity()).getId();
    }

    // 회원정보 수정
    @Transactional
    public Long updateUser(Long id, UsersUpdateRequestDto requestDto) {
        Users users = usersRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("해당 회원이 없습니다. id=" + id));
        users.update(requestDto.getEmail());
        return id;
    }

    // 회원정보 조회
    public UsersResponseDto getUser(Long id){
        Users users = usersRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("해당 회원이 없습니다" + id));
        return new UsersResponseDto(users);
    }

    // 회원 아이디 중복 조회
    public boolean checkUserIdDuplicate(String userId) {
        return usersRepository.existsByUserId(userId);
    }

}
