package com.icia.board.service;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.BoardFileDTO;
import com.icia.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) throws IOException {
        //첨부 파일이 없을때
        if(boardDTO.getBoardFile().isEmpty()){
            boardDTO.setFileAttached(0);
            boardRepository.save(boardDTO);
        }else{
            boardDTO.setFileAttached(1);
            BoardDTO savedBoard = boardRepository.save(boardDTO);
            // 파일만 따로 가져오기
            MultipartFile boardFile = boardDTO.getBoardFile();
            //파일 이름 가져오기
            String originalFilename = boardFile.getOriginalFilename();

            System.out.println("originalFilename = " + originalFilename);
            //저장용 이름 만들기
            System.out.println(System.currentTimeMillis());

            String storedFileName = System.currentTimeMillis() + "-" + originalFilename;
            System.out.println("storedFileName = " + storedFileName);
            BoardFileDTO boardFileDTO = new BoardFileDTO();
            boardFileDTO.setOriginalFileName(originalFilename);
            boardFileDTO.setStoredFileName(storedFileName);
            boardFileDTO.setBoardId(savedBoard.getId());
            //파일 저장용 폴더에 파일 저장 처리
            String savePath = "C:\\spring_img\\" + storedFileName;

            boardFile.transferTo(new File(savePath));
            boardRepository.saveFile(boardFileDTO);
        }
    }
    /*
    - 파일 있다.
        1. fileAttached=1, board_table에 저장 후 id값 받아오기
        2. 파일원본 이름 가져오기
        3. 저장용 이름 만들기
        4. 파일 저장용 폴더에 파일 저장
        5. board_file_table에 관련 정보 저장
    - 파일 없다.
        fileAttached=0, 나머지는 기존 방식과 동일

     */

    public List<BoardDTO> list() {
        List<BoardDTO> dbBoardList = boardRepository.list();
        if (dbBoardList != null) {
            return dbBoardList;
        }
        return null;
    }

    public BoardDTO findById(Long id) {
        BoardDTO dbBoardDetail = boardRepository.findById(id);
        if(dbBoardDetail != null) {
            return dbBoardDetail;
        }
        return null;
    }
    public void delete(Long id) {
        boardRepository.delete(id);
    }

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }
    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }
}
