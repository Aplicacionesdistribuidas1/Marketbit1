package ec.ups.edu.appdis.marketbit1.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.ups.edu.appdis.marketbit1.modelo.Producto;

@Stateless
public class ProductoDAO {

	@Inject
	private EntityManager em;
	
	public void guardar(Producto pr) {
		Producto aux=leer(pr.getCodigo());
		if(aux!=null){
			actualizar(pr);
		}else {
			insertar(pr);
		}
	}
	public void insertar (Producto pr) {
		em.persist(pr);
	}
	
	public void actualizar (Producto pr) {
		em.merge(pr);
	}
	
	public void borrar (int id) {
		Producto pr = leer (id);
		em.remove(pr);
	}
	
	public Producto leer (int id) {
		Producto pr = em.find(Producto.class, id);
		return pr;
	
	}
	public java.util.List<Producto> listadoProducto(){
		Query query= em.createQuery("SELECT pr FROM Producto pr", Producto.class);
		List<Producto>listado = query.getResultList();
		return listado;
	}
	
}
