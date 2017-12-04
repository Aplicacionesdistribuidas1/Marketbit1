package ec.ups.edu.appdis.marketbit1.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.ups.edu.appdis.marketbit1.modelo.entrega;


@Stateless
public class entregaDAO {
	
	@Inject
	private EntityManager em;
	
	public void guardar(entrega en) {
		entrega aux=leer(en.getCodigo());
		if(aux!=null) {
			actualizar(en);
		}else {
			insertar(en);
		}
	}
	public void insertar (entrega en) {
		em.persist(en);
	}
	
	public void actualizar(entrega en) {
		em.merge(en);
	}
	
	public void borrar (int id) {
		entrega en = leer(id);
		em.remove(en);
	}
	
	public entrega leer (int id) {
		entrega en=em.find(entrega.class, id);
		return en;
	}
	
	public List<entrega> listadoEntrega(){
		Query query = em.createQuery("SELECT en FROM entrega en", entrega.class);
		List<entrega>listado =query.getResultList();
		return listado;
	}

}
