package com.mytheresa.Mytheresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getAllProducts(@RequestParam(value = "category", required = false) final String pCategory, @RequestParam(value = "priceLessThan", required = false, defaultValue = "-1") final int pPriceLessThan) {
		return productService.getAllProducts(pCategory, pPriceLessThan);
	}

	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody final Product pProduct) {
		final Product myProduct = productService.addProduct(pProduct);
		return ResponseEntity.status(HttpStatus.CREATED).body(myProduct);
	}

}
