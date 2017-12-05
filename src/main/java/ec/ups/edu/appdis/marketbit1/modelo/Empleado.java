package ec.ups.edu.appdis.marketbit1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Empleado {
	
	@Id
	@Column(name = "emp_codigo")
	private int codigo;
	
	@NotNull
	@Column(name = "emp_cedula", length = 10)
	@Size(max = 10)
	private String cedula;
	
	@NotNull
	@Column(name = "emp_nombre")
	@Size(min = 4, max = 20)
	private String nombre;
	
	@NotNull
	@Column(name = "emp_usuario")
	@Size(min = 4, max = 20)
	private String usuario;
	
	@NotNull
	@Column(name = "emp_contrasena")
	@Size(min = 4, max = 20)
	private String contrasena;
	
	@NotNull
	@Column(name = "emp_cargo")
	@Size(min = 4, max = 20)
	private String cargo;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="id", referencedColumnName="emp_codigo")
	private List<entrega> entregas;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public void addEntrega(entrega entrega) {
		if(entregas==null)
			entregas=new ArrayList<>();
			entregas.add(entrega);
	}
	
	public List<entrega> getEntregas() {
		return entregas;
	}

	public void setEntregas(List<entrega> entregas) {
		this.entregas = entregas;
	}
	
	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", cedula=" + cedula + ", nombre=" + nombre + ", usuario=" + usuario
				+ ", contrasena=" + contrasena + ", cargo=" + cargo + "]";
	}

	
	

}
