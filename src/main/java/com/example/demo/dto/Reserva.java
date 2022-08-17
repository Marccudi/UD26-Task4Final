package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String comienzo;
	@Column
	private String fin;
	
	@ManyToOne
	@JoinColumn(name = "dni")
	private Investigador investigador;
	@ManyToOne
	@JoinColumn(name = "numSerie")
	private Equipo equipo;
	
	public Reserva() {
	}
	public Reserva(int id, String comienzo, String fin, Investigador investigador, Equipo equipo) {
		this.id = id;
		this.comienzo = comienzo;
		this.fin = fin;
		this.investigador = investigador;
		this.equipo = equipo;
	}
	public int getId() {
		return id;
	}
	public String getComienzo() {
		return comienzo;
	}
	public String getFin() {
		return fin;
	}
	public Investigador getInvestigador() {
		return investigador;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setComienzo(String comienzo) {
		this.comienzo = comienzo;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", comienzo=" + comienzo + ", fin=" + fin + ", investigador=" + investigador
				+ ", equipo=" + equipo + "]";
	}


}
