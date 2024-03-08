package com.mysite.board;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JdbcUtil;
// TODO:  BoardDAOImpl.java에서 반복되는 코드 리팩토링

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
			Closing cls = new Closing(conn, pstmt);
			cls.worked();
			cls = null;
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
				ls.add(rsSetting(rs,0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Closing cls = new Closing(conn, stmt, rs);
			cls.worked();
			cls = null;
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
				updateCnt(num);
				vo = rsSetting(rs,1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Closing cls = new Closing(conn, pstmt, rs);
			cls.worked();
			cls = null;

		}
		return vo;
	}


	@Override
	public int update(BoardVO vo) throws UnsupportedEncodingException {
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
			Closing cls = new Closing(conn, pstmt);
			cls.worked();
			cls = null;
		}
		
		return ret;
	}

	@Override
	public int delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String q = "DELETE FROM board where num=?";
		int ret = -1;
		try {
			conn = ju.getConnection();
			pstmt = conn.prepareStatement(q);
			pstmt.setInt(1, num);
			ret = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Closing cls = new Closing(conn, pstmt);
			cls.worked();
			cls = null;
		}
		return ret;
	}
	


	@Override
	public int updateCnt(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String q = "UPDATE board SET cnt = cnt+1 where num =?";
		int ret = -1;
		try {
			conn = ju.getConnection();
			pstmt = conn.prepareStatement(q);
			pstmt.setInt(1, num);
			ret = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Closing cls = new Closing(conn, pstmt);
			cls.worked();
			cls = null;
		}
		return ret;

	}


	private BoardVO rsSetting(ResultSet rs,int one) throws SQLException {
		BoardVO vo;
		vo = new BoardVO(
				rs.getInt(1),	 //num
				rs.getString(2), //title
				rs.getString(3), //writer
				rs.getString(4), //content
				new Date(rs.getDate(5).getTime()) , //regdate
				rs.getInt(6)+ one); //cnt
		return vo;
	}

}
