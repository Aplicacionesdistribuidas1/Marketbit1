package ec.ups.edu.appdis.marketbit1.controlador;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.ups.edu.appdis.marketbit1.datos.clienteDAO;
import ec.ups.edu.appdis.marketbit1.modelo.Cliente;

@ManagedBean
public class clienteController {
	
	@Inject
	private clienteDAO cldao;
	
	private Cliente cliente = null;
	private java.util.List<Cliente> clientes;
	
	private int id;
	
	@PostConstruct
	public void init() {
		cliente = new Cliente();
		//cliente.addTelefono(new Telefono());
		loadClientes();
	}
	
	
	public void loadClientes() {
		clientes = cldao.listadoCliente();
	}
	public String guardar()
	{
		
		cldao.guardar(cliente);
		loadClientes();
		return "listadoCliente";
	}

	
	
	public String loadDatosEditar(int id) {
		System.out.println("cargando datos de cliente a editar"+ id);
		cliente= cldao.leer(id);
		return "FicheroCliente";
	}
	
	public String eliminarDatos(int id) {
		cldao.borrar(id);
		return "listadoPersonas";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		loadDatosEditar(id);
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public java.util.List<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(java.util.List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	
}


