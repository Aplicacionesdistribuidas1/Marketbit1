package ec.ups.edu.appdis.marketbit1.datos;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.ups.edu.appdis.marketbit1.modelo.Cliente;

@Stateless
public class ClienteDAO {
	
	@Inject
	private EntityManager em;
	
	public void guardar(Cliente cli) {
		Cliente aux=leer(cli.getCodigo());
		if(aux!=null){
			actualizar(cli);
		}else {
			insertar(cli);
			
		}
	}
	
	public void insertar (Cliente cli) {
		em.persist(cli);
	}
	
	public void actualizar (Cliente cli) {
		em.merge(cli);
	}
	
	public void borrar (int id) {
		Cliente cli = leer (id);
		em.remove(cli);
	}
	
	public Cliente leer (int id) {
		Cliente cli = em.find(Cliente.class, id);
		return cli;
	
	}
	public java.util.List<Cliente> listadoCliente(){
		javax.persistence.Query query= em.createQuery("SELECT cli FROM Cliente cli", Cliente.class);
		java.util.List<Cliente>listado = query.getResultList();
		return listado;
	}

}
