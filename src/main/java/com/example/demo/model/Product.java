package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "barcode")
	private String barcode;

	@Column(name = "item")
	private String item;

	@Column(name = "category")
	private String category;
	
	@Column(name = "price")
	private long price;
	
	@Column(name = "discount")
	private long discount;
	
	@Column(name = "available")
	private long available;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getDiscount() {
		return discount;
	}

	public void setDiscount(long discount) {
		this.discount = discount;
	}

	public long getAvailable() {
		return available;
	}

	public void setAvailable(long available) {
		this.available = available;
	}

	public Product() {

	}

	public Product(String barcode, String item, String category, long price, long discount, long available) {
		this.barcode = barcode;
		this.item = item;
		this.category = category;
		this.price = price;
		this.discount = discount;
		this.available = available;
	}

}
