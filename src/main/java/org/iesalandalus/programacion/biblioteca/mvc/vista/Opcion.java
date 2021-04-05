package org.iesalandalus.programacion.biblioteca.mvc.vista;

import org.iesalandalus.programacion.biblioteca.mvc.vista.Vista;

public enum Opcion {
	
	INSERTAR_ALUMNO("Insertar alumno") {
		
	},
	
	BUSCAR_ALUMNO("Buscar alumno") {
		
	},
	
	BORRAR_ALUMNO("Borrar alumno") {
		
	},
	
	LISTAR_ALUMNOS("Listar alumnos") {
		
	},
	
	INSERTAR_LIBRO("Insertar libro") {
		
	},
	
	BUSCAR_LIBRO("Buscar libro") {
		
	},
	
	BORRAR_LIBRO("Borrar libro") {
		
	},
	
	LISTAR_LIBROS("Listar libros") {
		
	},
	
	PRESTAR_LIBRO("Prestar libro") {
		
	},
	
	DEVOLVER_LIBRO("Devolver libro") {
		
	},
	
	BUSCAR_PRESTAMO("Buscar préstamo") {
		
	},
	
	BORRAR_PRESTAMO("Borrar préstamo") {
		
	},
	
	LISTAR_PRESTAMOS("Listar préstamos") {
		
	},
	
	LISTAR_PRESTAMOS_ALUMNO("Listar préstamos de un alumno") {
		
	},
	
	LISTAR_PRESTAMOS_LIBRO("Listar préstamos de un libro") {
		
	},
	
	LISTAR_PRESTAMOS_FECHA("Listar préstamos según fecha") {
		
	},
	
	SALIR("Salir") {
		
	};
	
	private String mensaje;
	private Vista vista;
	
	private Opcion(String mensaje) {
		
	}
	
	public abstract void ejecutar();
	
	protected static void setVista(Vista vista) {
		
	}
	
	public static Opcion getOpcionSegunOrdinal(int ordinal) {
		
	}
	
	public static boolean esOrdinalValido(int ordinal) {
		
	}
	
	@Override
	public String toString() {
		
	}
	
}
