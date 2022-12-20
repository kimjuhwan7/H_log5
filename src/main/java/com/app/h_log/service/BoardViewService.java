package com.app.h_log.service;

import com.app.h_log.entity.Board;
import com.app.h_log.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardViewService {

    @Autowired
    private BoardRepository boardRepository;

    public Optional<Board> selectBoard(int bno) {
        return boardRepository.findById(bno);
    }
}
