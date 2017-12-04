package ec.ups.edu.appdis.marketbit1.datos;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.ups.edu.appdis.marketbit1.modelo.Cliente;

@Stateless
public class clienteDAO {
	
	@Inject
	private EntityManager em;
	
	public void guardar(Cliente cl) {
		Cliente aux=leer(cl.getCodigo());
		if(aux!=null){
			actualizar(cl);
		}else {
			insertar(cl);
			
		}
	}
	
	public void insertar (Cliente cl) {
		em.persist(cl);
	}
	
	public void actualizar (Cliente cl) {
		em.merge(cl);
	}
	
	public void borrar (int id) {
		Cliente cl = leer (id);
		em.remove(cl);
	}
	
	public Cliente leer (int id) {
		Cliente cl = em.find(Cliente.class, id);
		return cl;
	
	}
	public java.util.List<Cliente> listadoCliente(){
		javax.persistence.Query query= em.createQuery("SELECT cl FROM Cliente cl", Cliente.class);
		java.util.List<Cliente>listado = query.getResultList();
		return listado;
	}

}
