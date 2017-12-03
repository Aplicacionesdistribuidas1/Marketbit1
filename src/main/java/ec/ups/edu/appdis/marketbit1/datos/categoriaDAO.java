package ec.ups.edu.appdis.marketbit1.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.ups.edu.appdis.marketbit1.modelo.categoria;

@Stateless
public class categoriaDAO {
	@Inject
	private EntityManager em;
	
	public void guardar(categoria c) {
		categoria aux=leer(c.getCodigo());
		if(aux!=null) {
			actualizar(c);
		}else {
			insertar(c);
		}
	}
	
	public void insertar (categoria c) {
		em.persist(c);
	}
	
	public void actualizar(categoria c) {
		em.merge(c);
	}
	
	public void borrar (int id) {
		categoria c = leer(id);
		em.remove(c);
	}
	
	public categoria leer (int id) {
		categoria c= em.find(categoria.class, id);
		return c;
	}
	
	public List<categoria> listadoCategoria(){
		Query query = em.createQuery("SELECT c FROM categoria c", categoria.class);
		List<categoria>listado = query.getResultList();
		return listado;
	}

}
