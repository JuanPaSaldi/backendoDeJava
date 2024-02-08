package com.cedula.ups;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cedula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroCedula() {
		return numeroCedula;
	}

	public void setNumeroCedula(String numeroCedula) {
		this.numeroCedula = numeroCedula;
	}

	private String nombre;
    private String numeroCedula;

    // Constructores, getters y setters

    public Cedula() {
    }

    public Cedula(String nombre, String numeroCedula) {
        this.nombre = nombre;
        this.numeroCedula = numeroCedula;
    }

}
