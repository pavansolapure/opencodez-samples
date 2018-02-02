package com.opencodez.patterns.command.receiver;

//Receiver
public class Order {
	
	private String foodItem;
	private Integer foodQuantity;
	
	private boolean orderPlaced;
	private boolean orderValidated;
	private boolean orderPrepared;
	private boolean orderServed;
	
	public Order(String foodItem, Integer foodQuantity) {
		this.foodItem = foodItem;
		this.foodQuantity = foodQuantity;
	}

	/**
	 * @return the foodItem
	 */
	public String getFoodItem() {
		return foodItem;
	}

	/**
	 * @param foodItem
	 *            the foodItem to set
	 */
	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}

	/**
	 * @return the foodQuantity
	 */
	public Integer getFoodQuantity() {
		return foodQuantity;
	}

	/**
	 * @param foodQuantity
	 *            the foodQuantity to set
	 */
	public void setFoodQuantity(Integer foodQuantity) {
		this.foodQuantity = foodQuantity;
	}
	
	/**
	 * @return the orderPlaced
	 */
	public boolean isOrderPlaced() {
		return orderPlaced;
	}

	/**
	 * @param orderPlaced the orderPlaced to set
	 */
	public void setOrderPlaced(boolean orderPlaced) {
		this.orderPlaced = orderPlaced;
	}

	/**
	 * @return the orderValidated
	 */
	public boolean isOrderValidated() {
		return orderValidated;
	}

	/**
	 * @param orderValidated the orderValidated to set
	 */
	public void setOrderValidated(boolean orderValidated) {
		this.orderValidated = orderValidated;
	}

	/**
	 * @return the orderPrepared
	 */
	public boolean isOrderPrepared() {
		return orderPrepared;
	}

	/**
	 * @param orderPrepared the orderPrepared to set
	 */
	public void setOrderPrepared(boolean orderPrepared) {
		this.orderPrepared = orderPrepared;
	}

	/**
	 * @return the orderServed
	 */
	public boolean isOrderServed() {
		return orderServed;
	}

	/**
	 * @param orderServed the orderServed to set
	 */
	public void setOrderServed(boolean orderServed) {
		this.orderServed = orderServed;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Order [ ")
		  .append(foodItem).append(", ").append(foodQuantity).append("\r\n")
		  .append("Placed : ").append(orderPlaced).append("\r\n")
		  .append("Validated : ").append(orderValidated).append("\r\n")
		  .append("Prepared : ").append(orderPrepared).append("\r\n")
		  .append("Served : ").append(orderServed).append("\r\n")
		  .append("] \r\n");
		
		return sb.toString();
	}
	
	
}
