package com.app.h_log.controller.Board;

import com.app.h_log.domain.Board.BoardEditRequest;
import com.app.h_log.service.Board.BoardEditService;
import com.app.h_log.service.Board.BoardViewService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequestMapping("board/edit")
public class BoardEditController {

    @Autowired
    BoardViewService boardViewService;

    @Autowired
    BoardEditService boardEditService;

    @GetMapping
    public void editForm(@RequestParam("bno") int bno, Model model) {
        model.addAttribute("searchBno", boardViewService.selectBoard(bno));
        log.info(boardViewService.selectBoard(bno));
    }


    @PostMapping
    public String edit(BoardEditRequest boardEditRequest, RedirectAttributes redirectAttributes) {

        log.info("리다이랙트어트리브트" + boardEditRequest);

        redirectAttributes.addAttribute("bno", boardEditRequest.getBno());
        boardEditService.updateBoard(boardEditRequest);

        return "redirect:/board/list";
    }

}
