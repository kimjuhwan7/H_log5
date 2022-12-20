package com.app.h_log.controller;

import com.app.h_log.service.BoardViewService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@Controller
@RequestMapping("/board/view/")
public class BoardViewController {

    @Autowired
    private BoardViewService boardViewService;


    @GetMapping
    public void readArticle(@RequestParam("bno") int bno, Model model) {
        model.addAttribute("searchBno", boardViewService.selectBoard(bno));
    }
}
