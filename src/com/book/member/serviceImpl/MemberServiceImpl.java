package com.book.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.book.common.DAO;
import com.book.member.service.MemberService;
import com.book.member.vo.MemberVO;

public class MemberServiceImpl extends DAO implements MemberService {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	@Override
	public List<MemberVO> selectMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO selectMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMember(MemberVO vo) {
		
		DAO.getConnect();
		conn=DAO.getConnect();
		
		sql="insert into member values(?,?,?,?,?,?);";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getPhone());
			psmt.setString(5, vo.getEmail());
			psmt.setString(6, vo.getId());
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return 0;
	}

	@Override
	public int updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void close() {
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(psmt!=null)
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
