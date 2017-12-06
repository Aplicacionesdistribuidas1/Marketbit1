package ec.ups.edu.appdis.marketbit1.controlador;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.ups.edu.appdis.marketbit1.datos.ProductoDAO;
import ec.ups.edu.appdis.marketbit1.modelo.Producto;

@ManagedBean
@ViewScoped
public class ProductoController {
	@Inject
	private ProductoDAO prodao;
	private Producto producto = null;
	private List<Producto> productos;
	
	private int id;
	
	@PostConstruct
	public void init() {
		producto =new Producto();
		loadProductos();
	}
	public void loadProductos() {
		productos = prodao.listadoProducto();
	}
	public String guardar() {
		prodao.guardar(producto);
		loadProductos();
		return "listadoProductos";
	}
	public String loadDatosEditar(int id) {
		System.out.println("cargando datos de productos a editar"+ id);
		producto= prodao.leer(id);
		return "FicheroProducto";
	}
	
	public String eliminarDatos(int id) {
		prodao.borrar(id);
		return "ListadoProductos";
	}
	public ProductoDAO getProdao() {
		return prodao;
	}
	public void setProdao(ProductoDAO prodao) {
		this.prodao = prodao;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		loadDatosEditar(id);
	}
	
}
