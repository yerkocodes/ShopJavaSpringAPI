package com.platzi.market.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.platzi.market.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

//	@Query(value = "SELECT * FROM productos WHERE id_categoria = ?" , nativeQuery = true)
	public List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria); 
	
	public Optional<List<Producto>> findByCantidadStockLessThanAndEstado(Integer cantidadStock, boolean estado);
	
}
