package ec.edu.ups.ppw.parqueop60jf.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ec.edu.ups.ppw.parqueop60jf.bussiness.ParqueaderoBussiness;
import ec.edu.ups.ppw.parqueop60jf.model.Ticket;

@Path("parqueadero")
public class ParqueoService {

	
//	es de ejb y tenemos que seguir el flujo 
	@Inject
	private ParqueaderoBussiness parqueadero;
	
//	tipos de respuesta que me va devolve "cuado son consultas uso el get"
	@GET
	@Path("tickets")	
	public List<Ticket> getTicketsParqueadero(){
		return parqueadero.getTickets();
	}
	
	@GET
	@Path("hola")
	public String getSaludo() {
		return "hola";
	} 
}
