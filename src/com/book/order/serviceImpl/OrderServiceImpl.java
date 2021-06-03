package com.book.order.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.common.DAO;
import com.book.order.service.OrderService;
import com.book.order.vo.OrderVO;

public class OrderServiceImpl extends DAO implements OrderService {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	@Override
	public List<OrderVO> selectOrderList() {
		List<OrderVO> list = new ArrayList<OrderVO>();
		conn = DAO.getConnect();
		sql = "select * from ordercode";
		try {
			psmt = conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()) {
				OrderVO vo = new OrderVO();
				vo.setEmail(rs.getString("email"));
				vo.setName(rs.getString("name"));
				vo.setCode(rs.getString("code"));
				vo.setPhone(rs.getString("phone"));
				
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
	public OrderVO selectOrder(OrderVO vo) {
		conn = DAO.getConnect();
		sql="select c.code, c.name, c.adress, c.phone, c.email, c.coments,\r\n"
				+ "      l.book_code, l.price, l.qty\r\n"
				+ "from ordercode c, orderlist l\r\n"
				+ "where c.code =? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getCode());
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo.setAdress(rs.getString("adress"));
				vo.setComents(rs.getString("coments"));
				vo.setEmail(rs.getString("email"));
				vo.setName(rs.getString("name"));
				vo.setCode(rs.getString("code"));
				vo.setPhone(rs.getString("phone"));
				vo.setBookCode(rs.getString("bookcode"));
				vo.setPrice(rs.getString("price"));
				vo.setQty(rs.getString("qty"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return vo;
	}


	@Override
	public int insertOrder(OrderVO vo) {
		conn = DAO.getConnect();
		sql="insert into ordercode values('od'||or_seq.nextval,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getName());
			psmt.setString(2, vo.getAdress());
			psmt.setString(3, vo.getAdress());
			psmt.setString(4, vo.getComents());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return 0;
	}

	@Override
	public int updateOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOrder(OrderVO vo) {
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
