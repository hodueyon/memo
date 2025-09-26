package com.memo.memo.dto;


import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "메모 정보를 담는 DTO")
public class MemoDto {
    @Schema(description = "메모 ID", example = "1", defaultValue = "1")
    private Long id;

    @Schema(description = "메모 내용", example = "Memo Swagger Test!" , allowableValues = {"메모1", "메모2"})
    private String content;

    public MemoDto() {
    }

    public MemoDto(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MemoDto{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
