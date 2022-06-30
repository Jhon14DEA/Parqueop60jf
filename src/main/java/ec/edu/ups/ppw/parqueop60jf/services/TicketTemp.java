package ec.edu.ups.ppw.parqueop60jf.services;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ec.edu.ups.ppw.parqueop60jf.model.Servicio;
import ec.edu.ups.ppw.parqueop60jf.model.Vehiculo;


public class TicketTemp implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	private int codigo;	
	private Date fechaIngreso;
	private Date fechaSalida;
	private double Total;
	
	private VehiculoTemp vehiculotemp;

	private List<Servicio> servicios;

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	public double getTotal() {
		return Total;
	}
	public void setTotal(double total) {
		Total = total;
	}	
	
	public VehiculoTemp getVehiculotemp() {
		return vehiculotemp;
	}
	public void setVehiculotemp(VehiculoTemp vehiculotemp) {
		this.vehiculotemp = vehiculotemp;
	}
	public List<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
//	@Override
//	public String toString() {
//		return "TicketTemp2 [codigo=" + codigo + ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida
//				+ ", Total=" + Total + "]";
//	}
	@Override
	public String toString() {
		return "TicketTemp [codigo=" + codigo + ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida
				+ ", Total=" + Total + ", vehiculo=" + vehiculotemp + ", servicios=" + servicios + "]";
	}
	
	
	
	
	
	
}
