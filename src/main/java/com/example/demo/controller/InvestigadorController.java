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

import com.example.demo.dto.Investigador;
import com.example.demo.service.InvestigadorServiceImpl;

@RestController
@RequestMapping("/api")
public class InvestigadorController {

	@Autowired
	InvestigadorServiceImpl investigadorServiceImpl;
	
	@GetMapping("/investigadores")
	public List<Investigador> listarInvestigadors(){
		return investigadorServiceImpl.listarInvestigadors();
	}
	
	@PostMapping("/investigadores")
	public Investigador salvarInvestigador(@RequestBody Investigador investigador) {
		
		return investigadorServiceImpl.guardarInvestigador(investigador);
	}
	
	@GetMapping("/investigadores/{codigo}")
	public Investigador investigadorXID(@PathVariable(name="codigo") String codigo) {
		
		Investigador investigador_xid= new Investigador();
		
		investigador_xid=investigadorServiceImpl.investigadorXID(codigo);
		
		
		return investigador_xid;
	}
	
	@PutMapping("/investigadores/{codigo}")
	public Investigador actualizarInvestigador(@PathVariable(name="codigo")String codigo,@RequestBody Investigador investigador) {
		
		Investigador investigador_seleccionado= new Investigador();
		Investigador investigador_actualizado= new Investigador();
		
		investigador_seleccionado= investigadorServiceImpl.investigadorXID(codigo);
		
		investigador_seleccionado.setNomapels(investigador.getNomapels());
		
		investigador_actualizado = investigadorServiceImpl.actualizarInvestigador(investigador_seleccionado);
		
		
		return investigador_actualizado;
	}
	
	@DeleteMapping("/investigadores/{codigo}")
	public void eleiminarInvestigador(@PathVariable(name="codigo")String codigo) {
		investigadorServiceImpl.eliminarInvestigador(codigo);
	}
	
	
}