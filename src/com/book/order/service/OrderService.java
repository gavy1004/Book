package com.book.order.service;

import java.util.List;

import com.book.order.vo.OrderVO;

public interface OrderService {
	List<OrderVO> selectOrderListAll();
	List<OrderVO> selectOrderListOne(OrderVO vo);
	List<OrderVO> selectOrderList(String id);
	OrderVO selectOrder(OrderVO vo);
	public int insertOrder(OrderVO vo);
	public int updateOrder(OrderVO vo);
	public int deleteOrder(OrderVO vo);
}
