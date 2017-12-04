package ec.ups.edu.appdis.marketbit1.controlador;
import ec.ups.edu.appdis.marketbit1.datos.entregaDAO;
import ec.ups.edu.appdis.marketbit1.modelo.entrega;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

@ManagedBean
public class entregaController {

	@Inject
	private entregaDAO entdao;
	private entrega entrega= null;
	private List<entrega> entregas;
	
	private int id;
	
	@PostConstruct
	public void init() {
		entrega =new entrega();
		loadEntrega();
	}

	public entregaDAO getEntdao() {
		return entdao;
	}

	public void setEntdao(entregaDAO entdao) {
		this.entdao = entdao;
	}

	public entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(entrega entrega) {
		this.entrega = entrega;
	}

	public List<entrega> getEntregas() {
		return entregas;
	}

	public void setEntregas(List<entrega> entregas) {
		this.entregas = entregas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		loadDatosEditar(id);
	}
	
	public void loadEntrega() {
		entregas=entdao.listadoEntrega();
	}
	
	public String guardar() {
		entdao.guardar(entrega);
		loadEntrega();
		return "listadoEntrega";
	}
	
	public String loadDatosEditar(int id) {
		System.out.println("cargando datos de Entrega a editar"+ id);
		entrega= entdao.leer(id);
		return "crearEntrega";
	}
	public String eliminarDatos(int id) {
		entdao.borrar(id);
		return "listadoEntrega";
	}
}
