package com.mytheresa.Mytheresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepository myProductRepository;

	public List<Product> getAllProducts(final String pCategory, final int pPriceLessThan) {
		final Pageable myPageable = PageRequest.of(0, 5);
		final List<Product> myProducts = myProductRepository.findProducts(pCategory, pPriceLessThan,myPageable);

		final int tmpBootsDiscount = 30;
		final int tmpSkuDiscount = 15;
		myProducts.stream()
		.filter(p -> p.getCategory().equals("boots") && p.getIntDiscount() < tmpBootsDiscount)
		.forEach(p -> p.setDiscountPercentage(tmpBootsDiscount+"%"));

		myProducts.stream()
		.filter(p -> p.getSku().equals("000003") && p.getIntDiscount() < tmpSkuDiscount)
		.forEach(p -> p.setDiscountPercentage(tmpSkuDiscount+"%"));


		return myProducts;
	}

	public Product addProduct(final Product pProduct) {
		return myProductRepository.save(pProduct);
	}

}
