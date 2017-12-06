package ec.ups.edu.appdis.marketbit1.controlador;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.ups.edu.appdis.marketbit1.datos.ClienteDAO;
import ec.ups.edu.appdis.marketbit1.modelo.Cliente;
import ec.ups.edu.appdis.marketbit1.modelo.FacCabecera;
import ec.ups.edu.appdis.marketbit1.modelo.Ubicacion;

@ManagedBean
@ViewScoped
public class ClienteController {
	
	@Inject
	private ClienteDAO clidao;
	private Cliente cliente = null;
	private List<Cliente> clientes;
	
	private int id;
	
	@PostConstruct
	public void init() {
		cliente = new Cliente();
		cliente.addUbicacion(new Ubicacion());
		loadClientes();
	}

	public ClienteDAO getClidao() {
		return clidao;
	}

	public void setClidao(ClienteDAO clidao) {
		this.clidao = clidao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
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
		return "ListadoClientes";
	}
	public String addUbicacion() {
		cliente.addUbicacion(new Ubicacion());
		return null;
	}
	
	public String loadDatosEditar(int id) {
		System.out.println("cargando datos de Cliente a editar"+ id);
		cliente= clidao.leer(id);
		return "CrearCliente";

	}
	public String eliminarDatos(int id) {
		clidao.borrar(id);
		return "ListadoClientes";
	}
		
}


