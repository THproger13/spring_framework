package com.icia.memberboard.service;

import com.icia.memberboard.dto.BoardDTO;
import com.icia.memberboard.dto.BoardFileDTO;
import com.icia.memberboard.dto.PageDTO;
import com.icia.memberboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardService {
@Autowired
private BoardRepository boardRepository;
    public void save(BoardDTO boardDTO) throws IOException {
        if(boardDTO.getBoardFile().get(0).isEmpty()) {
            boardDTO.setFileAttached(0);
            boardRepository.save(boardDTO);
        }else {
            boardDTO.setFileAttached(1);
            BoardDTO savedBoard = boardRepository.save(boardDTO);
            List<MultipartFile> boardFileList = boardDTO.getBoardFile();
            for(MultipartFile boardFile : boardFileList) {
                String originalFileName = boardFile.getOriginalFilename();
                String storedFileName = System.currentTimeMillis() + "-" + originalFileName;
                BoardFileDTO boardFileDTO = new BoardFileDTO();
                boardFileDTO.setOriginalFileName(originalFileName);
                boardFileDTO.setStoredFileName(storedFileName);
                boardFileDTO.setBoardId(savedBoard.getBoardId());
                //로컬의 게시글 파일 저장용 폴더에 파일 저장 처리
                String savePath = "C:\\spring_board_img\\" + storedFileName;
                boardFile.transferTo(new File(savePath));
                boardRepository.saveFile(boardFileDTO);
            }
        }
    }

    public List<BoardDTO> pagingList(int page) {
        int pageLimit = 5; // 한페이지당 보여줄 글 갯수
        int pagingStart = (page - 1) * pageLimit;
        Map<String, Integer> pageParams = new HashMap<>();
        pageParams.put("start", pagingStart);
        pageParams.put("limit", pageLimit);
        return boardRepository.pagingList(pageParams);
    }

    public PageDTO pageNumber(int page) {
        int pageLimit = 5; // 한페이지에 보여줄 글 갯수
        int blockLimit = 3; // 하단에 보여줄 페이지 번호 갯수
        // 전체 글 갯수 조회
        int boardCount = boardRepository.boardCount();
        // 전체 페이지 갯수 계산
        int maxPage = (int) (Math.ceil((double) boardCount / pageLimit));
        // 시작 페이지 값 계산(1, 11, 21, 31 ~~)
        int startPage = (((int) (Math.ceil((double) page / blockLimit))) - 1) * blockLimit + 1;
        // 마지막 페이지 값 계산(10, 20, 30, 40 ~~)
        int endPage = startPage + blockLimit - 1;
        // 전체 페이지 갯수가 계산한 endPage 보다 작을 때는 endPage 값을 maxPage 값과 같게 세팅
        if (endPage > maxPage) {
            endPage = maxPage;
        }
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        pageDTO.setMaxPage(maxPage);
        pageDTO.setEndPage(endPage);
        pageDTO.setStartPage(startPage);
        return pageDTO;
    }

    public List<BoardDTO> searchList(String type, String q, int page) {
        Map<String, Object> searchParam = new HashMap<>();
        searchParam.put("type", type);
        searchParam.put("q", q);
        int pageLimit = 5; // 한페이지당 보여줄 글 갯수
        int pagingStart = (page - 1) * pageLimit;
        searchParam.put("start", pagingStart);
        searchParam.put("limit", pageLimit);

        return boardRepository.searchList(searchParam);
    }

    public PageDTO searchPageNumber(String q, String type, int page) {
        int pageLimit = 5; // 한페이지에 보여줄 글 갯수
        int blockLimit = 3; // 하단에 보여줄 페이지 번호 갯수
        Map<String, String> pagingParams = new HashMap<>();
        pagingParams.put("type", type);
        pagingParams.put("q", q);
        // 검색어 기준 전체 글 갯수 조회
        int boardCount = boardRepository.boardSearchCount(pagingParams);
        // 전체 페이지 갯수 계산
        int maxPage = (int) (Math.ceil((double) boardCount / pageLimit));
        // 시작 페이지 값 계산(1, 11, 21, 31 ~~)
        int startPage = (((int) (Math.ceil((double) page / blockLimit))) - 1) * blockLimit + 1;
        // 마지막 페이지 값 계산(10, 20, 30, 40 ~~)
        int endPage = startPage + blockLimit - 1;
        // 전체 페이지 갯수가 계산한 endPage 보다 작을 때는 endPage 값을 maxPage 값과 같게 세팅
        if (endPage > maxPage) {
            endPage = maxPage;
        }
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        pageDTO.setMaxPage(maxPage);
        pageDTO.setEndPage(endPage);
        pageDTO.setStartPage(startPage);
        return pageDTO;
    }
    public void upHits(Long boardId) {
        boardRepository.upHits(boardId);
    }

    public BoardDTO findById(Long boardId) {
        return boardRepository.findById(boardId);
    }
    public List<BoardFileDTO> findFile(Long boardId) {
        return boardRepository.findFile(boardId);
    }
}
