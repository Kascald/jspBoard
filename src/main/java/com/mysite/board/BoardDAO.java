package com.mysite.board;

import java.util.List;

public interface BoardDAO {
	
  int insert(BoardVO vo);
  
  List<BoardVO> findAll();
  
  BoardVO selectOne();
  
  int update(BoardVO vo);
  
  int delete(BoardVO vo);
  
}

// 목록 요청 ( findAll() )
// 글 쓰기 링크
// 입력 (추가 insert() )
// 게시글 보기( 하나만 불러오기 selectOne() )
// 게시글 수정( Update )
// 게시글 삭제( Delete ) -> 삭제 시 확인
