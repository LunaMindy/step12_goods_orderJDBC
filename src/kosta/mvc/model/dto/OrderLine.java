package kosta.mvc.model.dto;

public class OrderLine {
  private int orderLineId;
  private int orderId;
  private String goodsId;
  private int unitPrice;
  private int qty;
  private int amount;
  
  public OrderLine() {}
	public OrderLine(int orderLineId, int orderId, String goodsId, int unitPrice, int qty, int amount) {
		super();
		this.orderLineId = orderLineId;
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.unitPrice = unitPrice;
		this.qty = qty;
		this.amount = amount;
	}
	public int getOrderLineId() {
		return orderLineId;
	}
	public void setOrderLineId(int orderLineId) {
		this.orderLineId = orderLineId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "OrderLine [orderLineId=" + orderLineId + ", orderId=" + orderId + ", goodsId=" + goodsId
				+ ", unitPrice=" + unitPrice + ", qty=" + qty + ", amount=" + amount + "]";
	}
	
	
  
  
}


