package com.app.h_log.service;

import com.app.h_log.domain.BoardDTO;
import com.app.h_log.domain.BoardWriteRequest;
import com.app.h_log.entity.Board;
import com.app.h_log.repository.BoardRepository;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@Log4j2
@Service
public class BoardWriteService {

    @Autowired
    private BoardRepository boardRepository;


    public int write(BoardWriteRequest boardWriteRequest) {
        MultipartFile file = boardWriteRequest.getFormFile();

        File saveDir = null;
        String newFileName = null;
        if (file != null && !file.isEmpty() && file.getSize() > 0) {


            //이미지 저장 기본 경로
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

            // 파일객체 가져옴
            file = boardWriteRequest.getFormFile();
            //saveDir(저장경로)에 file.getOrig(실제 파일이름)을 넣어 새로운 저장파일의 경로를 만들어줌
            File newFile = new File(saveDir, newFileName);


            //  newFile 파일 저장
            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Board board = boardWriteRequest.toBoardEntity();

        if (newFileName != null) {
            board.setPhoto(newFileName);
        }
        int result = 0;
        try {
            //DB insert
            result = boardRepository.save(board) != null ? 1 : 0;
        } catch (Exception e) {
            if (newFileName != null) {
                //위에서 저장한 파일 경로 + 파일이름을 가져온다
                File delFile = new File(saveDir, newFileName);
                //파일이 있는지 확인
                if (delFile.exists()) {
                    //파일 삭제
                    delFile.delete();
                }
            }
        }
        return result;


    }
}
