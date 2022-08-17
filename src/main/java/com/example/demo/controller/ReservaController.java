package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Reserva;
import com.example.demo.service.ReservaServiceImpl;

@RestController
@RequestMapping("/api")
public class ReservaController {

	@Autowired
	ReservaServiceImpl reservaServiceImpl;
	
	@GetMapping("/reservas")
	public List<Reserva> listarReservas(){
		return reservaServiceImpl.listarReservas();
	}
	
	@PostMapping("/reservas")
	public Reserva salvarReserva(@RequestBody Reserva reserva) {
		String hoy = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		reserva.setComienzo(hoy);
		reserva.setFin(hoy);
		return reservaServiceImpl.guardarReserva(reserva);
	}
	
	@GetMapping("/reservas/{codigo}")
	public Reserva reservaXID(@PathVariable(name="codigo") int codigo) {
		
		Reserva reserva_xid= new Reserva();
		
		reserva_xid=reservaServiceImpl.reservaXID(codigo);
		
		
		return reserva_xid;
	}
	
	@PutMapping("/reservas/{codigo}")
	public Reserva actualizarReserva(@PathVariable(name="codigo")int codigo,@RequestBody Reserva reserva) {
		
		Reserva reserva_seleccionado= new Reserva();
		Reserva reserva_actualizado= new Reserva();
		
		reserva_seleccionado= reservaServiceImpl.reservaXID(codigo);
//		reserva_seleccionado.setComienzo(reserva.getComienzo());
//		reserva_seleccionado.setFin(reserva.getFin());
		String hoy = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		reserva_seleccionado.setComienzo(hoy);
		reserva_seleccionado.setFin(hoy);
		
		reserva_actualizado = reservaServiceImpl.actualizarReserva(reserva_seleccionado);
		
		
		return reserva_actualizado;
	}
	
	@DeleteMapping("/reservas/{codigo}")
	public void eleiminarReserva(@PathVariable(name="codigo")int codigo) {
		reservaServiceImpl.eliminarReserva(codigo);
	}
	
	
}