package ec.edu.ups.ppw.parqueop60jf.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Vehiculo implements Serializable{

	private static final long serialVersionUID = 1L;
	
//	@GeneratedValue
//	private int codigoV;
	
	@Column(name="placa_vehiculo")
	private String placa;
	@Id	
	private String marca;
	private String Color;	
	

	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	@Override
	public String toString() {
		return "Vehiculo [placa=" + placa + ", marca=" + marca + ", Color=" + Color + "]";
	}

	
	
	
}
