package project.internal.entity;

public class Bill {

	private String billId;
	private String orderId;
	private double billAmount;

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(String billId, String orderId, double billAmount) {
		super();
		this.billId = billId;
		this.orderId = orderId;
		this.billAmount = billAmount;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", orderId=" + orderId + ", billAmount=" + billAmount + "]";
	}

}
