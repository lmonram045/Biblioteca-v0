package org.iesalandalus.programacion.biblioteca.mvc.modelo.negocio;

import java.time.LocalDate;

import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Alumno;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio.Prestamo;

public class Prestamos {
	// Variables
	private int capacidad;
	private int tamano;
	private Prestamo[] coleccionPrestamos;
	
	/** Constructor de clase Prestamos */
	public Prestamos(int capacidad) {
		if (capacidad < 1)
			throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
		
		tamano = 0;
		this.capacidad = capacidad;
		coleccionPrestamos = new Prestamo[capacidad];
	}
	
	/** Método para obtener una copia profunda de los préstamos */
	public Prestamo[] get() {
		return copiaProfundaPrestamos();
	}
	
	/** Método para generar una copia profunda de los préstamos */
	private Prestamo[] copiaProfundaPrestamos() {
		Prestamo[] prestamosCopia = new Prestamo[capacidad];
		
		int i = 0;
		while (!tamanoSuperado(i)) {
			prestamosCopia[i] = new Prestamo(coleccionPrestamos[i]);
			i++;
		}
	}
	
	/** Aún no se que hace este método (quizas obtiene una copia profunda a partir de un alumno) */
	public Prestamo[] get(Alumno alumno) {
		
	}
	
	/** */
	public Prestamo[] get(Libro libro) {
		
	}
	
	/** */
	public Prestamo[] get(LocalDate fecha) {
		
	}
	
	/** Método para comprobar si dos fechas pasadas por parámetro, pertenecen al mismo mes y al mismo año */
	private boolean mismoMes(LocalDate fecha1, LocalDate fecha2) {
				
	}

	/** Método para obtener la capacidad */
	public int getCapacidad() {
		return capacidad;
	}
	
	/** Método para obtener el tamaño */
	public int getTamano() {
		return tamano;
	}
	
	/** Método para generar un nuevo préstamo */
	public void prestar(Prestamo prestamo) {
		
	}
	
	/** Método para buscar el índice de un prestamo */
	public int buscarIndice(Prestamo prestamo) {
		
	}
	
	/** Método para comprobar si se supero el tamaño de el array */
	
	
	
}
