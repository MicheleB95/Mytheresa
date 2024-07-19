package com.mytheresa.Mytheresa;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class MytheresaApplicationTests {

	@Autowired
	private ProductService myProductService;

	@Test
	@Transactional
	public void testGetBootsHigherDiscountProducts() {
		final Product myProduct = new Product("000001", "BV Lean leather ankle boots", "boots", 89000, "10%");
		myProductService.addProduct(myProduct);
		final Product myFetchedProduct = myProductService.getAllProducts(null,-1).get(0);
		assertTrue(myFetchedProduct.getDiscountPercentage().equals("30%"));
	}

	@Test
	@Transactional
	public void testGetBootsLowerDiscountProducts() {
		final Product myProduct = new Product("000001", "BV Lean leather ankle boots", "boots", 89000, "60%");
		myProductService.addProduct(myProduct);
		final Product myFetchedProduct = myProductService.getAllProducts(null,-1).get(0);
		assertTrue(myFetchedProduct.getDiscountPercentage().equals("60%"));
	}


	@Test
	@Transactional
	public void testGetSkuHigherDiscountProducts() {
		final Product myProduct = new Product("000003", "Boots", "shoes", 89000, "10%");
		myProductService.addProduct(myProduct);
		final Product myFetchedProduct = myProductService.getAllProducts(null,-1).get(0);
		assertTrue(myFetchedProduct.getDiscountPercentage().equals("15%"));
	}

	@Test
	@Transactional
	public void testGetSkuLowerDiscountProducts() {
		final Product myProduct = new Product("000003", "Boots", "shoes", 89000, "60%");
		myProductService.addProduct(myProduct);
		final Product myFetchedProduct = myProductService.getAllProducts(null,-1).get(0);
		assertTrue(myFetchedProduct.getDiscountPercentage().equals("60%"));
	}

	@Test
	@Transactional
	public void testGetSkuBootsHigherDiscountProducts() {
		final Product myProduct = new Product("000003", "Boots", "boots", 89000, "60%");
		myProductService.addProduct(myProduct);
		final Product myFetchedProduct = myProductService.getAllProducts(null,-1).get(0);
		assertTrue(myFetchedProduct.getDiscountPercentage().equals("60%"));
	}

	@Test
	@Transactional
	public void testGetSkuBootsLowerDiscountProducts() {
		final Product myProduct = new Product("000003", "Boots", "boots", 89000, "10%");
		myProductService.addProduct(myProduct);
		final Product myFetchedProduct = myProductService.getAllProducts(null,-1).get(0);
		assertTrue(myFetchedProduct.getDiscountPercentage().equals("30%"));
	}

	@Test
	@Transactional
	public void testNumberOfReturnedProducts() {
		final Product myProduct1 = new Product("000001", "Boots", "boots", 89000, "10%");
		myProductService.addProduct(myProduct1);
		final Product myProduct2 = new Product("000002", "Boots", "boots", 89000, "10%");
		myProductService.addProduct(myProduct2);
		final Product myProduct3 = new Product("000003", "Boots", "boots", 89000, "10%");
		myProductService.addProduct(myProduct3);
		final Product myProduct4 = new Product("000004", "Boots", "boots", 89000, "10%");
		myProductService.addProduct(myProduct4);
		final Product myProduct5 = new Product("000005", "Boots", "boots", 89000, "10%");
		myProductService.addProduct(myProduct5);
		final Product myProduct6 = new Product("000006", "Boots", "boots", 89000, "10%");
		myProductService.addProduct(myProduct6);
		final List<Product> myFetchedProducts = myProductService.getAllProducts(null,-1);
		assertTrue(myFetchedProducts.size() == 5);
	}


	@Test
	@Transactional
	public void testNumberOfReturnedCategoryProducts() {
		final Product myProduct1 = new Product("000001", "Boots", "boots", 800, "10%");
		myProductService.addProduct(myProduct1);
		final Product myProduct2 = new Product("000002", "Boots", "shoes", 89000, "10%");
		myProductService.addProduct(myProduct2);
		final Product myProduct3 = new Product("000003", "Boots", "boots", 700, "10%");
		myProductService.addProduct(myProduct3);
		final Product myProduct4 = new Product("000004", "Boots", "shoes", 1001, "80%");
		myProductService.addProduct(myProduct4);
		final Product myProduct5 = new Product("000005", "Boots", "boots", 89000, "10%");
		myProductService.addProduct(myProduct5);
		final Product myProduct6 = new Product("000006", "Boots", "boots", 89000, "10%");
		myProductService.addProduct(myProduct6);
		List<Product> myFetchedProducts = myProductService.getAllProducts("shoes",-1);
		assertTrue(myFetchedProducts.size() == 2);
		myFetchedProducts = myProductService.getAllProducts("boots",-1);
		assertTrue(myFetchedProducts.size() == 4);
		myFetchedProducts = myProductService.getAllProducts("boots",1000);
		assertTrue(myFetchedProducts.size() == 2);
		myFetchedProducts = myProductService.getAllProducts("shoes",1000);
		assertTrue(myFetchedProducts.size() == 0);
	}


}
