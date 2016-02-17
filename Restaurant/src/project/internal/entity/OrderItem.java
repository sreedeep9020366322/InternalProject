package project.internal.entity;

import project.internal.daos.OrderItemsDAO;

public class OrderItem {

	private String orderId;
	private String itemId;
	private long quantity;
	private String orderComment;
	private String orderStatus;
	private double amount;
	
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderItem(String orderId, String itemId, long quantity, String orderComment, String orderStatus) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.orderComment = orderComment;
		this.orderStatus = orderStatus;
		
		OrderItemsDAO dao = new OrderItemsDAO();
		this.amount = (dao.findAmount(itemId) * this.quantity );
		
		//this.amount = amount;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getOrderComment() {
		return orderComment;
	}
	public void setOrderComment(String orderComment) {
		this.orderComment = orderComment;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "OrderItem [orderId=" + orderId + ", itemId=" + itemId + ", quantity=" + quantity + ", orderComment="
				+ orderComment + ", orderStatus=" + orderStatus + ", amount=" + amount + "]";
	}

	
	
	
}
