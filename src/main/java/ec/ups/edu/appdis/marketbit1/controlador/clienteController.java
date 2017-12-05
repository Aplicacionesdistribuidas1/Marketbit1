package ec.ups.edu.appdis.marketbit1.controlador;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.ups.edu.appdis.marketbit1.datos.clienteDAO;
import ec.ups.edu.appdis.marketbit1.modelo.cliente;
import ec.ups.edu.appdis.marketbit1.modelo.fac_cabecera;
import ec.ups.edu.appdis.marketbit1.modelo.ubicacion;

@ManagedBean
@ViewScoped
public class clienteController {
	
	@Inject
	private clienteDAO clidao;
	
	private cliente cliente = null;
	private List<cliente> clientes;
	
	private int id;
	
	@PostConstruct
	public void init() {
		cliente = new cliente();
		cliente.addUbicacion(new ubicacion());
<<<<<<< master
		cliente.addCabecera(new fac_cabecera());
=======
>>>>>>> 1061fba m50
		loadClientes();
	}

	public clienteDAO getClidao() {
		return clidao;
	}

	public void setClidao(clienteDAO clidao) {
		this.clidao = clidao;
	}

	public cliente getCliente() {
		return cliente;
	}

	public void setCliente(cliente cliente) {
		this.cliente = cliente;
	}

	public List<cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<cliente> clientes) {
		this.clientes = clientes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		loadDatosEditar(id);
	}
	public void loadClientes() {
		clientes=clidao.listadoCliente();
	}
	public String guardar() {
		clidao.guardar(cliente);
		loadClientes();
		return "listadoClientes";
	}
	public String addUbicacion() {
		cliente.addUbicacion(new ubicacion());
		return null;
	}
	
<<<<<<< master
	public String addCabecera() {
		cliente.addCabecera(new fac_cabecera());
		return null;
=======
	public String loadDatosEditar(int id) {
		System.out.println("cargando datos de Cliente a editar"+ id);
		cliente= clidao.leer(id);
		return "FicheroPersona";
>>>>>>> 1061fba m50
	}
	public String eliminarDatos(int id) {
		clidao.borrar(id);
		return "ListadoClientes";
	}
	
	
	public String loadDatosEditar(int id) {
		System.out.println("cargando datos de Cliente a editar"+ id);
		cliente= clidao.leer(id);
		return "FicheroPersona";
	}
	public String eliminarDatos(int id) {
		clidao.borrar(id);
		return "ListadoClientes";
	}
	
	
	
	
}


