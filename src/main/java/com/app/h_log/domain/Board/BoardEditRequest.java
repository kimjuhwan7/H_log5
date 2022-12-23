package com.app.h_log.domain.Board;

import com.app.h_log.entity.Board;
import com.app.h_log.repository.BoardRepository;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardEditRequest {

    private int bno;
    private String title;
    private String writer;     // String -> Integer
    private String content;
    private String oldFile;
    private MultipartFile formFile;


    public Board toBoardEntity() {
        return Board.builder()
                .bno(bno)
                .writer(writer)
                .title(title)
                .content(content)
                .photo(oldFile.isEmpty() ? null : oldFile)
                .build();
    }


}
