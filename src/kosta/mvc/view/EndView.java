package kosta.mvc.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kosta.mvc.controller.OrderController;
import kosta.mvc.model.dto.Goods;
import kosta.mvc.model.dto.OrderLine;
import kosta.mvc.model.dto.Orders;
import kosta.mvc.session.Session;
import kosta.mvc.session.SessionSet;

public class EndView {
  /**
   * 상품 전체 출력
   * */
	public static void printGoodsList(List<Goods> list) {
		System.out.println("-----상품 "+ list.size() +"개 -------------");
		for(Goods goods : list) {
			System.out.println(goods);
		}
		
		System.out.println();
	}
	
	public static void printMessage(String message) {
		System.out.println(message);
	}
	
	/**
	 * 장바구니 보기
	 * */
	public static void printViewCart(String id , Map<Goods,Integer> cart) {
		System.out.println("장바구니내용....");
		
		for(Goods goods: cart.keySet()) {
			String goodsId = goods.getGoodsId();//상품번호
			String name = goods.getGoodsName();//상품이름
			int price = goods.getGoodsPrice();//상품가격
			int quantity = cart.get(goods);//
			System.out.println(goodsId+" : "+name+" : "+price+" \t "+quantity);
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1.주문하기  |  9.나가기");
		switch(Integer.parseInt(sc.nextLine())) {
		case 1:
			
			 System.out.print("배송주소 : ");
			 String address = sc.nextLine();
			
			 Orders orders = new Orders(0, null, id, address, 0);
			 List<OrderLine> orderLineList = orders.getOrderLineList();
			 for(Goods goodsKey : cart.keySet()) {
				 int qty = cart.get(goodsKey);
				 OrderLine orderLine = new OrderLine(0, 0, goodsKey.getGoodsId() , 0, qty, 0);
				 orderLineList.add(orderLine);
			 }
			 System.out.println("orderLineList 개수 : " + orderLineList.size());
			 OrderController.insertOrders(orders);
			 
			 //장바구니비우기
			 SessionSet ss = SessionSet.getInstance();
			 Session session = ss.get(id);
			 session.removeAttribute("cart");
			break;
			
		case 9:
			break;
		}
		
		//System.out.println(id);
	
	}
 
	/**
	 * 주문 상세보기
	 * */
	public static void printOrderByUserId(List<Orders> orderList) {
	   for(Orders order : orderList) {
		   System.out.println(order.getOrderId()+ " | " + order.getOrderDate() +" | " + order.getTotalAmount());
		   for(OrderLine orderLine : order.getOrderLineList()) {
			   System.out.println("  ▶ "+orderLine);
		   }
		   System.out.println();
	   }
		
	}
}












