package com.book.bulletin.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BulletinVO bulletinSelect(BulletinVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBulletin(BulletinVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBulletin(BulletinVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBulletin(BulletinVO vo) {
		// TODO Auto-generated method stub
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
