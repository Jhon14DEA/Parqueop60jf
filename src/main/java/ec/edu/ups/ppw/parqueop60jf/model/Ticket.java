package ec.edu.ups.ppw.parqueop60jf.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Ticket implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue
	private String codigo;
	
//	private Date fechaIngreso;
//	private Date fechaSalida;
	private String fechaIngreso;
	private String fechaSalida;
	
//	@OneToOne
//	@JoinColumn(name="placa_vehiculo")
//	private Vehiculo vehiculo;
	
	@OneToMany
	@JoinColumn(name="id_ticket")
	private List<Servicio> servicios;
	
	

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
//	public Vehiculo getVehiculo() {
//		return vehiculo;
//	}
//	public void setVehiculo(Vehiculo vehiculo) {
//		this.vehiculo = vehiculo;
//	}
	public List<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	@Override
	public String toString() {
		return "Ticket [codigo=" + codigo + ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida + "]";
	}
	
	
	
	
}
