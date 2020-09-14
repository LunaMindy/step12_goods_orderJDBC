package kosta.mvc.model.dto;



public class Goods {
  private String goodsId;
  private String goodsName;
  private int goodsPrice;
  private int stock;
  private String regDate;
  
    public Goods() {}
    
  
	public Goods(String goodsId, String goodsName, int goodsPrice, int stock, String regDate) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.stock = stock;
		this.regDate = regDate;
	}


	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getRegDate() {
		return regDate.substring(0, 12);
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
  
	 @Override
		public String toString() {
			return goodsId +" | " + goodsName +" | " + goodsPrice +" | " + stock +" | " + regDate ;
		}
	 
	 /**
		 *  객체가 다르더라도 상품번호가 같으면 무조건 같다라고 이해하기 위해 오버라이드
		 */
//		@Override
//		public int hashCode() {
//			final int prime = 31;
//			int result = 1;
//			result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
//			return result;
//		}
//
//		@Override
//		public boolean equals(Object obj) {
//			if (this == obj)
//				return true;
//			if (obj == null)
//				return false;
//			if (getClass() != obj.getClass())
//				return false;
//			
//			Goods other = (Goods) obj;
//			if (goodsId == null) {
//				if (other.goodsId != null)
//					return false;
//			} else if (!goodsId.equals(other.goodsId))
//				return false;
//			return true;
//		}
	 
	    @Override
		public int hashCode() {
			return goodsId.hashCode();
		}
	 
	 @Override
		public boolean equals(Object obj) {
//		    if (this == obj)
//				return true;
//			if (obj == null)
//				return false;
//			if (getClass() != obj.getClass())
//				return false;
			
			Goods other = (Goods) obj;
			if(goodsId.equals(other.goodsId)) {
				return true;
			}else {
				return false;
			}
			
		}
  
}
