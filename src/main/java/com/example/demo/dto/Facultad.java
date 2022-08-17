package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="facultad")
public class Facultad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column
	private String nombre;
	
	@OneToMany
	@JoinColumn(name = "numSerie")
	private List<Equipo> equipo;
	@OneToMany
	@JoinColumn(name = "dni")
	private List<Investigador> investigador;

	public Facultad() {
	}

	public Facultad(int codigo, String nombre, List<Equipo> equipo, List<Investigador> investigador) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.equipo = equipo;
		this.investigador = investigador;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
	public List<Equipo> getEquipo() {
		return equipo;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "investigador")
	public List<Investigador> getInvestigador() {
		return investigador;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEquipo(List<Equipo> equipo) {
		this.equipo = equipo;
	}

	public void setInvestigador(List<Investigador> investigador) {
		this.investigador = investigador;
	}
	
	
	
}
