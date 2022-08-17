package com.example.demo.controller;

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

import com.example.demo.dto.Facultad;
import com.example.demo.service.FacultadServiceImpl;

@RestController
@RequestMapping("/api")
public class FacultadController {

	@Autowired
	FacultadServiceImpl facultadServiceImpl;
	
	@GetMapping("/facultades")
	public List<Facultad> listarFacultads(){
		return facultadServiceImpl.listarFacultads();
	}
	
	@PostMapping("/facultades")
	public Facultad salvarFacultad(@RequestBody Facultad facultad) {
		
		return facultadServiceImpl.guardarFacultad(facultad);
	}
	
	@GetMapping("/facultades/{codigo}")
	public Facultad facultadXID(@PathVariable(name="codigo") int codigo) {
		
		Facultad facultad_xid= new Facultad();
		
		facultad_xid=facultadServiceImpl.facultadXID(codigo);
		
		
		return facultad_xid;
	}
	
	@PutMapping("/facultades/{codigo}")
	public Facultad actualizarFacultad(@PathVariable(name="codigo")int codigo,@RequestBody Facultad facultad) {
		
		Facultad facultad_seleccionado= new Facultad();
		Facultad facultad_actualizado= new Facultad();
		
		facultad_seleccionado= facultadServiceImpl.facultadXID(codigo);
		
		facultad_seleccionado.setNombre(facultad.getNombre());
		
		facultad_actualizado = facultadServiceImpl.actualizarFacultad(facultad_seleccionado);
		
		
		return facultad_actualizado;
	}
	
	@DeleteMapping("/facultades/{codigo}")
	public void eleiminarFacultad(@PathVariable(name="codigo")int codigo) {
		facultadServiceImpl.eliminarFacultad(codigo);
	}
	
	
}