package ec.ups.edu.appdis.marketbit1.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.ups.edu.appdis.marketbit1.modelo.producto;

@Stateless
public class productoDAO {

	@Inject
	private EntityManager em;
	
	public void guardar(producto pr) {
		producto aux=leer(pr.getCodigo());
		if(aux!=null){
			actualizar(pr);
		}else {
			insertar(pr);
		}
	}
	public void insertar (producto pr) {
		em.persist(pr);
	}
	
	public void actualizar (producto pr) {
		em.merge(pr);
	}
	
	public void borrar (int id) {
		producto pr = leer (id);
		em.remove(pr);
	}
	
	public producto leer (int id) {
		producto pr = em.find(producto.class, id);
		return pr;
	
	}
	public java.util.List<producto> listadoProducto(){
		Query query= em.createQuery("SELECT pr FROM producto pr", producto.class);
		List<producto>listado = query.getResultList();
		return listado;
	}
	
}
