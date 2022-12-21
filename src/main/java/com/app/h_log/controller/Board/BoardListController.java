package com.app.h_log.controller.Board;

import com.app.h_log.service.Board.BoardListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/board/list")
public class BoardListController {

    @Autowired
    private BoardListService boardListService;

    @GetMapping
    public void getBoardList(Model model) {
        log.info("보드리스트컨트롤러");
        model.addAttribute("boardList", boardListService.getPage());
    }
}
