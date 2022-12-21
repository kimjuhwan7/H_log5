package com.app.h_log.controller.Board;

import com.app.h_log.service.Board.BoardDeleteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
public class BoardDeleteController {

    @Autowired
    private BoardDeleteService boardDeleteService;

    @GetMapping("/board/delete")
    public String boardDelete(@RequestParam("bno") int bno) {
        log.info("보드딜리트입장");
        int result = boardDeleteService.boardDelete(bno);
        log.info("삭제완료" + result);
        return "redirect:/board/list";
    }

}
