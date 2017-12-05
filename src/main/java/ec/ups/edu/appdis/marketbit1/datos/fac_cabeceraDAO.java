package ec.ups.edu.appdis.marketbit1.datos;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.ups.edu.appdis.marketbit1.modelo.fac_cabecera;

@Stateless
public class fac_cabeceraDAO {
	
	@Inject
	private EntityManager em;
	
	public void guardar(fac_cabecera fc) {
		fac_cabecera aux = leer(fc.getCodigo());
		if(aux!=null) {
			actualizar(fc);
		}else {
			insertar(fc);
		}
	}

	
	public void insertar(fac_cabecera fc) {
		em.persist(fc);
	}
	
	public void actualizar(fac_cabecera fc) {
		em.merge(fc);
	}
	
	public void borrar(int id) {
		fac_cabecera fc = leer(id);
		em.remove(fc);
	}
	
	public fac_cabecera leer(int id) {
		fac_cabecera fc = em.find(fac_cabecera.class, id);
		return fc;
	}
	
	public List<fac_cabecera> listadofacCabecera(){
		Query query = em.createQuery("SELECT fc FROM fac_cabecera fc", fac_cabecera.class);
		List<fac_cabecera> listado=query.getResultList();
		return listado;
	}
}
