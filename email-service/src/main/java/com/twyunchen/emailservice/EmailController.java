package com.twyunchen.emailservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email")
public class EmailController {

    @GetMapping("{userName}")
    public String getEmailAddress(@PathVariable String userName) {
        return userName + "@homework.com";
    }
}
