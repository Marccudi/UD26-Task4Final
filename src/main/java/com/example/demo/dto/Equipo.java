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
@Table(name="equipos")
public class Equipo {
	@Id
	private String numSerie;
	@Column
	private String nombre;
	
	@OneToMany
	@JoinColumn(name = "numSerie")
	private List<Reserva> reserva;
	
	@ManyToOne
	@JoinColumn(name = "facultad")
	private Facultad facultad;

	public Equipo() {
	}
	public Equipo(String numSerie, String nombre, List<Reserva> reserva, Facultad facultad) {
		this.numSerie = numSerie;
		this.nombre = nombre;
		this.reserva = reserva;
		this.facultad = facultad;
	}
	public String getNumSerie() {
		return numSerie;
	}
	public String getNombre() {
		return nombre;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reserva")
	public List<Reserva> getReserva() {
		return reserva;
	}
	public Facultad getFacultad() {
		return facultad;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}
	@Override
	public String toString() {
		return "Equipo [numSerie=" + numSerie + ", nombre=" + nombre + ", reserva=" + reserva + ", facultad=" + facultad
				+ "]";
	}
	
	
}
