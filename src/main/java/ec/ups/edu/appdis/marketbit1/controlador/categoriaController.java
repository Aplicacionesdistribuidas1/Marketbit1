package ec.ups.edu.appdis.marketbit1.controlador;
import ec.ups.edu.appdis.marketbit1.modelo.categoria;
import ec.ups.edu.appdis.marketbit1.datos.categoriaDAO;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;



@ManagedBean
public class categoriaController {
	@Inject
	private categoriaDAO cadao;
	private categoria categoria= null;
	private List<categoria> categorias;
	
	private int id;
	
	@PostConstruct
	public void init() {
		categoria = new categoria();
		loadCategoria();
	}

	public categoriaDAO getCadao() {
		return cadao;
	}

	public void setCadao(categoriaDAO cadao) {
		this.cadao = cadao;
	}

	public categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(categoria categoria) {
		this.categoria = categoria;
	}

	public List<categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<categoria> categorias) {
		this.categorias = categorias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		loadDatosEditar(id);
	}
	public void loadCategoria() {
		categorias = cadao.listadoCategoria();
	}
	
	public String guardar() {
		cadao.guardar(categoria);
		loadCategoria();
		return "listadoCategorias";
	}
	public String loadDatosEditar(int id) {
		System.out.println("cargando datos de categoria a editar"+ id);
		categoria= cadao.leer(id);
		return "FicheroCategoria";
	}
	public String eliminarDatos(int id) {
		cadao.borrar(id);
		return "listadoCategorias";
	}
}
