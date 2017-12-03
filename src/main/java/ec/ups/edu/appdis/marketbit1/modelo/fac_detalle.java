package ec.ups.edu.appdis.marketbit1.modelo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Size;

public class fac_detalle {

	
			
		@Id
		@Column(name = "facD_codigo")
		private int codigo;
		
		@Column(name="facD_numero_detalle")
		@Size(min=4,max=10)
		private int numero_detalle;
		
		@Column(name="facD_valor")
		@Size(min=4,max=20)
		private double valor;

		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public int getNumero_detalle() {
			return numero_detalle;
		}

		public void setNumero_detalle(int numero_detalle) {
			this.numero_detalle = numero_detalle;
		}

		public double getValor() {
			return valor;
		}

		public void setValor(double valor) {
			this.valor = valor;
		}
		
		
	}



