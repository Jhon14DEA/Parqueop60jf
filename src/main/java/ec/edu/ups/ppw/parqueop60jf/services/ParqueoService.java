package ec.edu.ups.ppw.parqueop60jf.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.edu.ups.ppw.parqueop60jf.bussiness.ParqueaderoBussiness;
import ec.edu.ups.ppw.parqueop60jf.model.Ticket;
import ec.edu.ups.ppw.parqueop60jf.model.Vehiculo;

@Path("parqueadero")
public class ParqueoService {

//	es de ejb y tenemos que seguir el flujo 
	@Inject
	private ParqueaderoBussiness parqueadero;

//	tipos de respuesta que me va devolve "cuado son consultas uso el get y reprecentacion o mostrar algo "
	@GET
	@Path("tickets")
	@Produces("application/json")
	public List<Ticket> getTicketsParqueadero() {
		return parqueadero.getTickets();
	}

	@GET
	@Path("ticketsTemp")
	@Produces("application/json")
	public List<TicketTemp> getTicketsParqueadero2() {
		return parqueadero.getTicketsTemp();
	}

	@GET
	@Path("ticket")
	@Produces("application/json")
	public Ticket getTicketParqueadero(@QueryParam("id") int codigo) {
		System.out.println("Consultando Ticket" + codigo);
		return parqueadero.getTicket(codigo);
	}

	/**
	 * de esta manera decimos que el parametro va a venir dentro de la URL {id} por
	 * lo general se usa cuando queremos consultar o recuperar datos.
	 * 
	 * @param codigo
	 * @return
	 */
	@GET
	@Path("ticket/{id}")
	@Produces("application/json")
	public Ticket getTicketParqueadero2(@PathParam("id") int codigo) {
		System.out.println("Consultando Ticket" + codigo);
		return parqueadero.getTicket(codigo);
	}
//	=============================================================================

	@GET
	@Path("ticket2")
	@Produces("application/json")
	public TicketTemp getTicketParqueadero3(@QueryParam("id") int codigo) {
		System.out.println("Consultando Ticket" + codigo);
		return parqueadero.getTicket2(codigo);
	}

	/**
	 * de esta manera decimos que el parametro va a venir dentro de la URL {id} por
	 * lo general se usa cuando queremos consultar o recuperar datos.
	 * 
	 * @param codigo
	 * @return
	 */
	@GET
	@Path("ticket2/{id}")
	@Produces("application/json")
	public TicketTemp getTicketParqueadero4(@PathParam("id") int codigo) {
		System.out.println("Consultando Ticket" + codigo);
		return parqueadero.getTicket2(codigo);
	}

//	Consumir o consultar datos el de POST es para realizar una trasccion recoger datos el PUT es para insertar y delete para borrar. 
	@GET
	@Path("hola")
	public String getSaludo() {
		return "hola PFA";

	}

	/**
	 * Cuando le pasamos un objeto necesitamos el consumes donde le decimos en que formato va a llegar 
	 * @param vehiculo
	 * @return
	 */
	@POST
	@Path("ingreso")
	@Consumes("application/json")
	public String registrarIngreso(Vehiculo vehiculo) {
		try {
			parqueadero.ingresoVehiculo(vehiculo);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}

	}

}
