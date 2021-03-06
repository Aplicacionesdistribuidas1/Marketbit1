package ec.ups.edu.appdis.marketbit1.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

@Entity
public class Producto {
	
	@Id
	@Column(name="pro_codigo")
	private int codigo;
	
	@NotNull
	@Column(name="pro_nombre", length=50)
	private String nombre;
	
	@NotNull
	@Column(name="pro_precio", length=10)
	private double precio;
	
	@NotNull
	@Column(name="pro_descripcion", length=10)
	private String descripcion;
	
	@NotNull
	@Column(name="pro_stock", length=10)
	private int stock;
	
	@Column(name="pro_imagen")
	private String imagen;
	
	@OneToOne(cascade= CascadeType.ALL, fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn  
	private Categoria categoria;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", descripcion="
				+ descripcion + ", stock=" + stock + ", imagen=" + imagen + ", categoria=" + categoria + "]";
	}
	
	
	

}
