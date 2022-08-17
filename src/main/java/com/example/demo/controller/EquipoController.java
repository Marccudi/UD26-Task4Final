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

import com.example.demo.dto.Equipo;
import com.example.demo.service.EquipoServiceImpl;

@RestController
@RequestMapping("/api")
public class EquipoController {

	@Autowired
	EquipoServiceImpl equipoServiceImpl;
	
	@GetMapping("/equipos")
	public List<Equipo> listarEquipos(){
		return equipoServiceImpl.listarEquipos();
	}
	
	@PostMapping("/equipos")
	public Equipo salvarEquipo(@RequestBody Equipo equipo) {
		
		return equipoServiceImpl.guardarEquipo(equipo);
	}
	
	@GetMapping("/equipos/{codigo}")
	public Equipo equipoXID(@PathVariable(name="codigo") String codigo) {
		
		Equipo equipo_xid= new Equipo();
		
		equipo_xid=equipoServiceImpl.equipoXID(codigo);
		
		
		return equipo_xid;
	}
	
	@PutMapping("/equipos/{codigo}")
	public Equipo actualizarEquipo(@PathVariable(name="codigo")String codigo,@RequestBody Equipo equipo) {
		
		Equipo equipo_seleccionado= new Equipo();
		Equipo equipo_actualizado= new Equipo();
		
		equipo_seleccionado= equipoServiceImpl.equipoXID(codigo);
		
		equipo_seleccionado.setNombre(equipo.getNombre());
		
		equipo_actualizado = equipoServiceImpl.actualizarEquipo(equipo_seleccionado);
		
		
		return equipo_actualizado;
	}
	
	@DeleteMapping("/equipos/{codigo}")
	public void eleiminarEquipo(@PathVariable(name="codigo")String codigo) {
		equipoServiceImpl.eliminarEquipo(codigo);
	}
	
	
}