package ec.ups.edu.appdis.marketbit1.controlador;


import java.util.List;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.ups.edu.appdis.marketbit1.datos.fac_cabeceraDAO;
import ec.ups.edu.appdis.marketbit1.modelo.fac_cabecera;

@ManagedBean
public class fac_cabeceraController {
	
	@Inject
	private fac_cabeceraDAO fcdao;
	
	private fac_cabecera fac_cabecera = null;
	private List<fac_cabecera> fac_cabeceras;
	
	private int id;
	
	@PostConstruct
	public void init() {
		fac_cabecera = new fac_cabecera();
		loadfac_cabeceras();
	}

	public fac_cabecera getFac_cabecera() {
		return fac_cabecera;
	}

	public void setFac_cabecera(fac_cabecera fac_cabecera) {
		this.fac_cabecera = fac_cabecera;
	}
	
	public void loadfac_cabeceras() {
		fac_cabeceras= fcdao.listadofacCabecera();
	}
	
	public String guardar() {
		fcdao.guardar(fac_cabecera);
		loadfac_cabeceras() ;
		return"listadofacCabeceras";
	}

	public List<fac_cabecera> getFac_cabeceras() {
		return fac_cabeceras;
	}

	public void setFac_cabeceras(List<fac_cabecera> fac_cabeceras) {
		this.fac_cabeceras = fac_cabeceras;
	}
	
	public String loadDatosEditar(int id) {
		System.out.println("Cargar datos de la factura para editar"+id);
		fac_cabecera = fcdao.leer(id);
		return"Ficherofac_cabecera";
	}
	
	public String eliminarDatos(int id) {
		fcdao.borrar(id);
		return"listadofacCabeceras";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		loadDatosEditar(id);
	}
	
	

}
