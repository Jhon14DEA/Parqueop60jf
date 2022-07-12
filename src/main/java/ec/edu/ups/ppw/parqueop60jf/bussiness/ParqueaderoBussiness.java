package ec.edu.ups.ppw.parqueop60jf.bussiness;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw.parqueop60jf.dao.TicketDAO;
import ec.edu.ups.ppw.parqueop60jf.dao.VehiculoDAO;
import ec.edu.ups.ppw.parqueop60jf.model.Servicio;
import ec.edu.ups.ppw.parqueop60jf.model.Ticket;
import ec.edu.ups.ppw.parqueop60jf.model.Vehiculo;
import ec.edu.ups.ppw.parqueop60jf.services.TicketTemp;
import ec.edu.ups.ppw.parqueop60jf.services.VehiculoTemp;


@Stateless
public class ParqueaderoBussiness implements Serializable{

	SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
	private static final long serialVersionUID = 1L;
	
	@Inject
	private VehiculoDAO daoVehiculo;
	@Inject
	private TicketDAO daoTicket;
	
	/*public void ingresoVehiculo(String placa) throws Exception {
		if(daoVehiculo.read(placa)==null) {
			throw new Exception("Vechiculo no existe");
		}
		Ticket ticket = new Ticket();
		ticket.setFechaIngreso(new Date());
		
		Vehiculo v = new Vehiculo();
		v.setPlaca(placa);
		ticket.setVehiculo(v);
		daoTicket.insert(ticket);	
	}*/
	
	public void ingresoVehiculo(String placa)  {
		
		Ticket ticket = new Ticket();
		String fechaIn = formato.format(new Date());
		ticket.setFechaIngreso(fechaIn);
		
		if(daoVehiculo.read(placa)==null) {
			Vehiculo v = new Vehiculo();
			v.setPlaca(placa);
			ticket.setVehiculo(v);
			daoTicket.insert(ticket);
		}else {
			Vehiculo v = new Vehiculo();
			v.setPlaca(placa);
			ticket.setVehiculo(v);
			daoTicket.update(ticket);
			
		}

		
		
//		ticket.setVehiculo(daoVehiculo.read(placa)); alternativa de agregacion
	}
	
	public void ingresoVehiculo(Vehiculo vehiculo) {
		Ticket ticket = new Ticket();
		String fechaIn = formato.format(new Date());
		ticket.setFechaIngreso(fechaIn);
		
		ticket.setVehiculo(vehiculo);		
		daoTicket.insert(ticket);
		
	}
	public void retirarVehiculo(int numeroTicket) throws Exception {
		Ticket ticket = daoTicket.read(numeroTicket);
		String fechasalida = formato.format(new Date());
		if(ticket == null) {
			throw new Exception("Vechiculo no existe");
		}
		ticket.setFechaSalida(fechasalida);
//		ticket.setTotal(this.calcularCosto(ticket.getFechaIngreso(), ticket.getFechaSalida()));
		ticket.setTotal(this.calcularCosto( ticket));
		System.out.println("El vehiculo salio");
	}
	
/*	public double generarPago(Ticket ticket) {
		  Date fechaSalida;
		  Date fechaIngreso;
		try {
			fechaSalida = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").parse(ticket.getFechaSalida());
			fechaIngreso=new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").parse(ticket.getFechaIngreso()); 
			
	        double minutos =  ( fechaSalida.getTime()- fechaIngreso.getTime())/60000;
	        double fraccion = (int) (minutos / 25);
	        

	        
	        return fraccion * 0.25;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
			return 0.0;
		} 
	 
}*/
	
	
	public Ticket getTicket(int codigo) {
		return daoTicket.read(codigo);
//	revisar tambien el tickettemp 
	}
	
	public TicketTemp getTicket2(int codigo) {
		Ticket ticket = daoTicket.read(codigo);
		String fechaingreso = formato.format(new Date());
		String fechasalida = formato.format(new Date());
		
		TicketTemp t = new TicketTemp();
		t.setCodigo(ticket.getCodigo());
		t.setFechaIngreso(ticket.getFechaIngreso());
		t.setFechaSalida(ticket.getFechaSalida());
		t.setTotal(ticket.getTotal());
		
		VehiculoTemp vt = new VehiculoTemp();
		vt.setPlaca(ticket.getVehiculo().getPlaca());		
		vt.setMarca(ticket.getVehiculo().getMarca());
		vt.setColor(ticket.getVehiculo().getColor());
		t.setVehiculotemp(vt);
		return t;
	}
	
	public List<Ticket> getTickets(){
		return  daoTicket.list();
	}	
	
	public List<TicketTemp> getTicketsTemp() {
		
		List<Ticket> tickets = daoTicket.list();
		List<TicketTemp> listado = new ArrayList<TicketTemp>();
		for(Ticket ticket : tickets) {
			TicketTemp t = new TicketTemp();
			t.setCodigo(ticket.getCodigo());
			t.setFechaIngreso(ticket.getFechaIngreso());
			t.setFechaSalida(ticket.getFechaSalida());
			t.setTotal(ticket.getTotal());
			listado.add(t);			
		}
		return listado;
	}	

	
	private float calcularCosto(Ticket ticket) {
//		double minutos =  ( ticket.getFechaSalida().getTime()- ticket.getFechaIngreso().getTime()) / 60000;
//        double fraccion = (int) (minutos / 30);
//        
//        return fraccion * 1;
		Date fechaing;
		Date fechaSal;
		
		 try {
			fechaing = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").parse(ticket.getFechaIngreso());
			fechaSal = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").parse(ticket.getFechaSalida());
			double minutos = ((fechaSal.getTime()-fechaing.getTime()) / 60000);
			double fraccion = (int) (minutos/10);
			
			
			return (float) (minutos*0.20);
		} catch (Exception e) {
			// getMessage sirve para darme elmensaje de la exepcion
			System.out.println("ERROR:"+e.getMessage());
			return (float) 0.10;
		}
	        
	}
	

}
