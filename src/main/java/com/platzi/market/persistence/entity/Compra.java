package com.platzi.market.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "compras")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compra")
	private Integer idCompra;
	
	@Column(name = "id_cliente")
	private String idCliente;
	
	private LocalDateTime fecha;
	
	@Column(name = "medio_pago")
	private String medioPago;
	
	private String comentario;
	
	private String estado;
	
	// JPA relationship ------------------------------------------------------------
	// Muchas compras se pueden realizar por un solo cliente 
	@ManyToOne
	@JoinColumn(name = "id_cliente", insertable = false, updatable = false) // "id_cliente" >>> nombre de la columna identificadora de la entidad Cliente
	private Cliente cliente;
	
	@OneToMany(mappedBy = "idProducto") //producto
	private List<ComprasProducto> productos;
	// -----------------------------------------------------------------------------

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ComprasProducto> getProductos() {
		return productos;
	}

	public void setProductos(List<ComprasProducto> productos) {
		this.productos = productos;
	}

//	Getters and Setters

	

}
