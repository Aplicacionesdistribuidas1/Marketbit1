package ec.ups.edu.appdis.marketbit1.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class FacturaDetalle {
	
	@Id
	@Column(name="fd_codigo")
	private int codigo;
	
	@NotNull
	@Column(name="fd_cantidad")
	private int cantidad;
	
	@NotNull
	@Column(name="fd_subtotal")
	private double subtotal;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="id_detalle", referencedColumnName="fd_codigo")
	private Set<Producto> productos= new HashSet<>();
	
	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	public void addProductos(Producto producto) {
		if(productos==null)
			productos=new HashSet<>();
		productos.add(producto);
	}

	@Override
	public String toString() {
		return "FacturaD [codigo=" + codigo + ", cantidad=" + cantidad + ", subtotal=" + subtotal + ", productos="
				+ productos + "]";
	}
	
}
