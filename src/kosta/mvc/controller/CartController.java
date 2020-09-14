package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;



import kosta.mvc.model.dto.Goods;
import kosta.mvc.model.service.GoodsService;
import kosta.mvc.session.Session;
import kosta.mvc.session.SessionSet;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;

public class CartController {
  private static GoodsService goodsService = new GoodsService();
  
   public static void putCart(String id, String goodsId, int quantity) {
		
		try {
			//상품번호에 해당 상품찾기
			Goods goods = goodsService.goodsSelectBygoodsId(goodsId)	;
			/*if(goods.getStock() < quantity) {
				throw new SQLException("재고량 부족으로 장바구니에 담을수 없습니다.");
			}*/
			//id에 해당하는 세션찾기
			SessionSet ss = SessionSet.getInstance();
			Session session = ss.get(id);			
			//세션에서 장바구니 찾기
			Map<Goods, Integer> cart =	(Map<Goods,Integer>)session.getAttribute("cart"); //상품 , 수량 저장 
			
			//장바구니가 없으면 장바구니 생성
			if(cart == null) { 
				cart = new HashMap<>(); 
				session.setAttribute("cart", cart);
			}
			
			//장바구니에서 상품찾기
			Integer oldQuantity = cart.get(goods);
			if(oldQuantity != null) { //장바구니에 이미 상품이 있다면
				quantity += oldQuantity; //수량을 누적
			}
			
			cart.put(goods, quantity); //장바구니에 상품 넣기
			EndView.printMessage("장바구니에 담았습니다");
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
   
   /**
    * 장바구니 보기
    * */
   public static void viewCart(String id) {
		SessionSet ss = SessionSet.getInstance();
		Session session = ss.get(id);
		Map<Goods,Integer> cart = (Map<Goods, Integer>) session.getAttribute("cart");
		if(cart == null ) { // 장바구니가 없는 고객
			FailView.errorMessage("장바구니가 비었습니다");
		}else {
			EndView.printViewCart(id , cart);
		}
	}
}




