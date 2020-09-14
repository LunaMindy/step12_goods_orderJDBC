package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dao.GoodsDAO;
import kosta.mvc.model.dao.GoodsDAOImpl;
import kosta.mvc.model.dto.Goods;

public class GoodsService {
	GoodsDAO goodsDao = new GoodsDAOImpl();
    /**
     * 전체 상품조회
     * */
	public List<Goods> goodsSelect() throws NotFoundException , SQLException{
		List<Goods> list=goodsDao.goodsSelect();
		if(list.size()==0)throw new NotFoundException("현재 상품이 없습니다.");
		return list;
	}
	
	/**
	 * 상품번호에 해당하는 상품검색
	 * */
	public Goods goodsSelectBygoodsId(String goodsId) throws  SQLException{
		Goods goods=goodsDao.goodsSelectBygoodsId(goodsId);
		if(goods==null)throw new SQLException(goodsId + " 현재 상품이 없습니다.");
		return goods;
	}
}
