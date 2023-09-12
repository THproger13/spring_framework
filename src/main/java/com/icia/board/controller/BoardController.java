package com.icia.board.controller;

import com.icia.board.dto.BoardDTO;
import com.icia.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;
    @GetMapping("/save")
    public String save() {
        return "boardPages/boardSave";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) throws IOException {
        boardService.save(boardDTO);
        return "index";
    }
    @GetMapping("/list")
    public String list(Model model) {
        List<BoardDTO> boardDTOList = boardService.list();
        model.addAttribute("boardDTOList", boardDTOList);
        if(boardDTOList != null) {
            return "boardPages/boardList";
        }
        return "index";
    }
    //게시글 상세 조회
    @GetMapping("/detail")
    public String findById(Model model, @RequestParam Long id) {
        boardService.updateHits(id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        if(boardDTO != null) {
            return "boardPages/boardDetail";
        }else{
            return "boardPages/boardList";
        }
    }
    @GetMapping("/update")
    public String update(@RequestParam Long id, Model model) {
        BoardDTO boardDTO= boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "boardPages/boardUpdate";
    }
    @PostMapping("update")
    public String update(@ModelAttribute BoardDTO boardDTO) {
        boardService.update(boardDTO);
        return "boardPages/boardDetail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id, Model model) {
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "boardPages/deleteCheck";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        boardService.delete(id);
        return "boardPages/boardList";
    }
}
