package com.memo.memo.service;

import com.memo.memo.dto.MemoDto;

import java.util.List;

public interface MemoService {
    List<MemoDto> getAllMemos();
    MemoDto createMemo(MemoDto memoDto);
    MemoDto getMemo(Integer id);
}
