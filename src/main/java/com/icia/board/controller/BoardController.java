package com.icia.board.controller;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.BoardFileDTO;
import com.icia.board.dto.PageDTO;
import com.icia.board.service.BoardService;
import com.icia.board.service.CommentService;
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
    @Autowired
    private CommentService commentService;

    @GetMapping("/save")
    public String save() {
        return "boardPages/boardSave";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) throws IOException {
        boardService.save(boardDTO);
        return "redirect:/board/list";
    }
    @GetMapping("/list")//required는 필수 파라미터인지 아닌지를 따져서 false이면 파라미터가
                            //없어도 오류 안뜸
    public String list(@RequestParam(value = "page", required = false,
                       defaultValue = "1") int page,
                       @RequestParam( value = "q", required = false,
                       defaultValue = "") String q,
                       @RequestParam( value = "type", required = false,
                               defaultValue = "boardTitle") String type,
            Model model) {
        //검색이든 아니든 필요한 정보 : boardList, paging
        List<BoardDTO> boardDTOList = null;
        PageDTO pageDTO = null;

        //검색 요청인지 아닌지 구분
        if(q.equals("")) {
            //일반 페이지 요청
            boardDTOList = boardService.pagingList(page);
            pageDTO = boardService.pageNumber(page);
        }else{
            //검색결과 페이지 요청
            boardDTOList = boardService.searchList(q, type, page);
            pageDTO = boardService.searchPageNumber(q, type, page);
        }

        List<BoardDTO> boardDTOList = boardService.pagingList(page);
        System.out.println("boardDTOList = " + boardDTOList);
        model.addAttribute("boardDTOList", boardDTOList);

        pageDTO = boardService.pageNumber(page);
        model.addAttribute("paging", pageDTO);
        model.addAttribute("q", q);
        model.addAttribute("type", type);
        model.addAttribute("page", page);
        if(boardDTOList != null) {
            return "boardPages/boardList";
        }
        return "index";
    }
    //게시글 상세 조회
    @GetMapping("/detail")
    public String findById(Model model, @RequestParam Long id,
                           @RequestParam(value = "page", required = false,
            defaultValue = "1") int page,
                           @RequestParam(value = "q", required = false, defaultValue = "") String q,
                           @RequestParam(value = "type", required = false, defaultValue = "boardTitle") String type) {
        //조회수 처리
        boardService.updateHits(id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);

        //첨부된 파일이 있다면 파일을 가져옴
        if(boardDTO.getFileAttached() == 1) {
            List<BoardFileDTO> boardFileDTOList = boardService.findFile(id);
            model.addAttribute("boardFileList", boardFileDTOList);
        }
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
    @GetMapping("/sample")
    public String sampleData() {
        for (int i = 1; i <= 20; i++) {
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setBoardWriter("aa");
            boardDTO.setBoardTitle("title" + i);
            boardDTO.setBoardContents("contents" + i);
            boardDTO.setBoardPass("pass" + i);
            boardService.sampleData(boardDTO);
        }
        return "redirect:/board/list";
    }
}
