package project.internal.entity;

public class Item {

	private String itemId;
	private String itemName;
	private String itemCategory;
	private double itemRate;
	private String itemStatus;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Item(String itemId, String itemName, String itemCategory, double itemRate, String itemStatus) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemRate = itemRate;
		this.itemStatus = itemStatus;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public double getItemRate() {
		return itemRate;
	}
	public void setItemRate(double itemRate) {
		this.itemRate = itemRate;
	}
	public String getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemCategory=" + itemCategory + ", itemRate="
				+ itemRate + ", itemStatus=" + itemStatus + "]";
	}
	
	
}
