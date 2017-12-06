package ec.ups.edu.appdis.marketbit1.controlador;
import ec.ups.edu.appdis.marketbit1.modelo.Categoria;
import ec.ups.edu.appdis.marketbit1.modelo.Producto;
import ec.ups.edu.appdis.marketbit1.datos.CategoriaDAO;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;



@ManagedBean
@ViewScoped
public class CategoriaController {
	
	@Inject
	private CategoriaDAO cadao;
	private Categoria categoria= null;
	private List<Categoria> categorias;
	
	private int id;
	
	@PostConstruct
	public void init() {
		categoria = new Categoria();
		loadCategoria();
	}

	public CategoriaDAO getCadao() {
		return cadao;
	}

	public void setCadao(CategoriaDAO cadao) {
		this.cadao = cadao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
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
		return "ListadoCategoria";
	}

	public String loadDatosEditar(int id) {
		System.out.println("cargando datos de categoria a editar"+ id);
		categoria= cadao.leer(id);
		return "crearCategoria";
	}
	public String eliminarDatos(int id) {
		cadao.borrar(id);
		return "ListadoCategoria";
	}
	
}
