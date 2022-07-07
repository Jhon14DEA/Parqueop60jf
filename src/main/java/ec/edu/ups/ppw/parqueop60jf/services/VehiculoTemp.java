package ec.edu.ups.ppw.parqueop60jf.services;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class VehiculoTemp implements Serializable{

	private static final long serialVersionUID = 1L;
	
//	private int codigov;
	private String placa;
	
	private String marca;
	private String Color;
	
	
//	public int getCodigov() {
//		return codigov;
//	}
//	public void setCodigov(int codigov) {
//		this.codigov = codigov;
//	}
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
//	@Override
//	public String toString() {
//		return "VehiculoTemp [codigov=" + codigov + ", placa=" + placa + ", marca=" + marca + ", Color=" + Color + "]";
//	}
	
	
	
	
	
	
	
}
