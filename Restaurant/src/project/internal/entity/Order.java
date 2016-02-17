package project.internal.entity;

public class Order {

	private String orderId;
	private String tableNo;
	private long noOfItems;
	private String orderStatus;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String orderId, String tableNo, long noOfItems, String orderStatus) {
		super();
		this.orderId = orderId;
		this.tableNo = tableNo;
		this.noOfItems = noOfItems;
		this.orderStatus = orderStatus;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getTableNo() {
		return tableNo;
	}
	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
	}
	public long getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(long noOfItems) {
		this.noOfItems = noOfItems;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", tableNo=" + tableNo + ", noOfItems=" + noOfItems + ", orderStatus="
				+ orderStatus + "]";
	}
	
	
	
	
}
