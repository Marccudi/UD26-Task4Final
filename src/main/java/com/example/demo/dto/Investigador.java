package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="investigadores")
public class Investigador {
	@Id
	private String dni;
	@Column
	private String nomapels;
	
	@OneToMany
	@JoinColumn(name = "dni")
	private List<Reserva> reserva;
	
	@ManyToOne
	@JoinColumn(name = "facultad")
	private Facultad facultad;

	public Investigador() {
	}
	public Investigador(String dni, String nomapels, List<Reserva> reserva, Facultad facultad) {
		this.dni = dni;
		this.nomapels = nomapels;
		this.reserva = reserva;
		this.facultad = facultad;
	}
	public String getDni() {
		return dni;
	}
	public String getNomapels() {
		return nomapels;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reserva")
	public List<Reserva> getReserva() {
		return reserva;
	}
	public Facultad getFacultad() {
		return facultad;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setNomapels(String nomapels) {
		this.nomapels = nomapels;
	}
	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}
	@Override
	public String toString() {
		return "Investigador [dni=" + dni + ", nomapels=" + nomapels + ", reserva=" + reserva + ", facultad=" + facultad
				+ "]";
	}
	
	

}
