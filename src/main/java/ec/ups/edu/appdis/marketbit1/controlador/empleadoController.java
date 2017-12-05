package ec.ups.edu.appdis.marketbit1.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.ups.edu.appdis.marketbit1.datos.clienteDAO;
import ec.ups.edu.appdis.marketbit1.datos.empleadoDAO;
import ec.ups.edu.appdis.marketbit1.modelo.Empleado;
import ec.ups.edu.appdis.marketbit1.modelo.cliente;
import ec.ups.edu.appdis.marketbit1.modelo.entrega;
import ec.ups.edu.appdis.marketbit1.modelo.ubicacion;

@ManagedBean
public class empleadoController {

	@Inject
	private empleadoDAO empdao;
	
	private Empleado empleado = null;
	private java.util.List<Empleado> empleados;
	
	private int id;
	
	@PostConstruct
	public void init() {
		empleado = new Empleado();
		empleado.addEntrega(new entrega());
		loadEmpleados();
		
	}
	
	
	public void loadEmpleados() {
		empleados = empdao.listadoEmpleado();
	}
	public String guardar()
	{
		
		empdao.guardar(empleado);
		loadEmpleados();
		return "ListadoEmpleados";
			}

	public String loadDatosEditar(int id) {
		System.out.println("cargando datos de empleado a editar"+ id);
		empleado = empdao.leer(id);
		return "FicheroEmpleado";
	}
	
	public String eliminarDatos(int id) {
		empdao.borrar(id);
		return "ListadoEmpleados";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		loadDatosEditar(id);
	}


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	public List<Empleado> getEmpleados() {
		return empleados;
	}


	public void setEmpleados(java.util.List<Empleado> empleados) {
		this.empleados = empleados;
	}
	public String addEntrega() {
		empleado.addEntrega(new entrega());
		return null;
	}		
}
