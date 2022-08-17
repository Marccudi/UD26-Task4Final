package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IReservaDAO;
import com.example.demo.dto.Reserva;

@Service
public class ReservaServiceImpl {
	@Autowired
	IReservaDAO ReservaDAO;
	
public List<Reserva> listarReservas() {
		
		return ReservaDAO.findAll();
	}

	
	public Reserva guardarReserva(Reserva reserva) {
		
		return ReservaDAO.save(reserva);
	}

	
	public Reserva reservaXID(int id) {
		
		return ReservaDAO.findById(id).get();
	}

	
	public Reserva actualizarReserva(Reserva reserva) {
		
		return ReservaDAO.save(reserva);
	}

	
	public void eliminarReserva(int id) {
		
		ReservaDAO.deleteById(id);
		
	}
}
