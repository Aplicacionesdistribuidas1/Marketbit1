package ec.ups.edu.appdis.marketbit1.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class fac_cabecera {
	
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

	@Override
	public String toString() {
		return "fac_cabecera [codigo=" + codigo + ", numero_factura=" + numero_factura + ", total=" + total + ", iva="
				+ iva + "]";
	}
<<<<<<< master
=======


	
>>>>>>> 1061fba m50

}
