package com.app.h_log.controller.Board;

import com.app.h_log.service.Board.BoardViewService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
public class BoardViewController {

    @Autowired
    private BoardViewService boardViewService;


    @GetMapping("/board/view")
    public void readArticle(@RequestParam("bno") int bno, Model model) {
        model.addAttribute("searchBno", boardViewService.selectBoard(bno));
        log.info("보드뷰컨트롤러 데이터"+boardViewService.selectBoard(bno));
    }
}
