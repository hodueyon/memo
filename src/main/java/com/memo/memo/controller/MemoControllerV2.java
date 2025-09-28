package com.memo.memo.controller;

import com.memo.memo.dto.MemoDto;
import com.memo.memo.service.MemoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Memo", description = "메모 관련 API")
@RestController
@RequestMapping("/api/memo")
public class MemoControllerV2 {
    @Autowired
    private MemoService memoService;

    @Operation(summary = "전체 메모 조회", description = "저장된 모든 메모를 조회합니다.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "성공적으로 조회됨",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MemoDto.class),
                            examples = @ExampleObject(
                                    name = "메모 리스트 예제",
                                    value = "[{\"id\":1, \"content\":\"Test Memo 1\"}, {\"id\":2, \"content\":\"Test Memo 2\"}]"
                            )
                    )
            ),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    @GetMapping("/getMemoList")
    public List<MemoDto> getMemos() {
        ArrayList<MemoDto> result = new ArrayList<>();
        result.add(new MemoDto(1, "Test Memo 1"));
        result.add(new MemoDto(2, "Test Memo 2"));
        return result;
    }


    @Operation(summary = "단일 메모 조회", description = "단일 메모.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "성공적으로 조회됨",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MemoDto.class)
                    )
            ),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    @GetMapping("/getMemo")
    public MemoDto getMemo(@RequestParam("id") Long id){
        //
        MemoDto result = new MemoDto();
        if(id == 1){
            result.setId(1);
            result.setContent("1번메모");
        }else{
            result.setId(2);
            result.setContent("1번아닌메모");
        }

        return result;
    }

    @Operation(summary = "메모 생성", description = "새로운 메모를 저장합니다.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "성공적으로 저장됨",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MemoDto.class)
                    )
            ),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    @PostMapping("/insertMemo")
    public MemoDto insertMemo(
            @Parameter(description = "저장할 메모 정보", required = true)
            @RequestBody @Valid MemoDto memoDto
    ) {
        System.out.println("일단 이까지는 왔다");
        return memoDto;
    }


    @Operation(summary = "메모 수정", description = "메모 내용 수정 .")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "성공적으로 수정됨",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MemoDto.class)
                    )
            ),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
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
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "성공적으로 삭제됨",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MemoDto.class)
                    )
            ),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    public MemoDto deleteMemo(
            @Parameter(description = "삭제할 메모 정보", required = true)
            @RequestBody @Valid MemoDto memoDto
    ) {
        System.out.println("삭제 !");
        return memoDto;
    }

}
