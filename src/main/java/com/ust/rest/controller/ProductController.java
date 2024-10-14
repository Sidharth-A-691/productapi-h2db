package com.ust.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.rest.model.Product;
import com.ust.rest.service.ProductService;


@RestController
@RequestMapping("/product/api1.0") //root of resource
public class ProductController {
	
	Logger logger = Logger.getLogger("ProductController.class");
	@Autowired
	private ProductService service;
	
	@GetMapping(value = "/productsinfo",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> displayProducts(){
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(service.getAllProducts());
	}
		
	@GetMapping(value="/product/{detail}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getByBrand(@PathVariable String detail){
//		Optional<Product> optional = productList.stream().filter(product->product.getBrand().equalsIgnoreCase(detail)||(product.getProductId()+"").equalsIgnoreCase(detail)).findFirst();
//		return ResponseEntity.status(HttpStatus.OK).body(optional.get());
		return null;
	}
	
	@PostMapping(value="/addProduct",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		logger.info("Entered POST method" + product);
		Product savedProduct = service.addProduct(product);
		logger.info("Persisted product" + savedProduct);
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(savedProduct);
	}
	
	@PutMapping(value="/modify")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
//		for(int i=0;i<productList.size();i++) {
//			if(productList.get(i).getProductId()==product.getProductId()) {
//				productList.set(i, product);
//				return ResponseEntity.accepted().body(null);
//			}
//		}
//		return ResponseEntity.notFound().build();
		return null;
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable long id){
//		for(int i=0;i<productList.size();i++) {
//			if(productList.get(i).getProductId()==id) {
//				productList.remove(i);
//				return ResponseEntity.ok().body(null);
//			}
//		}
//		return ResponseEntity.notFound().build();
		return null;
	}

}
