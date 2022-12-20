package com.app.h_log.domain;

import com.app.h_log.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BoardWriteRequest {

    private String title;
    private String content;
    private String writer;

    private MultipartFile formFile;

    // 인서트시 사용함
    /*public BoardDTO toBoardDTO() {
        return BoardDTO.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }*/
    public Board toBoardEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }
}
