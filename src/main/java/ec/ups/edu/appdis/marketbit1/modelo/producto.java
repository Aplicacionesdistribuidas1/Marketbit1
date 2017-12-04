package ec.ups.edu.appdis.marketbit1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class producto {
	@Id
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
	
	
	

}
