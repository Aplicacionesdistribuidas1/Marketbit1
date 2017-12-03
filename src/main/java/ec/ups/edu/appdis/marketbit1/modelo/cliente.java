package ec.ups.edu.appdis.marketbit1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class cliente {
	
	@Id
	@Column(name = "cli_codigo")
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
	
	@Email
	@Column(name = "cli_email")
	private String email;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return "cliente [codigo=" + codigo + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", email=" + email + "]";
	}
	

	
	
	
	
}