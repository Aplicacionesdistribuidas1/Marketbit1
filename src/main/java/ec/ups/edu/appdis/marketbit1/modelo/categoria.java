package ec.ups.edu.appdis.marketbit1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class categoria {
	
	@Id
	@Column(name="cat_codigo",length=30)
	private int codigo;
	@NotNull
	@Column(name="cat_nom",length=30)
	private String nombre;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="id", referencedColumnName="cat_codigo")
	private List<producto> productos;
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
	public List<producto> getProductos() {
		return productos;
	}
	public void setProductos(List<producto> productos) {
		this.productos = productos;
	}
	
	public void addProducto(producto producto) {
		if(productos==null)
			productos=new ArrayList<>();
			productos.add(producto);
	}
	@Override
	public String toString() {
		return "categoria [codigo=" + codigo + ", nombre=" + nombre + ", productos=" + productos + "]";
	}
	
	
	

}
