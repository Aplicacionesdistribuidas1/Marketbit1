package ec.ups.edu.appdis.marketbit1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class empleado {
	
	@Id
	@Column(name = "emp_codigo")
	private int codigo;
	
	@NotNull
	@Column(name = "per_cedula", length = 10)
	@Size(max = 10)
	private String cedula;
	
	
	@NotNull
	@Column(name = "per_nombre")
	@Size(min = 4, max = 20)
	private String nombre;
	
	@NotNull
	@Column(name = "per_apellido")
	@Size(min = 4, max = 20)
	private String apellido;
	
	@NotNull
	@Column(name = "emp_cargo")
	@Size(min = 4, max = 20)
	private String cargo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}
