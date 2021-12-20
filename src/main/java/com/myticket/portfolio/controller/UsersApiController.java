package com.myticket.portfolio.controller;

import com.myticket.portfolio.dto.users.UsersCreateRequestDto;
import com.myticket.portfolio.dto.users.UsersUpdateRequestDto;
import com.myticket.portfolio.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersApiController {

    private final UsersService usersService;

    @PostMapping("/join")
    public ResponseEntity joinUser(@RequestBody UsersCreateRequestDto requestDto) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/modify")
    public ResponseEntity modifyUser(@RequestBody UsersUpdateRequestDto requestDto) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
