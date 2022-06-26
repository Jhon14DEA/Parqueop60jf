package ec.edu.ups.ppw.parqueop60jf.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Servicio implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int codigo;
	private String descripcion;
	private double valor;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Servicio [codigo=" + codigo + ", descripcion=" + descripcion + ", valor=" + valor + "]";
	}	
	
}
