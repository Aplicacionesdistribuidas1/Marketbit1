package ec.ups.edu.appdis.marketbit1.datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.ups.edu.appdis.marketbit1.modelo.cliente;

@Stateless
public class clienteDAO {
	
	@Inject
	private EntityManager em;
	
	public void guardar(cliente cli ) {
		cliente aux = leer(cli.getCodigo());
		if (aux!=null) {
			acuatilizar(cli);
		}else {
			insertar(cli);
		}
	}
	
	public void insertar  (cliente cli ){
		em.persist(cli);
	}
	
	public void acuatilizar(cliente cli){
		em.merge(cli);
	}
	
	public void borar  (int id ){
		cliente cli = leer(id);
		em.remove(cli);
	}

	public cliente leer  (int id ){
		cliente cli = em.find(cliente.class, id);
		return cli;
	}
	
	public java.util.List<cliente> ListadoClientes(){
		Query query = em.createQuery("SELECT cli  FROM cliente cli", cliente.class);
		java.util.List<cliente> listado = query.getResultList();
		return listado;
	}

}
