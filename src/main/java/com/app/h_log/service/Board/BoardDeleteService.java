package com.app.h_log.service.Board;

import com.app.h_log.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardDeleteService {

    @Autowired
    private BoardRepository boardRepository;

    public int boardDelete(int bno) {
        return boardRepository.deleteByBno(bno);


    }
}
