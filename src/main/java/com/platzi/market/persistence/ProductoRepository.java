package com.platzi.market.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.ProductMapper;

@Repository // Indica que esta clase es la que se encarga de interactuar con la base de datos
public class ProductoRepository implements ProductRepository {
	@Autowired
	private ProductoCrudRepository productoCrudRepository;
	
	@Autowired
	private ProductMapper mapper;
	
	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
		return mapper.toProducts(productos);
	}

	@Override
	public Optional<List<Product>> getByCategory(int categoryId) {
		// TODO Auto-generated method stub
		List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
		return Optional.of(mapper.toProducts(productos));
	}

	@Override
	public Optional<List<Product>> getScarseProduct(int quantity) {
		// TODO Auto-generated method stub
		Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
		return productos.map((prod) -> {
			return mapper.toProducts(prod);
		});
	}

	@Override
	public Optional<Product> getProduct(int productId) {
		// TODO Auto-generated method stub
		Optional<Producto> product = productoCrudRepository.findById(productId);
		return product.map(prod -> mapper.toProduct(prod));
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		Producto producto = mapper.toProducto(product);
		Producto productoNuevo = productoCrudRepository.save(producto);
		return mapper.toProduct(productoNuevo);
	}

	@Override
	public void delete(int productId) {
		// TODO Auto-generated method stub
		productoCrudRepository.deleteById(productId);
	}
	
}
