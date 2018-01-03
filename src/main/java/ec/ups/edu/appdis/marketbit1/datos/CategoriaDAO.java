package ec.ups.edu.appdis.marketbit1.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.ups.edu.appdis.marketbit1.modelo.Categoria;

@Stateless
public class CategoriaDAO {
	@Inject
	private EntityManager em;
	
	public void guardar(Categoria c) {
		Categoria aux=leer(c.getCodigo());
		if(aux!=null) {
			actualizar(c);
		}else {
			insertar(c);
		}
	}
	
	public void insertar (Categoria c) {
		em.persist(c);
	}
	
	public void actualizar(Categoria c) {
		em.merge(c);
	}
	
	public void borrar (int id) {
		Categoria c = leer(id);
		em.remove(c);
	}
	
	public Categoria leer (int id) {
		Categoria c= em.find(Categoria.class, id);
		return c;
	}
	
	public List<Categoria> listadoCategoria(){
		Query query = em.createQuery("SELECT c FROM Categoria c", Categoria.class);
		List<Categoria>listado = query.getResultList();
		return listado;
	}

	
}
