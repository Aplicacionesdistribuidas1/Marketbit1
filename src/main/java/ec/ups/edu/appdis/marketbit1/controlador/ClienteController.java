package ec.ups.edu.appdis.marketbit1.controlador;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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
	private List<Cliente> nombres;
	private String cedula;
	
	private int id;
	private List<Cliente> dato;
	@PostConstruct
	public void init() {
		cliente = new Cliente();
		cliente.addUbicacion(new Ubicacion());
		loadClientes();
		loadNombres();
	}
	
	
	
	public List<Cliente> getNombres() {
		return nombres;
	}



	public void setNombres(List<Cliente> nombres) {
		this.nombres = nombres;
	}



	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	
	public void loadNombres() {
		nombres=clidao.listadoNombre();
	}
	
	public String guardar() {
		clidao.guardar(cliente);
		loadClientes();
		contador();
		return "Factura";
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
	
	public String send() { 
		cliente = clidao.getCliente(cliente.getUsuario(), cliente.getContrasena()); 
		if (cliente == null) {
			cliente = new Cliente(); 
			FacesContext.getCurrentInstance().addMessage( null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contrasena incorrectos!", " Login Error!")); 
			return null; 
			} else {
				return "CrearFacturaCabecera"; 
				} 
		}
			
	public void logout() {
		ExternalContext ec=FacesContext.getCurrentInstance().getExternalContext();
		ec.invalidateSession();
		//return "/home.xhtml?faces-redirect=true";\
        try {
			ec.redirect(ec.getRequestContextPath() + "/Login.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String eliminarDatos(int id) {
		clidao.borrar(id);
		return "ListadoClientes";
	}
	

	public List<Cliente> getDato() {
		return dato;
	}

	public void setDato(List<Cliente> dato) {
		this.dato = dato;
	}
	
	public void contador() {
		int aux = clidao.contador_cliente();
		if(aux == 0) {
			aux = 1;
			cliente.setCodigo(aux);
		}else {
			cliente.setCodigo(aux+1);
		}
	}
	
	public void validadorCedula(FacesContext arg0, UIComponent arg1, Object arg2) {
		arg0 = FacesContext.getCurrentInstance();
		String cedula = (String)arg2;
		String aux = clidao.cedula(cedula);
		System.out.println(aux);
		if (aux.equals("no")) {
			((UIInput)arg1).setValid(false);
			arg0.addMessage(arg1.getClientId(arg0), new FacesMessage("Cedula invalida"));
		}
	}
	
	public void validadorUsuario(FacesContext arg0, UIComponent arg1, Object arg2) {
		arg0 = FacesContext.getCurrentInstance();
		String usuario = (String)arg2;
		Cliente aux = clidao.getUsuario(usuario); 
		System.out.println(aux);
		if (aux != null) {
			((UIInput)arg1).setValid(false);
			arg0.addMessage(arg1.getClientId(arg0), new FacesMessage("El usuario ya existe"));
		}
	}
	
	public void validadorCorreo(FacesContext arg0, UIComponent arg1, Object arg2) {
		arg0 = FacesContext.getCurrentInstance();
		String correo = (String)arg2;
		Cliente aux = clidao.getCorreo(correo); 
		System.out.println(aux);
		if (aux != null) {
			((UIInput)arg1).setValid(false);
			arg0.addMessage(arg1.getClientId(arg0), new FacesMessage("El correo ya esta en uso"));
		}
	}
	
	public String nombre() {
		String oNombre = clidao.getNombre(cliente.getUsuario());
		return oNombre;
	}
	

		
}


