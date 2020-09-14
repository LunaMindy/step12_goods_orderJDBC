package kosta.mvc.controller;

import java.util.List;

import kosta.mvc.model.dto.Goods;
import kosta.mvc.model.service.GoodsService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;

public class GoodsController {
	static GoodsService goodsService = new GoodsService();
  /**
   * 전체 상품 조회
   * */
	public static void goodsSelect() {
		try {
			List<Goods> list = goodsService.goodsSelect();
			EndView.printGoodsList(list);
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 
	 * */
}
