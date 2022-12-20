package com.app.h_log.controller;

import com.app.h_log.domain.BoardDTO;
import com.app.h_log.domain.BoardWriteRequest;
import com.app.h_log.service.BoardListService;
import com.app.h_log.service.BoardWriteService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
@RequestMapping("/board/write")
@Log4j2
public class BoardWriteController {

    @Autowired
    private BoardWriteService boardWriteService;

    @GetMapping
    public String writeForm() {

        return "/board/write";
    }

    @PostMapping
    public String write(BoardWriteRequest boardWriteRequest) {

        log.info("<>>>>>>>>>>>>>" + boardWriteRequest);
        String absolutePath = new File("").getAbsolutePath();
        boardWriteService.write(boardWriteRequest);

        log.info(">>>path: " + absolutePath);
        return "redirect:/board/list";


    }

}
