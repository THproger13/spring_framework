package com.icia.memberboard.controller;

import com.icia.memberboard.dto.BoardDTO;
import com.icia.memberboard.dto.BoardFileDTO;
import com.icia.memberboard.dto.CommentDTO;
import com.icia.memberboard.dto.PageDTO;
import com.icia.memberboard.service.BoardService;
import com.icia.memberboard.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/save")
    public String save() {
        return "/boardPages/save";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) throws IOException  {
        try {
            boardService.save(boardDTO);
        }catch(Exception e) {
            e.getCause();
            e.printStackTrace();
            System.out.println("e = " + e);
        }
        return "index";
    }

    @GetMapping("/list")
    public String findAll(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                          @RequestParam(value = "searchType", required = false, defaultValue = "boardTitle") String type,
                          @RequestParam(value = "q", required = false, defaultValue = "") String q,
                          Model model) {
        // 검색이든 아니든 필요한 정보: boardList, paging
        List<BoardDTO> boardDTOList = null;
        PageDTO pageDTO = null;
        // 검색 요쳥인지 아닌지 구분
        if (q.equals("")) {
            // 일반 페이지 요청
            boardDTOList = boardService.pagingList(page);
            pageDTO = boardService.pageNumber(page);
        } else {
            // 검색결과 페이지 요청
            boardDTOList = boardService.searchList(type, q, page);
            pageDTO = boardService.searchPageNumber(q, type, page);
        }
        model.addAttribute("boardList", boardDTOList);
        model.addAttribute("paging", pageDTO);
        model.addAttribute("q", q);
        model.addAttribute("type", type);
        return "boardPages/list";
    }

    @GetMapping
    public String detail(Model model,
                         @RequestParam("boardId") Long boardId,
                         @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                         @RequestParam(value = "searchType", required = false, defaultValue = "boardTitle") String type,
                         @RequestParam(value = "q", required = false, defaultValue = "") String q,
                         HttpServletResponse response, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        boolean isHitted = false;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("hit" + boardId)) {
                isHitted = true;
            }
        }
        if (!isHitted) {
            boardService.upHits(boardId);
            Cookie cookie = new Cookie("hit" + boardId, "1");
            cookie.setPath("/");
            cookie.setMaxAge(5 * 60);
            response.addCookie(cookie);
        }
        BoardDTO boardDTO = boardService.findById(boardId);
        if (boardDTO.getFileAttached() == 1) {
            List<BoardFileDTO> boardFileDTOList = boardService.findFile(boardId);
            model.addAttribute("boardFileList", boardFileDTOList);
        }
        model.addAttribute("board", boardDTO);

        model.addAttribute("page", page);
        model.addAttribute("q", q);
        model.addAttribute("type", type);

        List<CommentDTO> commentDTOList = commentService.findAll(boardId);
        if(commentDTOList.size() == 0) {
            model.addAttribute("commentList", null);
        }
        else{
            model.addAttribute("commentList", commentDTOList);
        }
        return "boardPages/detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("boardId") Long boardId) {
        BoardDTO boardDTO = boardService.findById(boardId);
        if(boardDTO.getFileAttached() == 1) {
            boardService.deleteFile(boardId);
        }
        boardService.delete(boardId);
        return "/boardPages/list";
    }

    @GetMapping("/update")
    public String update(Model model,
                         @RequestParam("boardId") Long boardId) {

        BoardDTO boardDTO = boardService.findById(boardId);
        if (boardDTO.getFileAttached() == 1) {
            List<BoardFileDTO> boardFileDTOList = boardService.findFile(boardId);
            model.addAttribute("boardFileList", boardFileDTOList);
        }
        model.addAttribute("board", boardDTO);

        return "boardPages/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, @RequestParam(value = "deleteFile", required = false) List<String> deleteFileName) throws IOException {
        boardService.update(boardDTO, deleteFileName);
        return "redirect:/board?boardId=" + boardDTO.getBoardId();
    }

}
