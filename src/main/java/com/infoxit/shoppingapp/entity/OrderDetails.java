package com.infoxit.shoppingapp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer orderBy;
	
	private Integer itemId;
	
	private String itemName;
	
	private String deliveryAddress;
	
	private Date orderDate;

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetails(Integer id, Integer orderBy, Integer itemId, String itemName, String deliveryAddress,
			Date orderDate) {
		super();
		this.id = id;
		this.orderBy = orderBy;
		this.itemId = itemId;
		this.itemName = itemName;
		this.deliveryAddress = deliveryAddress;
		this.orderDate = orderDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", orderBy=" + orderBy + ", itemId=" + itemId + ", itemName=" + itemName
				+ ", deliveryAddress=" + deliveryAddress + ", orderDate=" + orderDate + "]";
	}
	
	
	
	
}
