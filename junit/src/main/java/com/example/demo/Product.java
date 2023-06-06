package com.example.demo;

public class Product {

	int price;
	int saleRate;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSaleRate() {
		return saleRate;
	}

	public void setSaleRate(int saleRate) {
		this.saleRate = saleRate;
	}

	@Override
	public String toString() {
		return "Product [price=" + price + ", saleRate=" + saleRate + "]";
	}

}
