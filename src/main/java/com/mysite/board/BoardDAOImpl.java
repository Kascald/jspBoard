package com.mysite.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JdbcUtil;


public class BoardDAOImpl implements BoardDAO {
	private JdbcUtil ju;
	
	public BoardDAOImpl() {
		ju = JdbcUtil.getInstance();
	}
	
	public int insert(BoardVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String q = "INSERT INTO board(number , title , writer , content , regDate , viewCnt) values "
				+ "(board_seq.nextval , ? , ? , ?, sysdate , 0)";
		int ret = -1;
		try {
			conn = ju.getConnection();
			pstmt = conn.prepareStatement(q);
			pstmt.setString(1,vo.getTitle());
			pstmt.setString(2,vo.getWriter());
			pstmt.setString(3,vo.getContent());
			ret = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ret;
	}
	
	public List<BoardVO> findAll() {
		List<BoardVO> ls = new ArrayList<BoardVO>();
		Connection conn = null ;
		Statement stmt = null;
		String q = "SELECT num, title ,writer ,content, regDate, cnt FROM board_table";
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
						rs.getDate(5),
						rs.getInt(6));
						ls.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					// TODO: handle exception
					e	.printStackTrace();
				}
			}
			if(conn!= null) {
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
		return ls;
	}
	

	public BoardVO selectOne() { //상세조회
		BoardVO vo = null;
		return vo;
	}


	public int update(BoardVO vo) {
		// TODO Auto-generated method stub
		int result = -1;
		return 0;
	}


	public int delete(BoardVO vo) {
		// TODO Auto-generated method stub
		int result = -1;
		return 0;
	}
	

}
