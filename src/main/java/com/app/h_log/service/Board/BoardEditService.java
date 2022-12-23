package com.app.h_log.service.Board;

import com.app.h_log.domain.Board.BoardEditRequest;
import com.app.h_log.entity.Board;
import com.app.h_log.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@Log4j2
@Service
public class BoardEditService {

    @Autowired
    BoardRepository boardRepository;


    public int updateBoard(BoardEditRequest boardEditRequest) {

        MultipartFile file = boardEditRequest.getFormFile();
        File saveDir = null;
        String newFileName = null;
        if (file != null && !file.isEmpty()) {

            String absolutePath = new File("").getAbsolutePath();

            log.info(absolutePath);

            String path = "photo";
            // 기본경로 + 이미지 이름 붙여서 경로에 저장
            saveDir = new File(absolutePath, path);

            // 폴더가 존재하지 않으면 생성
            if (!saveDir.exists()) {
                //폴더 생성
                saveDir.mkdir();
                log.info(">>>>>>>photo dir 생성");
            }
            //랜덤 UUID 생성 (난수발생)
            String uuid = UUID.randomUUID().toString();
            // 새로운 파일 이름 생성
            newFileName = uuid + file.getOriginalFilename();
            //saveDir(저장경로)에 file.getOrig(실제 파일이름)을 넣어 새로운 저장파일의 경로를 만들어줌
            File newFile = new File(saveDir, newFileName);


            //  newFile 파일 저장
            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Board board = boardEditRequest.toBoardEntity();
        if (newFileName != null) {
            board.setPhoto(newFileName);
        }
        int result = 0;

        try {
            // db update
            //result = boardMapper.update(boardDTO);

            // 수정 시간 설정
            board.setUpdatedate(LocalDate.now());

            boardRepository.save(board);

            // 새로운 파일이 저장 되고 이전 파일이 존재한다면 ! -> 이전 파일을 삭제
            String oldFileName = boardEditRequest.getOldFile();
            if (newFileName != null && oldFileName != null && !oldFileName.isEmpty()) {
                File delOldFile = new File(saveDir, oldFileName);
                if (delOldFile.exists()) {
                    delOldFile.delete();
                    log.info(oldFileName + " 파일 삭제  ");
                }
            }


        } catch (Exception e) {
            log.info("SQLException ....파일 삭제");
            // 새롭게 저장된 파일 삭제
            if (newFileName != null) {
                File delFile = new File(saveDir, newFileName);
                if (delFile.exists()) {
                    // 파일 삭제
                    delFile.delete();
                }
            }
        }

        return result;

    }
}