package ec.ups.edu.appdis.marketbit1.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.ups.edu.appdis.marketbit1.datos.productoDAO;
import ec.ups.edu.appdis.marketbit1.modelo.producto;

@ManagedBean
public class productoController {
	@Inject
	private productoDAO prodao;
	private producto producto = null;
	private List<producto> productos;
	
	private int id;
	
	@PostConstruct
	public void init() {
		producto =new producto();
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
		return "listadoProductos";
	}
	public productoDAO getProdao() {
		return prodao;
	}
	public void setProdao(productoDAO prodao) {
		this.prodao = prodao;
	}
	public producto getProducto() {
		return producto;
	}
	public void setProducto(producto producto) {
		this.producto = producto;
	}
	public List<producto> getProductos() {
		return productos;
	}
	public void setProductos(List<producto> productos) {
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
