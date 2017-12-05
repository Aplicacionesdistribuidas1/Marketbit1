package ec.ups.edu.appdis.marketbit1.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class cliente {
	@Id
	@Column (name="cli_codigo", length=10)
	private int codigo;
	
	@NotNull
	@Column(name="cli_cedula", length=10)
	@Size(max=10)
	private String cedula;
	
	@NotNull
	@Column(name="cli_usuario", length=10)
	@Size(max=10)
	private String usuario;
	
	@NotNull
	@Column(name="cli_contrasena", length=10)
	@Size(max=10)
	private String contrasena;
	
	@Column(name="cli_nombres")
	@Size(min=4,max=20)
	private String nombres;
	
	@Email
	@Column(name="cli_email")
	private String email;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name="cli_fecNaci")
	private Date fechaNacimiento;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="id", referencedColumnName="cli_codigo")
	private List<ubicacion> ubicaciones;

<<<<<<< master
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="id", referencedColumnName="per_codigo")
	private List<fac_cabecera> cabeceras;
	
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

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<ubicacion> getUbicaciones() {
		return ubicaciones;
	}

	public void setUbicaciones(List<ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}
		
	public List<fac_cabecera> getCabeceras() {
		return cabeceras;
	}

	public void setCabeceras(List<fac_cabecera> cabeceras) {
		this.cabeceras = cabeceras;
	}

	public void addUbicacion(ubicacion ubicacion) {
		if(ubicaciones==null)
			ubicaciones=new ArrayList<>();
		ubicaciones.add(ubicacion);
	}
	
	public void addCabecera(fac_cabecera cabecera) {
		if(cabeceras==null)
			cabeceras=new ArrayList<>();
		cabeceras.add(cabecera);
	}

	@Override
	public String toString() {
		return "cliente [codigo=" + codigo + ", cedula=" + cedula + ", usuario=" + usuario + ", contrasena="
				+ contrasena + ", nombres=" + nombres + ", email=" + email + ", fechaNacimiento=" + fechaNacimiento
				+ ", ubicaciones=" + ubicaciones + ", cabeceras=" + cabeceras + "]";
	}

	
=======
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

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<ubicacion> getUbicaciones() {
		return ubicaciones;
	}

	public void setUbicaciones(List<ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}
	
	public void addUbicacion(ubicacion ubicacion) {
		if(ubicaciones==null)
			ubicaciones=new ArrayList<>();
		ubicaciones.add(ubicacion);
	}

	@Override
	public String toString() {
		return "cliente [codigo=" + codigo + ", cedula=" + cedula + ", usuario=" + usuario + ", contrasena="
				+ contrasena + ", nombres=" + nombres + ", email=" + email + ", fechaNacimiento=" + fechaNacimiento
				+ ", ubicaciones=" + ubicaciones + "]";
	}
>>>>>>> 1061fba m50

	
}
