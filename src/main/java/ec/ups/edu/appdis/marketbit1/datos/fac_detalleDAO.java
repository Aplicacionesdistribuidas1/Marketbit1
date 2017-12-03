package ec.ups.edu.appdis.marketbit1.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.ups.edu.appdis.marketbit1.modelo.fac_detalle;

@Stateless
public class fac_detalleDAO {

	@Inject
	private EntityManager em;
	
	public void guardar(fac_detalle fd) {
		
		fac_detalle aux = leer(fd.getCodigo());
		if(aux!=null) {
			actualizar(fd);
		}else {
			insertar(fd);
		}
	}
	
	public void insertar(fac_detalle fd) {
		em.merge(fd);
		}
	
	public void actualizar(fac_detalle fd) {
		em.merge(fd);
	}
	
	public void borrar (int id) {
		fac_detalle fd = leer(id);
		em.remove(fd);
	}
	
	public fac_detalle leer(int id) {
		fac_detalle fd = em.find(fac_detalle.class, id);
		return fd;
	}
	
	public List<fac_detalle> listadofacDetalle(){
		Query query = em.createQuery("SELECT fd FROM fac_detalle", fac_detalle.class);
		List<fac_detalle>listado=query.getResultList();
		return listado;
	}
}
