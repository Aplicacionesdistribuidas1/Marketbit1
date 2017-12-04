package ec.ups.edu.appdis.marketbit1.controlador;
import ec.ups.edu.appdis.marketbit1.modelo.ubicacion;
import ec.ups.edu.appdis.marketbit1.datos.ubicacionDAO;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

@ManagedBean
public class ubicacionController {
	@Inject
	private ubicacionDAO ubidao;
	private ubicacion ubicacion= null;
	private List<ubicacion> ubicaciones;
	
	private int id;
	
	@PostConstruct
	public void init() {
		ubicacion = new ubicacion();
		loadUbicacion();
	}

	public ubicacionDAO getUbidao() {
		return ubidao;
	}

	public void setUbidao(ubicacionDAO ubidao) {
		this.ubidao = ubidao;
	}

	public ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<ubicacion> getUbicaciones() {
		return ubicaciones;
	}

	public void setUbicaciones(List<ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		loadDatosEditar(id);
	}
	public void loadUbicacion() {
		ubicaciones = ubidao.listadoUbicacion();
	}
	public String guardar() {
		ubidao.guardar(ubicacion);
		loadUbicacion();
		return "listadoUbicacion";
	}
	public String loadDatosEditar(int id) {
		System.out.println("cargando datos de ubicacion a editar"+ id);
		ubicacion= ubidao.leer(id);
		return "crearUbicacion";
	}
	public String eliminarDatos(int id) {
		ubidao.borrar(id);
		return "listadoUbicacion";
	}
}
