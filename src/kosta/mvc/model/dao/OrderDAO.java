package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Orders;

public interface OrderDAO {
  /**
   * 주문하기
   *  1) orders테이블에 insert
   *  2) order_line테이블에 insert
   *  3) 재고량(stock)감소 시키기(update)
   * */
	int orderInsert(Orders order)throws SQLException;
	
	/**
	 * userId에 해당하는 주문 목록 
	 * */
	
	
	/**
	 * 주문내역보기
	 * */
	List<Orders> selectOrdersByUserId(String userId)throws SQLException;
}
