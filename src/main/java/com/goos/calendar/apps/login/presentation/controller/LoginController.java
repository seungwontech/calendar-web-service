package com.goos.calendar.apps.login.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class LoginController {

    @GetMapping("/admin")
    public String createMembe(){
        return "hi";
    }
}
