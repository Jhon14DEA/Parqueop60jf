package ec.edu.ups.ppw.parqueop60jf.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Servicio implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private String codigo;
	private String descripcion;
	private String valor;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Servicio [codigo=" + codigo + ", descripcion=" + descripcion + ", valor=" + valor + "]";
	}	
	
	
	
	
	
	
}
