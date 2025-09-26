package com.memo.memo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
@Tag(name = "User v1", description = "회원 API v1")
public class UserControllerV1 {

    @Operation(summary = "전체 회원 조회")
    @GetMapping
    public String getUsers() {
        return "v1 전체 회원 리스트";
    }

}
