package ec.ups.edu.appdis.marketbit1.controlador;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import ec.ups.edu.appdis.marketbit1.datos.fac_detalleDAO;
import ec.ups.edu.appdis.marketbit1.modelo.fac_detalle;


@ManagedBean
public class fac_detalleController {

	@Inject
	private fac_detalleDAO fddao;
	
	private fac_detalle fac_detalle = null;
	private List<fac_detalle> fac_detalles;
	
	private int id;
	
	@PostConstruct
	public void init() {
		fac_detalle = new fac_detalle();
		loadfac_detalle();
	}

	public fac_detalle getFac_detalle() {
		return fac_detalle;
	}

	public void setFac_detalle(fac_detalle fac_detalle) {
		this.fac_detalle = fac_detalle;
	}
	
	public void loadfac_detalle() {
		fac_detalles = fddao.listadofacDetalle();
	}
	
	public String guardar() {
		fddao.guardar(fac_detalle);
		loadfac_detalle();
		return"listadofacDetalles";
	}

	public List<fac_detalle> getFac_detalles() {
		return fac_detalles;
	}

	public void setFac_detalles(List<fac_detalle> fac_detalles) {
		this.fac_detalles = fac_detalles;
	}
	
	public String loadDatosEditar(int id) {
		System.out.println("Cargar datos de la Factura Detalle para editar" + id);
		fac_detalle = fddao.leer(id);
		return"Ficherofac_detalle";
	}
	
	public String eliminarDatos(int id) {
		fddao.borrar(id);
		return"listadofacDetalles";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		loadDatosEditar(id);
	}
	
	
}
