package ec.edu.ups.ppw.parqueop60jf.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
	private int codigo;	
	private Date fechaIngreso;
	private Date fechaSalida;
	private double Total;
//	private String fechaIngreso;
//	private String fechaSalida;
	
	@OneToOne
	@JoinColumn(name="placa_vehiculo")
	private Vehiculo vehiculo;
//	el cascade se usa en el one tu many 
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_ticket")
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
	public List<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	
	public double getTotal() {
		return Total;
	}
	public void setTotal(double total) {
		Total = total;
	}
	@Override
	public String toString() {
		return "Ticket [codigo=" + codigo + ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida
				+ ", Total=" + Total + ", vehiculo=" + vehiculo + ", servicios=" + servicios + "]";
	}
	
	
	
	
	
	
}
