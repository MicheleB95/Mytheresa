package com.mytheresa.Mytheresa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private String sku;
	private String name;
	private String category;
	private int originalPrice;
	private int finalPrice;
	private String discountPercentage;
	private final String currency;

	public Product() {
		currency = "EUR";
	}
	public Product(final String pSku, final String pName, final String pCategory, final int pOriginalPrice, final String pDiscountPercentage) {
		setSku(pSku);
		setName(pName);
		category = pCategory;
		setOriginalPrice(pOriginalPrice);
		setDiscountPercentage(pDiscountPercentage);
		currency = "EUR";
	}

	public int getIntDiscount() {
		int tmpDiscount = 0;
		if (discountPercentage != null && !discountPercentage.isBlank())
			tmpDiscount = Integer.parseInt(discountPercentage.replace("%", ""));

		return tmpDiscount;
	}

	private void updateFinalPrice() {
		final int tmpDiscount = getIntDiscount();
		if (tmpDiscount < 100)
			finalPrice = originalPrice * (100 - tmpDiscount) / 100;
		else
			finalPrice = originalPrice;
	}

	public String getSku() {
		return sku;
	}


	public void setSku(final String pSku) {
		sku = pSku;
	}


	public String getName() {
		return name;
	}


	public void setName(final String pName) {
		name = pName;
	}

	public void setCategory(final String pCategory) {
		category = pCategory;
	}

	public String getCategory() {
		return category;
	}


	public int getOriginalPrice() {
		return originalPrice;
	}


	public void setOriginalPrice(final int pOriginalPrice) {
		originalPrice = pOriginalPrice;
		updateFinalPrice();
	}

	public int getFinalPrice() {
		return finalPrice;
	}


	public String getDiscountPercentage() {
		return discountPercentage;
	}


	public void setDiscountPercentage(final String pDiscountPercentage) {
		discountPercentage = pDiscountPercentage;
		updateFinalPrice();
	}

	public String getCurrency() {
		return currency;
	}

}
