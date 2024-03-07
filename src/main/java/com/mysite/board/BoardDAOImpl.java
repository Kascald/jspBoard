package com.mysite.board;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import common.JdbcUtil;


public class BoardDAOImpl implements BoardDAO {
	private JdbcUtil ju;
	
	public BoardDAOImpl() {
		ju = JdbcUtil.getInstance();
	}
	
	public int insert(BoardVO vo) throws UnsupportedEncodingException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String q = "INSERT INTO board(num , title , writer , content , regdate , cnt) values (board_seq.nextval , ? , ? , ?, sysdate , 0)";
		int ret = -1;
		try {
			conn = ju.getConnection();
			pstmt = conn.prepareStatement(q);
			pstmt.setString(1,vo.getTitle());
			pstmt.setString(2,vo.getWriter());
			pstmt.setString(3,vo.getContent());
			ret = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return ret;
	}
	
	public List<BoardVO> findAll() throws UnsupportedEncodingException {
		List<BoardVO> ls = new ArrayList<>();
		Connection conn = null ;
		Statement stmt = null;
		String q = "SELECT num, title, writer, content, regdate, cnt FROM board order by num desc";
		ResultSet rs = null;
		try {
			conn = ju.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(q);
			while(rs.next()) {
				BoardVO vo = new BoardVO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						new Date(rs.getDate(5).getTime()),
						rs.getInt(6));
						ls.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e	.printStackTrace();
				}
			}
			if(conn!= null) {
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return ls;
	}
	
	@Override
	public BoardVO selectOne(int num) throws UnsupportedEncodingException { //상세조회
		Connection conn = null ;
		PreparedStatement pstmt = null;
		String q = "SELECT num, title ,writer ,content, regdate, cnt FROM board WHERE num =?";
		ResultSet rs = null;
		BoardVO vo = null;
		try {
			conn = ju.getConnection();
			pstmt = conn.prepareStatement(q);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new BoardVO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						new Date(rs.getDate(5).getTime()) ,
						rs.getInt(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e	.printStackTrace();
				}
			}
			if(conn!= null) {
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(pstmt!= null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		}
		return vo;
	}


	public int update(BoardVO vo) throws UnsupportedEncodingException { //수정
		Connection conn = null;
		PreparedStatement pstmt = null;
		String q = "UPDATE board SET title=?, content=? where num=?";
		int ret = -1;
		try {
			conn = ju.getConnection();
			pstmt = conn.prepareStatement(q);
			pstmt.setString(1,vo.getTitle());
			pstmt.setString(2,vo.getContent());
			pstmt.setInt(3,vo.getNum());
			ret = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return ret;
	}


	public int delete(int num) {
		// TODO Auto-generated method stub
		int result = -1;
		return result;
	}
	

}
