package com.mysite.board;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface BoardDAO {
	
  int insert(BoardVO vo) throws UnsupportedEncodingException;
  
  List<BoardVO> findAll() throws UnsupportedEncodingException;
  
  BoardVO selectOne(int num) throws UnsupportedEncodingException;
  
  int update(BoardVO vo) throws UnsupportedEncodingException;
  
  int updateCnt(int num);

  int delete(int num);
  
}

// 목록 요청 ( findAll() )
// 글 쓰기 링크
// 입력 (추가 insert() )
// 게시글 보기( 하나만 불러오기 selectOne() )
// 게시글 수정( Update )
// 조회수 증가 (updateCnt)
// 게시글 삭제( Delete ) -> 삭제 시 확인
