package com.platzi.market.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.platzi.market.domain.Product;

@Repository
public interface ProductRepository {
	public List<Product> getAll();
	public Optional<List<Product>> getByCategory(int categoryId);
	public Optional<List<Product>> getScarseProduct(int quantity);
	public Optional<Product> getProduct(int productId);
	public Product save(Product product);
	public void delete(int productId);
}
