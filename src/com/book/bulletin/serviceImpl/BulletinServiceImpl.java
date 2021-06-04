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

public class BulletinServiceImpl extends DAO implements BulletinService {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	@Override
	public List<BulletinVO> bulletinSelectList() {
		List<BulletinVO> list = new ArrayList<>();
		conn = DAO.getConnect();
		sql = "select * from bulletin order by 1";
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
		sql = "select * from bulletin where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			
			rs = psmt.executeQuery();
			if(rs.next()) {
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
		return 0;
	}

	@Override
	public int updateBulletin(BulletinVO vo) {
		conn = DAO.getConnect();
		return 0;
	}

	@Override
	public int deleteBulletin(BulletinVO vo) {
		conn = DAO.getConnect();
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
}
