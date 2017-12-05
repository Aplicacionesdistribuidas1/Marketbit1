package ec.ups.edu.appdis.marketbit1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class entrega {
	@Id
	@Column(name="ent_codigo", length=10)
	private int codigo;
	@NotNull
	@Column(name="ent_estado")
	private boolean estado;
	@NotNull
	@Column(name="ent_costo_envio",length=10)
	private double costoEnvio;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public double getCostoEnvio() {
		return costoEnvio;
	}
	public void setCostoEnvio(double costoEnvio) {
		this.costoEnvio = costoEnvio;
	}
	@Override
	public String toString() {
		return "ubicacion [codigo=" + codigo + ", estado=" + estado + ", costoEnvio=" + costoEnvio + "]";
	}
	
	

}
