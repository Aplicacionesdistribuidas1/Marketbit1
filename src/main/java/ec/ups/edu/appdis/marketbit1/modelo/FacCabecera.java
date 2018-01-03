package ec.ups.edu.appdis.marketbit1.modelo;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
public class FacCabecera {
	
	@Id
	@Column(name="facC_codigo", length=10)
	private int codigo;
	
	@NotNull
	@Column(name="facC_numero_factura")
	/*@Size(max=20)*/
	private int numero_factura;
		
	@Temporal(value = TemporalType.DATE)
	@Column(name="facC_fecEmision")
	private Date fechaEmision;
	/*
	@ManyToOne(optional=true)
	@JoinColumn(name="cli_codigo")
	private cliente cliente;*/
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="id_facCab", referencedColumnName="facC_codigo")
	private Set<FacturaDetalle> detalles=new HashSet<>();
	
	

	public Set<FacturaDetalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(Set<FacturaDetalle> detalles) {
		this.detalles = detalles;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNumero_factura() {
		return numero_factura;
	}

	public void setNumero_factura(int numero_factura) {
		this.numero_factura = numero_factura;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public void addDetalle(FacturaDetalle detalle) {
		if(detalles==null)
			detalles=new HashSet<>();
		detalles.add(detalle);
	}

	@Override
	public String toString() {
		return "FacCabecera [codigo=" + codigo + ", numero_factura=" + numero_factura + ", fechaEmision=" + fechaEmision
				+ ", detalles=" + detalles + "]";
	}

		


}
