package com.book.bulletin.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.bulletin.service.BulletinService;
import com.book.bulletin.vo.BulletinVO;
import com.book.common.DAO;
import com.book.notice.vo.NoticeVO;

public class BulletinServiceImpl extends DAO implements BulletinService {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	
	//페이징
	public List<BulletinVO> bulltinListPaging(int page) {
		conn = DAO.getConnect();
		sql = "select b.* from (select rownum rn,a.* from (select * from BULLETIN order by reg_date desc) a ) b \r\n"
				+ "where b.rn between ? and ?";
		List<BulletinVO> list = new ArrayList<>();
		
		int firstCnt = 0, lastCnt = 0;
		firstCnt = (page - 1) * 10 + 1; // 1page 1~11
		lastCnt = (page * 10); // 2page 11~20

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, firstCnt);
			psmt.setInt(2, lastCnt);
			rs = psmt.executeQuery();
			while(rs.next()) {
				BulletinVO vo = new BulletinVO();
				vo.setId(rs.getString("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setRegDate(rs.getDate("reg_date"));
				vo.setHit(rs.getInt("hit"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	//상세내용보기에서 후기조회
	public  List<BulletinVO> reviewSelect(BulletinVO vo) {
		List<BulletinVO> list = new ArrayList<>();
		conn = DAO.getConnect();
		sql = "select * from bulletin where book_code=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());
			rs = psmt.executeQuery();
			if(rs.next()) {
				hitCount(vo.getId());
				
				vo.setBookCode(rs.getString("book_code"));
				vo.setContent(rs.getString("content"));
				vo.setHit(rs.getInt("hit"));
				vo.setId(rs.getString("id"));
				vo.setRegDate(rs.getDate("reg_date"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	@Override
	public List<BulletinVO> bulletinSelectList() {
		conn = DAO.getConnect();
		List<BulletinVO> list = new ArrayList<>();
		sql = "select a.*, b.* from bulletin a , book b\r\n"
				+ "where a.BOOK_CODE = b.BOOK_CODE\r\n"
				+ "order by reg_date";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				BulletinVO vo = new BulletinVO();
				vo.setBookCode(rs.getString("book_code"));
				vo.setContent(rs.getString("content"));
				vo.setRegDate(rs.getDate("reg_date"));
				vo.setHit(rs.getInt("hit"));
				vo.setId(rs.getString("id"));
				vo.setWriter(rs.getString("writer"));
				vo.setTitle(rs.getString("title"));
				vo.setBookName(rs.getString("book_name"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	@Override
	public BulletinVO bulletinSelect(BulletinVO vo) {
		conn = DAO.getConnect();
		sql = "select a.*, b.book_name \r\n"
				+ "from bulletin a , book b \r\n"
				+ "where a.BOOK_CODE = b.BOOK_CODE\r\n"
				+ "and a.id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				hitCount(vo.getId());
				vo.setBookName(rs.getString("book_name"));
				vo.setBookCode(rs.getString("book_code"));
				vo.setContent(rs.getString("content"));
				vo.setHit(rs.getInt("hit"));
				vo.setId(rs.getString("id"));
				vo.setRegDate(rs.getDate("reg_date"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}


	@Override
	public int insertBulletin(BulletinVO vo) {
		conn = DAO.getConnect();
		sql ="insert into bulletin values(bu_seq.nextval,?,?,?,sysdate,0,?)";
		int r=0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());
			psmt.setInt(4, vo.getHit());
			
			r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return r;
	}


	@Override
	public int updateBulletin(BulletinVO vo) {
		conn = DAO.getConnect();
		String sql = "update bulletin set title=?,content=? where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getId());
			int r = psmt.executeUpdate();
			System.out.println(r+ "건 수정");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return 0;
	}

	@Override
	public int deleteBulletin(BulletinVO vo) {
		conn = DAO.getConnect();
		String sql = "delete from bulletin where id=?";
		try { 
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return 0;

	}
	
	private void close() {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (psmt != null)
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public void hitCount(String id) {
		String sql = "update bulletin set hit = hit + 1 where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
