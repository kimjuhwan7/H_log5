package com.app.h_log.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

@Controller
@Log4j2
public class ImageViewController {

    @GetMapping(value = "/upload/photo/{fileName}", produces = MediaType.IMAGE_GIF_VALUE)
    @ResponseBody//view페이지에서 찾지 않도록 설정
    public ResponseEntity<byte[]> viewImage(
            //ResponseEntity 사용한 이유는 파일이 있을때와 없을때 구분하기 위해서 사용함
            @PathVariable("fileName") String fileName) throws IOException {
        log.info("ImageView Controller ... ");
        //파일이 있으면 바이트배열에 데이터를 넣어주고 status에는 OK 넣어줌
        byte[] imageByteArray = null;
        HttpStatus status = HttpStatus.NOT_FOUND;

        //파일경로에 + 전달받은파일 이름 전달받아 바이너리 코드로 반환
        File savedFile = new File(new File("").getAbsolutePath(), "photo\\" + fileName);
        // 저장소에 파일찾기
        if (savedFile.exists()) {
            //인풋스트림 응답처리
            InputStream imageStream = new FileInputStream(savedFile);
            //readAllBytes사용 파일읽기
            imageByteArray = imageStream.readAllBytes();
            //HttpStatus.NOT_FOUND 값을 OK로 바꿔주어 파일이 들어갔음을 알린다
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(imageByteArray, status);
    }

}
