package com.memo.memo.service.serviceImpl;

import com.memo.memo.dto.MemoDto;
import com.memo.memo.service.MemoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MemoServiceImpl implements MemoService {
    private final List<MemoDto> memoList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();
    @Override
    public List<MemoDto> getAllMemos() {
        return memoList;
    }

    @Override
    public MemoDto createMemo(MemoDto memoDto) {
        memoDto.setId(idCounter.incrementAndGet());
        memoList.add(memoDto);
        return memoDto;
    }

    @Override
    public MemoDto getMemo(Long id) {
        MemoDto resultMemo = new MemoDto();
        String content = id == 1 ? "1번글" : "1번글 아님";
        resultMemo.setId(id);
        resultMemo.setContent(content);

        return resultMemo;
     }
}
