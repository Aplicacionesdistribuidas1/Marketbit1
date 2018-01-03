package ec.ups.edu.appdis.marketbit1.datos;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

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
	
	String usuario1;
	
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
	
	public Cliente Buscar (String usuario) {
		Cliente cli = em.find(Cliente.class, usuario);
		return cli;
	}
	
	public List<Cliente> listadoCliente(){
		javax.persistence.Query query= em.createQuery("SELECT cli FROM Cliente cli  ", Cliente.class);
		java.util.List<Cliente>listado = query.getResultList();
		return listado;
		
	}
	
	public List<Cliente> listadoNombre(){
		//javax.persistence.Query query= em.createQuery("SELECT cli FROM Cliente cli where usuario = 'jpelaez92' ", Cliente.class);
		javax.persistence.Query query= em.createQuery("SELECT cli FROM Cliente cli where usuario = :name").setParameter("name", usuario1);
		java.util.List<Cliente>listado = query.getResultList();
		return listado;
	}
	
	public Cliente getCliente(String usuario, String contrasena){ 
		usuario1 = usuario;
		try {
			Cliente cliente = (Cliente) em .createQuery( "SELECT u from Cliente u where u.usuario = :name and u.contrasena = :password") 
					.setParameter("name", usuario) .setParameter("password", contrasena).getSingleResult();
			return cliente; 
			} catch (NoResultException e) { 
				return null; 
				} 
		}
	
	public int contador_cliente() {
		int aux = 0;
		try {
			 aux= (Integer) em.createNativeQuery("select max(cli_codigo) from cliente").getSingleResult();
			 return aux;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return aux;
	}
	
	public String cedula(String cedula) {
		String hola = "no";
		try {
			ArrayList<String> cedula1 = new ArrayList<String>();
			ArrayList<Integer> cedula2 = new ArrayList<Integer>();
			for (int i = 1; i <= cedula.length(); i++) {
				cedula1.add(cedula.substring(i-1, i));
				//System.out.println(cedula1.get(i-1));
				cedula2.add(Integer.parseInt(cedula1.get(i-1)));
				//System.out.println(cedula2.get(i-1));
			}
			ArrayList<Integer> cedula3 = new ArrayList<Integer>();
			cedula3.add(2);
			cedula3.add(1);
			cedula3.add(2);
			cedula3.add(1);
			cedula3.add(2);
			cedula3.add(1);
			cedula3.add(2);
			cedula3.add(1);
			cedula3.add(2);
			ArrayList<Integer> cedula4 = new ArrayList<Integer>();
			ArrayList<Integer> cedula5 = new ArrayList<Integer>();
			for (int i = 0; i <= cedula3.size()-1; i++) {
				cedula4.add(cedula2.get(i)*cedula3.get(i));
				if (cedula4.get(i)>10) {
					int decena = cedula4.get(i)/10;
					int unidad = cedula4.get(i)%10;
					cedula5.add(decena+unidad);
					//System.out.println(cedula5.get(i));
				} else {
					cedula5.add(cedula4.get(i));
					//System.out.println(cedula5.get(i));
				}
			}
			int subtotal = cedula5.get(0)+cedula5.get(1)+cedula5.get(2)+cedula5.get(3)+cedula5.get(4)+cedula5.get(5)+cedula5.get(6)+cedula5.get(7)+cedula5.get(8);
			//System.out.println(subtotal);
			int aux = ((subtotal/10)+1)*10;
			//System.out.println(aux);
			int total = aux-subtotal;
			//System.out.println(total);
			int aux2 = subtotal%10;
			//System.out.println(aux2);
			if (aux2==cedula2.get(9)) {
				hola = "si";
			} else if (total==cedula2.get(9)) {
				hola = "si";
			} 
			

		} catch (Exception e) {
			// TODO: handle exception
			
		}
		return hola;
	}
	
	public Cliente getUsuario(String usuario){ 
		try {
			Cliente cliente = (Cliente) em .createQuery( "SELECT u from Cliente u where u.usuario = :name ").setParameter("name", usuario).getSingleResult();
			System.out.println(cliente);
			return cliente; 
			} catch (NoResultException e) { 
				
				}
		return null; 
	}
	
	public Cliente getCorreo(String correo){ 
		try {
			Cliente cliente = (Cliente) em .createQuery( "SELECT u from Cliente u where u.email = :name ").setParameter("name", correo).getSingleResult();
			System.out.println(cliente);
			return cliente; 
			} catch (NoResultException e) { 
				return null; 
				}
	}
	
	public String getNombre(String usuario) {
		try {
			String nombre = (String) em.createQuery("SELECT u.nombres from Cliente u where u.usuario = :name").setParameter("name", usuario).getSingleResult();
			System.out.println(nombre);
			return nombre;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public List<Cliente> listadoNombres(){
		javax.persistence.Query query= em.createQuery("SELECT cli FROM Cliente cli where usuario = 'jpelaez92' ", Cliente.class);
		java.util.List<Cliente>listado = query.getResultList();
		return listado;
	}
	

}
