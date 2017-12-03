package ec.ups.edu.appdis.marketbit1.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.ups.edu.appdis.marketbit1.datos.clienteDAO;
import ec.ups.edu.appdis.marketbit1.modelo.cliente;


@ManagedBean
public class clienteController {
	
	@Inject
	private clienteDAO clidao;

	private cliente clientes = null;
	
	private List<cliente> listCliente;
	
	private int id;
	
	@PostConstruct
	public void init(){
		clientes = new cliente();
		LoadClientes();
	}

	public clienteDAO getClidao() {
		return clidao;
	}

	public void setClidao(clienteDAO clidao) {
		this.clidao = clidao;
	}

	public cliente getClientes() {
		return clientes;
	}

	public void setClientes(cliente clientes) {
		this.clientes = clientes;
	}

	public List<cliente> getListCliente() {
		return listCliente;
	}

	public void setListCliente(List<cliente> listCliente) {
		this.listCliente = listCliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		LoadDatosEditar(id);
	}
	
	public void LoadClientes() {
		listCliente = clidao.ListadoClientes();
	}
	
	public String LoadDatosEditar(int id) {
		System.out.println("cargando datos de persona a editar "+ id);
		clientes = clidao.leer(id);
		return "clientes";
	}

	public String guardar(){
		System.out.println(clientes);
		clidao.guardar(clientes);
		LoadClientes();
		 return "listar";
	}
	
	public String eliminar(int id) {
		clidao.borar(id);
		return "listar";
	}
	
	
}
