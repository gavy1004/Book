package com.book.notice.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.common.DAO;
import com.book.notice.service.NoticeService;
import com.book.notice.vo.NoticeVO;
import com.book.order.vo.OrderVO;

public class NoticeserviceImpl extends DAO implements NoticeService {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	@Override
	public List<NoticeVO> selectNoticeList() {
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		conn = DAO.getConnect();
		sql = "select * from notice order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()) {
				NoticeVO vo = new NoticeVO();
				vo.setId(rs.getString("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
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

	@Override
	public NoticeVO selectNotice(NoticeVO vo) {
		conn = DAO.getConnect();
		sql = "select * from notice where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setHit(rs.getInt("hit"));
				vo.setContents(rs.getString("contents"));
				vo.setRegDate(rs.getDate("reg_date"));
				vo.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return vo;
	}

	@Override
	public int insertNotice(NoticeVO vo) {
		return 0;
	}

	@Override
	public int updateNotice(NoticeVO vo) {
		conn = DAO.getConnect();
		sql ="update notice set title=?, contents=? where id=?";
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContents());
			psmt.setString(3, vo.getId());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return 0;
	}

	@Override
	public int deleteNotice(NoticeVO vo) {
		conn = DAO.getConnect();
		sql ="delete from notice where id = ?";
		try {
			psmt=conn.prepareStatement(sql);
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

}
