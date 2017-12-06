package ec.ups.edu.appdis.marketbit1.modelo;


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
	
	@Column(name="facC_total")
	/*@Size(min=2,max=20)*/
	private double total;
	
	@Column(name="facC_iva")
	/*@Size(min=2, max=10)*/
	private double iva;
	/*
	@ManyToOne(optional=true)
	@JoinColumn(name="cli_codigo")
	private cliente cliente;*/
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}
	public void addDetalle(FacturaDetalle detalle) {
		if(detalles==null)
			detalles=new HashSet<>();
		detalles.add(detalle);
	}

	@Override
	public String toString() {
		return "fac_cabecera [codigo=" + codigo + ", numero_factura=" + numero_factura + ", total=" + total + ", iva="
				+ iva + ", detalles=" + detalles + "]";
	}
	


}
