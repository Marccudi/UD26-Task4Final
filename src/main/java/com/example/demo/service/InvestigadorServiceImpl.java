package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IInvestigadorDAO;
import com.example.demo.dto.Investigador;

@Service
public class InvestigadorServiceImpl {
	@Autowired
	IInvestigadorDAO InvestigadorDAO;
	
public List<Investigador> listarInvestigadors() {
		
		return InvestigadorDAO.findAll();
	}

	
	public Investigador guardarInvestigador(Investigador investigador) {
		
		return InvestigadorDAO.save(investigador);
	}

	
	public Investigador investigadorXID(String id) {
		
		return InvestigadorDAO.findById(id).get();
	}

	
	public Investigador actualizarInvestigador(Investigador investigador) {
		
		return InvestigadorDAO.save(investigador);
	}

	
	public void eliminarInvestigador(String id) {
		
		InvestigadorDAO.deleteById(id);
		
	}
}
