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
	
	

}
