package com.memo.memo.controller;

import com.memo.memo.dto.MemoDto;
import com.memo.memo.service.MemoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Memo", description = "메모 관련 API")
@RestController
@RequestMapping("/memos")
public class MemoController {
    @Autowired
    private MemoService memoService;

    @Operation(summary = "전체 메모 조회", description = "저장된 모든 메모를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공적으로 조회됨"),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    @GetMapping
    public List<MemoDto> getMemos() {
        return memoService.getAllMemos();
    }

    @Operation(
            summary = "메모 단건 조회",
            description = "메모 ID를 이용해 특정 메모를 조회합니다.",
            tags = {"Memo API"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공적으로 메모를 조회했습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다."),
            @ApiResponse(responseCode = "404", description = "메모를 찾을 수 없습니다."),
            @ApiResponse(responseCode = "500", description = "서버 오류입니다.")
    })
    @GetMapping("/{id}")
    public MemoDto getMemoById(
            @Parameter(
                    name = "id",
                    description = "조회할 메모의 고유 ID",
                    required = true,
                    example = "1"
            )
            @PathVariable Integer id,
            @Parameter(
                    name = "includeDetails",
                    description = "상세 정보를 포함할지 여부",
                    required = false,
                    example = "true"
            )
            @RequestParam(required = false) Boolean includeDetails
    ) {
        return  memoService.getMemo(id);
    }

    @Operation(summary = "메모 생성", description = "새로운 메모를 저장합니다.")
    @PostMapping
    public MemoDto createMemo(
            @Parameter(description = "저장할 메모 정보", required = true)
            @RequestBody @Valid MemoDto memoDto
    ) {
        return memoService.createMemo(memoDto);
    }



}
