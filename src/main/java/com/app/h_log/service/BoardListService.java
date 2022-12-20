package com.app.h_log.service;

import com.app.h_log.entity.Board;
import com.app.h_log.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardListService {

    @Autowired
    private BoardRepository boardRepository;


    public List<Board> getPage() {

        return boardRepository.findAll();
    }
}
