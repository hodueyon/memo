package com.memo.memo.controller;

import com.memo.memo.dto.MemoDto;
import com.memo.memo.service.MemoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Memo", description = "메모 관련 API")
@RestController
@RequestMapping("/api/memo")
public class MemoControllerV2 {
    @Autowired
    private MemoService memoService;

    @Operation(summary = "전체 메모 조회", description = "저장된 모든 메모를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공적으로 조회됨"),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    @GetMapping("/getMemoList")
    public List<MemoDto> getMemos() {
        return memoService.getAllMemos();
    }

    @Operation(summary = "메모 생성", description = "새로운 메모를 저장합니다.")
    @PostMapping("/insertMemo")
    public MemoDto insertMemo(
            @Parameter(description = "저장할 메모 정보", required = true)
            @RequestBody @Valid MemoDto memoDto
    ) {
        System.out.println("일단 이까지는 왔다");
        return memoDto;
    }


    @Operation(summary = "메모 수정", description = "메모 내용 수정 .")
    @PutMapping("/modifyMemo")
    public MemoDto modifyMemo(
            @Parameter(description = "수정할 메모 정보", required = true)
            @RequestBody @Valid MemoDto memoDto
    ) {
        System.out.println("수정 !");
        return memoDto;
    }


    @Operation(summary = "메모 삭제", description = "메모 삭제 .")
    @DeleteMapping("/deleteMemo")
    public MemoDto deleteMemo(
            @Parameter(description = "삭제할 메모 정보", required = true)
            @RequestBody @Valid MemoDto memoDto
    ) {
        System.out.println("수정 !");
        return memoDto;
    }

}
