package ec.ups.edu.appdis.marketbit1.controlador;



import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.ups.edu.appdis.marketbit1.datos.FacturaDetalleDAO;
import ec.ups.edu.appdis.marketbit1.modelo.FacturaDetalle;
import ec.ups.edu.appdis.marketbit1.modelo.FacCabecera;
import ec.ups.edu.appdis.marketbit1.modelo.Producto;

@ManagedBean
@ViewScoped
public class FacturaDetalleController {
	
	@Inject
	private FacturaDetalleDAO fddao;
	private FacturaDetalle facturaD = null;
	private List<FacturaDetalle> facturaDs;
	
	public FacturaDetalleDAO getFddao() {
		return fddao;
	}

	public void setFddao(FacturaDetalleDAO fddao) {
		this.fddao = fddao;
	}

	private int id;
	
	@PostConstruct
	public void init() {
		facturaD = new FacturaDetalle();
		facturaD.addProductos(new Producto());
		loadFacturaD();
	}

	public FacturaDetalle getFacturaD() {
		return facturaD;
	}

	public void setFacturaD(FacturaDetalle facturaD) {
		this.facturaD = facturaD;
	}

	public List<FacturaDetalle> getFacturaDs() {
		return facturaDs;
	}

	public void setFacturaDs(List<FacturaDetalle> facturaDs) {
		this.facturaDs = facturaDs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		loadDatosEditar(id);
	}
	
	public void loadFacturaD() {
		facturaDs = fddao.listadoFacturaDetalle();
	}
	
	public String guardar() {
		fddao.guardar(facturaD);
		loadFacturaD();
		return "ListadoFacturaD";
	}
	
	public String loadDatosEditar (int id) {
		System.out.println("cargando datos de ubicacion a editar"+ id);
		facturaD = fddao.leer(id);
		return "FicheroFacturaD";
	}
	
	public String eliminarDatos(int id) {
		fddao.borrar(id);
		return "ListadoFacturaD";
	}
	public String addProductos() {
		facturaD.addProductos(new Producto());
		return null;
	}
}
