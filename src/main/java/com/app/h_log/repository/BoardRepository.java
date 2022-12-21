package com.app.h_log.repository;

import com.app.h_log.domain.Board.BoardDTO;
import com.app.h_log.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    @Transactional
    @Modifying
    @Query("delete from Board b where b.bno = :bno")
    int deleteByBno(Integer bno);




    @Transactional
    @Modifying
    @Query("update Board b set b.title = ?1, b.content = ?2, b.photo = ?3, b.updatedate = ?4 where b.bno = ?5")
    int updateTitleAndContentAndPhotoAndUpdatedateByBno(BoardDTO boardDTO, Integer bno);



}
