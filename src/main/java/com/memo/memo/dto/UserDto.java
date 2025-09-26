package com.memo.memo.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "회원 정보를 담는 DTO")
public class UserDto {
    @Schema(description = "회원 ID", example = "1", defaultValue = "1")
    private Integer id;
    @Schema(description = "회원 이름", example = "박이현", defaultValue = "박이현")
    private String name;
    @Schema(description = "회원 성별", example = "F", defaultValue = "F" , allowableValues = {"F", "M"})
    private String gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
