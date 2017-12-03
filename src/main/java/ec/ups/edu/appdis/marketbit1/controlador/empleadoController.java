package ec.ups.edu.appdis.marketbit1.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.ups.edu.appdis.marketbit1.datos.empleadoDAO;
import ec.ups.edu.appdis.marketbit1.modelo.empleado;

@ManagedBean
public class empleadoController {
	
	@Inject
	private empleadoDAO empdao;
	
	
	private empleado empleados = null;
	
	private List<empleado> listEmpleado;
	
	private int id;
	
	@PostConstruct
	public void init(){
		empleados = new empleado();
		LoadEmpleados();
	}

	

	public empleadoDAO getEmpdao() {
		return empdao;
	}



	public void setEmpdao(empleadoDAO empdao) {
		this.empdao = empdao;
	}



	public empleado getEmpleados() {
		return empleados;
	}

	public void setEmpleados(empleado empleados) {
		this.empleados = empleados;
	}

	public List<empleado> getListEmpleado() {
		return listEmpleado;
	}

	public void setListEmpleado(List<empleado> listEmpleado) {
		this.listEmpleado = listEmpleado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		LoadDatosEditar(id);
	}
	
	public void LoadEmpleados() {
		listEmpleado = empdao.ListadoEmpleados();
	}
	
	public String LoadDatosEditar(int id) {
		System.out.println("cargando datos de persona a editar "+ id);
		empleados = empdao.leer(id);
		return "empleados";
	}

	public String guardar(){
		System.out.println(empleados);
		empdao.guardar(empleados);
		LoadEmpleados();
		 return "listar";
	}
	
	public String eliminar(int id) {
		empdao.borar(id);
		return "listar";
	}
	
	

}
