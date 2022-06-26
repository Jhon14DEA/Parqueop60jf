package ec.edu.ups.ppw.parqueop60jf.bussiness;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw.parqueop60jf.dao.TicketDAO;
import ec.edu.ups.ppw.parqueop60jf.dao.VehiculoDAO;
import ec.edu.ups.ppw.parqueop60jf.model.Ticket;
import ec.edu.ups.ppw.parqueop60jf.model.Vehiculo;

@Stateless
public class ParqueaderoBussiness implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private VehiculoDAO daoVehiculo;
	@Inject
	private TicketDAO daoTicket;
	
	public void ingresoVehiculo(String placa) throws Exception {
		if(daoVehiculo.read(placa)==null) {
			throw new Exception("Vechiculo no existe");
		}
		Ticket ticket = new Ticket();
		ticket.setFechaIngreso(new Date());
		
		Vehiculo v = new Vehiculo();
		v.setPlaca(placa);
		ticket.setVehiculo(v);
		daoTicket.insert(ticket);
		
//		ticket.setVehiculo(daoVehiculo.read(placa)); alternativa de agregacion
	}
	
	public void ingresoVehiculo(Vehiculo vehiculo) {
		Ticket ticket = new Ticket();
		ticket.setFechaIngreso(new Date());
		
		ticket.setVehiculo(vehiculo);		
		daoTicket.insert(ticket);
		
	}
	public void retirarVehiculo(int numeroTicket) throws Exception {
		Ticket ticket = daoTicket.read(numeroTicket);
		if(ticket == null) {
			throw new Exception("Vechiculo no existe");
		}
		ticket.setFechaSalida(new Date());
		ticket.setTotal(this.calcularCosto(ticket.getFechaIngreso(), ticket.getFechaSalida()));
	}
	
	public void generarPago() {
		
	}
	public List<Ticket> getTickets(){
		return  daoTicket.list();
	}
	
	public double calcularCosto(Date fechaInicio,  Date fechaFin) {
		return 8;		
	}
	

}
