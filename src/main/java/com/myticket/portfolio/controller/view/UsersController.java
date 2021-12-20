package com.myticket.portfolio.controller.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
class UsersController {

    @GetMapping("/create")
    public String joinPage() {
        return "member/join";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "member/login";
    }
}
