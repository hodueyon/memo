package com.memo.memo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/users")
@Tag(name = "users v2", description = "회원 API v2")
public class UserControllerV2 {
    @Operation(summary = "v2 - 전체 회원 조회")
    @GetMapping
    public String getUsers() {
        return "v2 전체 회원 리스트";
    }
}
