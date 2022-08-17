package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEquipoDAO;
import com.example.demo.dto.Equipo;

@Service
public class EquipoServiceImpl {
	@Autowired
	IEquipoDAO EquipoDAO;
	
public List<Equipo> listarEquipos() {
		
		return EquipoDAO.findAll();
	}

	
	public Equipo guardarEquipo(Equipo equipo) {
		
		return EquipoDAO.save(equipo);
	}

	
	public Equipo equipoXID(String id) {
		
		return EquipoDAO.findById(id).get();
	}

	
	public Equipo actualizarEquipo(Equipo equipo) {
		
		return EquipoDAO.save(equipo);
	}

	
	public void eliminarEquipo(String id) {
		
		EquipoDAO.deleteById(id);
		
	}
}
