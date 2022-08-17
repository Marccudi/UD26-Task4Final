package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IFacultadDAO;
import com.example.demo.dto.Facultad;

@Service
public class FacultadServiceImpl {
	@Autowired
	IFacultadDAO FacultadDAO;
	
public List<Facultad> listarFacultads() {
		
		return FacultadDAO.findAll();
	}

	
	public Facultad guardarFacultad(Facultad facultad) {
		
		return FacultadDAO.save(facultad);
	}

	
	public Facultad facultadXID(int id) {
		
		return FacultadDAO.findById(id).get();
	}

	
	public Facultad actualizarFacultad(Facultad facultad) {
		
		return FacultadDAO.save(facultad);
	}

	
	public void eliminarFacultad(int id) {
		
		FacultadDAO.deleteById(id);
		
	}
}
