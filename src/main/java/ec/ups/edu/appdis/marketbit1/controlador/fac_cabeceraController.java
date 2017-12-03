package ec.ups.edu.appdis.marketbit1.controlador;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import ec.ups.edu.appdis.marketbit1.datos.fac_cabeceraDAO;

@ManagedBean
public class fac_cabeceraController {
	
<<<<<<< master
=======

>>>>>>> 3140dba c6
	@Inject
	private fac_cabeceraDAO fcdao;
	

	private fac_cabecera fac_cabecera = null;
	private List<fac_cabecera> fac_cabecera;
	
	private int id;
	
	@PostConstruct
	public void init() {
		fac_cabecera = new fac_cabecera();
		loadfac_cabecera();
	}
	
	public fac_cabecera getfac_cabecera() {
		return fac_cabecera;
	}
	
	public void setfac_cabecera(fac_cabecera fac_cabecera) {
		
		this.fac_cabecera = fac_cabecera;
		
	} 
	
	public void loadfac_cabecera() {
		fac_cabecera = fcdao.listadofacCabecera();
	}
	
	public String guardar() {
		fcdao.guardar(fac_cabecera);
		loadfac_cabecera();
		return "listadofacCabecera";
	}
	
	
}
