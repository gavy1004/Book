package com.book.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.common.DAO;
import com.book.member.service.MemberService;
import com.book.member.vo.MemberVO;

public class MemberServiceImpl extends DAO implements MemberService {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	//페이징
		public List<MemberVO> memberListPaging(int page) {
			conn=DAO.getConnect();
			String sql = "select b.*\r\n" + "from(select rownum rn, a.* \r\n"
					+ "      from (select * from member n order by n.id)a\r\n" + "      )b\r\n"
					+ "   where b.rn between ? and ?";
			List<MemberVO> list = new ArrayList<>();

			int firstCnt = 0, lastCnt = 0;
			firstCnt = (page - 1) * 10 + 1; // 1, 11
			lastCnt = (page * 10);

			try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, firstCnt);
				psmt.setInt(2, lastCnt);

				rs = psmt.executeQuery();
				while (rs.next()) {
					MemberVO vo = new MemberVO();
					vo.setId(rs.getString("id"));
					vo.setName(rs.getString("name"));
					vo.setEmail(rs.getString("email"));
					vo.setPasswd(rs.getString("passwd"));
					vo.setPhone(rs.getString("phone"));
					list.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return list;
		}

	//id, passwd 체크
	public MemberVO loginCheck(MemberVO vo) {

		conn = DAO.getConnect();

		String sql = "select * from member where id=? and passwd=?";
		MemberVO rvo = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			rs = psmt.executeQuery();
			if (rs.next()) {
				rvo = new MemberVO();
				rvo.setId(rs.getString("id"));
				rvo.setEmail(rs.getString("email"));
				rvo.setName(rs.getString("name"));
				rvo.setPasswd(rs.getString("passwd"));
				rvo.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rvo;
	}

	//id중복체크
	public boolean idCheck(String id) {
		conn = DAO.getConnect();
		boolean exist = false;
		String sql = "select id from member where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				exist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return exist;
	}

	//전체조회
	@Override
	public List<MemberVO> selectMemberList() {
		List<MemberVO> list = new ArrayList<>();
		conn = DAO.getConnect();
		sql = "select * from member order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setPhone(rs.getString("phone"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public MemberVO selectMember() {
		return null;
	}

	@Override
	public int insertMember(MemberVO vo) {

		conn = DAO.getConnect();

		sql = "insert into member values(?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getPhone());
			psmt.setString(5, vo.getEmail());

			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}

	@Override
	public int updateMember(MemberVO vo) {
		return 0;
	}

	@Override
	public int deleteMember(MemberVO vo) {
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
