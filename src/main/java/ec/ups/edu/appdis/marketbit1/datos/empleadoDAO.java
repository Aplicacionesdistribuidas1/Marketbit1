package ec.ups.edu.appdis.marketbit1.datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.ups.edu.appdis.marketbit1.modelo.Empleado;

@Stateless
public class empleadoDAO {
	
	@Inject
private EntityManager em;
	
	public void guardar(Empleado emp) {
		Empleado aux=leer(emp.getCodigo());
		if(aux!=null){
			actualizar(emp);
		}else {
			insertar(emp);
			
		}
	}
	
	public void insertar (Empleado emp) {
		em.persist(emp);
	}
	
	public void actualizar (Empleado emp) {
		em.merge(emp);
	}
	
	public void borrar (int id) {
		Empleado emp = leer (id);
		em.remove(emp);
	}
	
	public Empleado leer (int id) {
		Empleado emp = em.find(Empleado.class, id);
		return emp;
	
	}
	public java.util.List<Empleado> listadoEmpleado(){
		javax.persistence.Query query= em.createQuery("SELECT emp FROM Empleado emp", Empleado.class);
		java.util.List<Empleado>listado = query.getResultList();
		return listado;
	}

}



