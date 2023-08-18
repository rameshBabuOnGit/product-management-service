package com.retailhub.productmanagementservice.controller;

import com.retailhub.productmanagementservice.model.UserDetail;
import com.retailhub.productmanagementservice.service.UserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserDetailService userDetailService;

    public UserController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping(value = "/authentication/{userName}")
    public ResponseEntity<UserDetail> authenticateUser(@PathVariable String userName, @RequestParam String password) {
        return new ResponseEntity<>(userDetailService.authenticateUser(userName, password), HttpStatus.OK);
    }
}
