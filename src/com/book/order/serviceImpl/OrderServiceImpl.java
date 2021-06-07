package com.book.order.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.bulletin.vo.BulletinVO;
import com.book.common.DAO;
import com.book.order.service.OrderService;
import com.book.order.vo.OrderListVO;
import com.book.order.vo.OrderVO;

public class OrderServiceImpl extends DAO implements OrderService {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	
	// 본인 아이디로 확인 페이징
	public List<OrderVO> orderListPaging(int page, String id) {
		conn = DAO.getConnect();
		String sql = "select b.* from(select rownum rn, a.* \r\n"
				+ "from (select n.* from ORDERCODE n, member m where n.name = m.name and m.id = ? order by n.code)a)b\r\n"
				+ "where b.rn between ? and ?";
		List<OrderVO> list = new ArrayList<>();

		int firstCnt = 0, lastCnt = 0;
		firstCnt = (page - 1) * 10 + 1; // 1, 11
		lastCnt = (page * 10);

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(2, firstCnt);
			psmt.setInt(3, lastCnt);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				OrderVO vo = new OrderVO();
				vo.setCode(rs.getString("code"));
				vo.setEmail(rs.getString("email"));
				vo.setName(rs.getString("name"));
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

	//관리자 페이징
	public List<OrderVO> orderListAdminPaging(int page) {
		conn = DAO.getConnect();
		sql = "select b.* from (select rownum rn,a.* from (select * from ORDERCODE order by code desc) a ) b \r\n"
				+ "where b.rn between ? and ?";
		List<OrderVO> list = new ArrayList<>();
		
		int firstCnt = 0, lastCnt = 0;
		firstCnt = (page - 1) * 10 + 1; // 1page 1~11
		lastCnt = (page * 10); // 2page 11~20

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, firstCnt);
			psmt.setInt(2, lastCnt);
			rs = psmt.executeQuery();
			while(rs.next()) {
				OrderVO vo = new OrderVO();
				vo.setCode(rs.getString("code"));
				vo.setEmail(rs.getString("email"));
				vo.setName(rs.getString("name"));
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
	public List<OrderVO> selectOrderList(String id) {
		List<OrderVO> list = new ArrayList<OrderVO>();
		conn = DAO.getConnect();
		sql = "select * from ordercode o, member m where o.name = m.name and m.id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				OrderVO vo = new OrderVO();
				vo.setEmail(rs.getString("email"));
				vo.setName(rs.getString("name"));
				vo.setCode(rs.getString("code"));
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
	public OrderVO selectOrder(OrderVO vo) {
		conn = DAO.getConnect();
		sql = "select c.code, c.name, c.adress, c.phone, c.email, c.coments,\r\n"
				+ "      l.book_code, l.price, l.qty\r\n" + "from ordercode c, orderlist l\r\n" + "where c.code =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getCode());
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo.setCode(rs.getString("code"));
				vo.setAdress(rs.getString("adress"));
				vo.setComents(rs.getString("coments"));
				vo.setEmail(rs.getString("email"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
				vo.setBookCode(rs.getString("book_code"));
				vo.setPrice(rs.getString("price"));
				vo.setQty(rs.getString("qty"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return vo;
	}

	@Override
	public int insertOrder(OrderVO vo) {
		String newOrder = getNextOrderNo();
		conn = DAO.getConnect();
		sql = "insert into ordercode values(?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, newOrder);
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getAdress());
			psmt.setString(4, vo.getPhone());
			psmt.setString(5, vo.getComents());
			psmt.setString(6, vo.getEmail());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
			insertListOrder(newOrder, vo.getName());
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return 0;
	}

	public String getNextOrderNo() {
		String newOrder = "";
		conn = DAO.getConnect();
		sql = "select 'od'||or_seq.nextval from dual";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				newOrder = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return newOrder;
	}

	public void insertListOrder(String newOrder, String id) {
		sql = "select c.book_code, c.book_qty, b.price, b.sale_price\r\n" + "from cart c, book b, member m\r\n"
				+ "where c.book_code = b.BOOK_CODE\r\n" + "and m.id = c.user_id\r\n" + "and m.name = ?";
		List<OrderListVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				OrderListVO order = new OrderListVO();
				order.setBookCode(rs.getString("book_code"));
				order.setCode(newOrder);
				order.setPrice(rs.getString("price"));
				order.setQty(rs.getString("book_qty"));
				list.add(order);
			}
			sql = "insert into orderlist values(?,?,?,?)";
			psmt = conn.prepareStatement(sql);

			for (OrderListVO vo : list) {
				psmt.setString(1, vo.getBookCode());
				psmt.setString(2, vo.getCode());
				psmt.setString(3, vo.getPrice());
				psmt.setString(4, vo.getQty());
				int r = psmt.executeUpdate();
				System.out.println(r + "입력");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

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

	// 오더코드>오더리스트 조회
	@Override
	public List<OrderVO> selectOrderListOne(OrderVO vo) {
		List<OrderVO> list = new ArrayList<OrderVO>();
		conn = DAO.getConnect();
		sql = "select * from orderlist\r\n" + "inner join ordercode\r\n" + "on orderlist.code = ordercode.code\r\n"
				+ "where orderlist.code= ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getCode());
			rs = psmt.executeQuery();

			while (rs.next()) {
				OrderVO rvo = new OrderVO();
				rvo.setCode(rs.getString("code"));
				rvo.setOrderCode(rs.getString("code"));
				rvo.setComents(rs.getString("coments"));
				rvo.setEmail(rs.getString("email"));
				rvo.setName(rs.getString("name"));
				rvo.setPhone(rs.getString("phone"));
				rvo.setBookCode(rs.getString("book_code"));
				rvo.setPrice(rs.getString("price"));
				rvo.setAdress(rs.getString("adress"));
				rvo.setQty(rs.getString("qty"));
				list.add(rvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 후기작성위해 북코드 확인
	public OrderVO selectBookCodeCheck(OrderVO rvo) {
		conn = DAO.getConnect();
		boolean chk = false;
		sql = "select * from orderlist o, ordercode c where c.code = o.code and c.code = ? and o.book_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, rvo.getCode());
			psmt.setString(2, rvo.getBookCode());
			rs = psmt.executeQuery();
			if (rs.next()) {
				rvo.setCode(rs.getString("code"));
				rvo.setOrderCode(rs.getString("code"));
				rvo.setComents(rs.getString("coments"));
				rvo.setEmail(rs.getString("email"));
				rvo.setName(rs.getString("name"));
				rvo.setPhone(rs.getString("phone"));
				rvo.setBookCode(rs.getString("book_code"));
				rvo.setPrice(rs.getString("price"));
				rvo.setAdress(rs.getString("adress"));
				rvo.setQty(rs.getString("qty"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rvo;
	}

	// 전체오더리스트
	public List<OrderVO> selectOrderListAll() {
		List<OrderVO> list = new ArrayList<>();
		conn = DAO.getConnect();
		sql = "select * from ordercode o, member m where o.name = m.name order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				OrderVO vo = new OrderVO();
				vo.setEmail(rs.getString("email"));
				vo.setName(rs.getString("name"));
				vo.setCode(rs.getString("code"));
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

}
