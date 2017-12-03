package ec.ups.edu.appdis.marketbit1.datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.ups.edu.appdis.marketbit1.modelo.empleado;

@Stateless
public class empleadoDAO {
	
	@Inject
	private EntityManager em;
	
	public void guardar(empleado emp) {
		empleado aux = leer(emp.getCodigo());
		if (aux!=null) {
			acuatilizar(emp);
		}else {
			insertar(emp);
		}
	}
	
	public void insertar  (empleado emp ){
		em.persist(emp);
	}
	
	public void acuatilizar(empleado emp){
		em.merge(emp);
	}

	public void borar  (int id ){
		empleado emp = leer(id);
		em.remove(emp);
	}

	public empleado leer  (int id ){
		empleado emp = em.find(empleado.class, id);
		return emp;
	}
	
	public java.util.List<empleado> ListadoEmpleados(){
		Query query = em.createQuery("SELECT emp  FROM empleado emp", empleado.class);
		java.util.List<empleado> listado = query.getResultList();
		return listado;
	}

}
