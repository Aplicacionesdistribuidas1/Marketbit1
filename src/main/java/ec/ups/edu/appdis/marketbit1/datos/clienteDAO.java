package ec.ups.edu.appdis.marketbit1.datos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import ec.ups.edu.appdis.marketbit1.modelo.cliente;

@Stateless
public class clienteDAO {
	
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

}
