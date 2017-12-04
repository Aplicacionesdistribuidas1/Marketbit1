package ec.ups.edu.appdis.marketbit1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ubicacion {
	
	@Id
	private int codigo;
	@NotNull
	@Column(name="ub_direccion", length=50)
	private String direccion;
	@NotNull
	@Column(name="ub_sector")
	private String sector;
	@NotNull
	@Column(name="ub_vectorx")
	private double vectorx;
	@NotNull
	@Column(name="ub_vectory")
	private double vectory;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public double getVectorx() {
		return vectorx;
	}
	public void setVectorx(double vectorx) {
		this.vectorx = vectorx;
	}
	public double getVectory() {
		return vectory;
	}
	public void setVectory(double vectory) {
		this.vectory = vectory;
	}
	
	
	
}
