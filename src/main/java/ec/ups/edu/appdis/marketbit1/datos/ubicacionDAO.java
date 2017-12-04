package ec.ups.edu.appdis.marketbit1.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.ups.edu.appdis.marketbit1.modelo.ubicacion;

@Stateless
public class ubicacionDAO {
	@Inject
	private EntityManager em;
	
	public void guardar(ubicacion u) {
		ubicacion aux=leer(u.getCodigo());
		if(aux!=null) {
			actualizar(u);
		}else {
			insertar(u);
		}
	}
	
	public void insertar (ubicacion u) {
		em.persist(u);
	}
	
	public void actualizar(ubicacion u) {
		em.merge(u);
	}
	
	public void borrar(int id) {
		ubicacion u=leer(id);
		em.remove(u);
	}
	public ubicacion leer (int id) {
		ubicacion u = em.find(ubicacion.class, id);
		return u;
	}
	
	public List<ubicacion> listadoUbicacion(){
		Query query = em.createQuery("SELECT u FROM ubicacion u", ubicacion.class);
		List<ubicacion>listado = query.getResultList();
		return listado;
	}

}
