package kosta.mvc.view;


import java.util.Scanner;

import kosta.mvc.controller.CartController;
import kosta.mvc.controller.CustomerController;
import kosta.mvc.controller.GoodsController;
import kosta.mvc.controller.OrderController;
import kosta.mvc.model.dto.OrderLine;
import kosta.mvc.model.dto.Orders;
import kosta.mvc.session.Session;
import kosta.mvc.session.SessionSet;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);
	
	public static void menu() {
		while(true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet());
			
			MenuView.printMenu();
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1 :
				//MenuView.register(); // 가입
				break;
			case 2 :
				MenuView.login();// 로그인
				break;

			case 9 : 
				System.exit(0);
			}
		}

	}
	
	
	public static void printMenu() {
		System.out.println("=== Heejung Shopping Mall ===");
		System.out.println("1. 가입   |   2. 로그인   |  9. 종료");
	}
	
	
	public static void printUserMenu(String userId) {
		while(true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet());
			System.out.println("-----" +userId+ " 로그인 중 -----");
			System.out.println(" 1.로그아웃 |  2.상품보기  |  3.주문하기  | 4. 주문내역보기  |  5.장바구니담기  |  6.장바구니보기 ");
			int menu =Integer.parseInt( sc.nextLine());
			switch(menu) {
				case 1 :
					logout(userId);// 
					return;
					//break;
					
				case 2 :
					GoodsController.goodsSelect();//전체 상품조회
					break;
				case 3 :
					printInputOrder(userId);
					break;
				case 4 :
					OrderController.selectOrdersByUserId(userId);
					break;
				case 5 :
					MenuView.putCart(userId);// 
					break;	
		
				case 6 : 
					viewCart(userId);
					break;
				}
		}
		
	}
	
	public static void printSubMenu() {
		System.out.println("1. 수정   |  2.탈퇴   | 9. 나가기");
	}
	
	public static void printAdminMenu() {
		System.out.println("-- 관리자 메뉴 --");
		System.out.println("1. ID로 검색   |  2.이름으로 검색  | 3.전체 검색  |  9. 나가기");
		
	}
	
	/**
	 * 로그인 메뉴
	 * */
	public static void login() {
		 System.out.print("아이디 : ");
		 String userId = sc.nextLine();
		 
		 System.out.print("비번 : ");
		 String userPwd = sc.nextLine();
		 
		 CustomerController.login(userId, userPwd); 
	}
	
	/**
	 * 로그아웃
	 * */
	public static void logout(String userId) {
		SessionSet ss = SessionSet.getInstance();
		Session session = new Session(userId);
		ss.remove(session);	
	}
	
	/**
	 * 주문하기
	 * */
    public static void printInputOrder(String userId) {
    	System.out.print("주문상품번호 : ");
		 String goodsId = sc.nextLine();
		 
		 System.out.print("주문수량 : ");
		 int qty = Integer.parseInt(sc.nextLine());
		 
		 System.out.print("배송주소 : ");
		 String address = sc.nextLine();
		 
		 /*SessionSet sessionSet = SessionSet.getInstance();
		 String userid=null;
		 for(Session session : sessionSet.getSet()) {
			 userid =  session.getSessionId();
		 }*/
			 
		 Orders orders = new Orders(0, null, userId, address, 0);
		 OrderLine orderLine = new OrderLine(0, 0, goodsId, 0, qty, 0);
		 orders.getOrderLineList().add(orderLine);
		 
		 OrderController.insertOrders(orders);	 
    }
    
    /**
     * 장바구니 담기
     * */
    public static void putCart(String id) {
		System.out.println("--장바구니 담기 작업 --");
		System.out.print("상품번호 : ");
		String goodsId = sc.nextLine();
		System.out.print("수량 : ");
		int qty = Integer.parseInt(sc.nextLine());
		
		CartController.putCart(id,goodsId,qty);
	
		
	}
	
    /**
     * 장바구니 보기
     * */
	public static void viewCart(String id) {
		CartController.viewCart(id);
		
		
		
	}
}



