package ec.ups.edu.appdis.marketbit1.datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class categoriaDAO {
	@Inject
	private EntityManager em;

}
