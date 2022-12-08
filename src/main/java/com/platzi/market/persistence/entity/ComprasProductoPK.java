package com.platzi.market.persistence.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

//@Embeddable // clase de Claves primarias compuestas para embeber dentro de nuestra clase ComprasProducto
public class ComprasProductoPK implements Serializable {
//	private static final long serialVersionUID = 1L;

	private static final long serialVersionUID = 1L;

//	@Column(name = "id_compra")
	private Integer idCompra;

//	@Column(name = "id_producto")
	private Integer idProducto;
	
	// Default Constructor
	public ComprasProductoPK() {
		super();
	}
	
	public ComprasProductoPK(Integer idCompra, Integer idProducto) {
		super();
		this.idCompra = idCompra;
		this.idProducto = idProducto;
	}

	// HASHCODE METHOD
	@Override
	public int hashCode() {
		return Objects.hash(idCompra, idProducto);
	}

//	Getters and Setters
	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	// EQUALS METHOD
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComprasProductoPK other = (ComprasProductoPK) obj;
		return Objects.equals(idCompra, other.idCompra) && Objects.equals(idProducto, other.idProducto);
	}
	
}
