package ec.edu.ups.ppw.parqueop60jf;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import ec.edu.ups.ppw.parqueop60jf.dao.ServicioDAO;
import ec.edu.ups.ppw.parqueop60jf.dao.TicketDAO;
import ec.edu.ups.ppw.parqueop60jf.dao.VehiculoDAO;
import ec.edu.ups.ppw.parqueop60jf.model.Servicio;
import ec.edu.ups.ppw.parqueop60jf.model.Ticket;
import ec.edu.ups.ppw.parqueop60jf.model.Vehiculo;

//crea uno solo a nivel de aplicacion y se queda guardado toda la vida a nivel de aplicacion.  se crea uno a nivel de toda la aplicacion
// crea usuarios crea otro de los mismos pero se queda guardado solo para el mientras tenga vida el app 
// stateles crea uno por solicitud se procesa la solicitud y se elimina. 
//@Startup se crea cuando se ejecuta la aplicacion. 
@Singleton
@Startup
public class InitDemo {	
	
	@Inject
	private VehiculoDAO daovehiculo;
	@Inject
	private TicketDAO daoTicket;
	@Inject
	private ServicioDAO daoServicio;

	@PostConstruct
	public void init() {
		// when app is deployed
		System.out.println("init");
		Vehiculo vehiculo = new Vehiculo();
//		daovehiculo = new VehiculoDAO();
		vehiculo.setPlaca("ABA1999");
		vehiculo.setMarca("Toyota Runner");
		vehiculo.setColor("Blanco");
		daovehiculo.insert(vehiculo);
		
		Vehiculo vehiculo2 = new Vehiculo();
//		daovehiculo = new VehiculoDAO();
		vehiculo2.setPlaca("AGAA1549");
		vehiculo2.setMarca("MT 1200")				;
		vehiculo2.setColor("Blanco");
		daovehiculo.insert(vehiculo2);
		
		List<Vehiculo> listado = daovehiculo.list();
		for(Vehiculo v : listado) {
			System.out.println(v);
		}
//	///////////////////	
		Ticket ticket = new Ticket();
		ticket.setCodigo("1");
		ticket.setFechaIngreso("20.05.2022");		
		ticket.setFechaSalida("23-06-2022");
//		ticket1.setVehiculo(vehiculo);
		daoTicket.insert(ticket);

		Ticket ticket2 = new Ticket();
		ticket2.setCodigo("2");
		ticket2.setFechaIngreso("18.05.2022");		
		ticket2.setFechaSalida("21-06-2022");
//		ticket2.setVehiculo(vehiculo2);
		daoTicket.insert(ticket2);
		
		List<Ticket> listado1 = daoTicket.list();
		for(Ticket t : listado1) {
			System.out.println(t);
		}
		
//		////////////////////
		Servicio servicio = new Servicio();
		servicio.setCodigo("1");
		servicio.setDescripcion("Descripcion1");		
		servicio.setValor("Valor1");
//		ticket1.setVehiculo(vehiculo);
		daoServicio.insert(servicio);

		Servicio servicio2 = new Servicio();
		servicio2.setCodigo("2");
		servicio2.setDescripcion("Descripcion2");		
		servicio2.setValor("Valor2");
//		ticket2.setVehiculo(vehiculo2);
		daoServicio.insert(servicio2);
		
		List<Servicio> listado2 = daoServicio.list();
		for(Servicio s : listado2) {
			System.out.println(s);
		}
	}
 
	@PreDestroy
	private void tearDown() {
		// when app is undeployed
		System.out.println("finish app");
	}
}