package com.app.h_log.service.Board;

import com.app.h_log.entity.Board;
import com.app.h_log.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Log4j2
@Service
public class BoardViewService {

    @Autowired
    private BoardRepository boardRepository;

    public Board selectBoard(int bno) {

        Optional<Board> byId = boardRepository.findById(bno);
        log.info("보드뷰서비스 get()전 데이터"+byId);
        Board board = byId.get();
        log.info("보드뷰서비스 get()이후값"+board);
        return board;
    }
}
