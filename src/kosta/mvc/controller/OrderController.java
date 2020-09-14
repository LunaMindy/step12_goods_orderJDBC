package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Customer;
import kosta.mvc.model.dto.Orders;
import kosta.mvc.model.service.OrderService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;
import kosta.mvc.view.MenuView;

public class OrderController {
    private static OrderService orderService = new OrderService();
	/**
	 * 주문하기
	 * */
	public static void insertOrders(Orders order) {
		try {
		  orderService.insertOrders(order);
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
	 * 주문내역보기
	 * */
	public static void selectOrdersByUserId(String userId) {
		try {
			 List<Orders> orderList = orderService.selectOrdersByUserId(userId);
             EndView.printOrderByUserId(orderList);
		}catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
}




