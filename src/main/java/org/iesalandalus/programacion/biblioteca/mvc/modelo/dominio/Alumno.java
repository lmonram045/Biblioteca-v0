package org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio;

public class Alumno {
	// Constantes para almacenar las expresiones regulares de nombre y correo
	static final String ER_NOMBRE = "[a-zA-ZÁÉÍÓÚáéíóú]+[\\s]+[a-zA-ZÁÉÍÓÚáéíóú\\s]*";
	// Expresión regular válida para el 99.9% de los emails según la RFC 5322 (el
	// estándar oficial)
	static final String ER_CORREO = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";

	// Variables para nombre, correo y curso
	private String nombre;
	private String correo;
	private Curso curso;

	// Constructor con parámetros.
	public Alumno(String nombre, String correo, Curso curso) {
		setNombre(nombre);
		setCorreo(correo);
		setCurso(curso);
	}

	// Constructor copia
	public Alumno(Alumno alumno) {
		if (alumno == null) {
			throw new NullPointerException("ERROR: No es posible copiar un alumno nulo.");
		}

		setNombre(alumno.getNombre());
		setCorreo(alumno.getCorreo());
		setCurso(alumno.getCurso());
	}

	// Método para formatear nombre
	private String formateaNombre(String nombre) {
		// primero quito espacios al principio y al final
		nombre = nombre.trim();
		// Buscamos las secuencias de dos o más espacios y las sustituimos por un
		// espacio
		nombre = nombre.replaceAll("\\s{2,}", " ");
		// Divido el nombre en un array para separar por palabras, separado por espacios
		// en blanco
		String[] partesNombre = nombre.split(" ");
		// Vacío el nombre para luego reconstruirlo
		nombre = "";
		// Bucle para recorrer el array partes
		for (String partes : partesNombre) {
			// Por cada parte, pongo en mayúscula la posición 0 y en minúscula las demas, y
			// añado un espacio al final.
			partes = partes.substring(0, 1).toUpperCase() + partes.substring(1).toLowerCase() + " ";
			// Reconstruyo el nombre
			nombre += partes;
		}
		// Devuelvo el nombre borrándole el espacio final que me creó en el bucle
		return nombre.trim();

	}

	// Método para devolver las iniciales de un nombre
	private String getIniciales() {
		// Creo variable para guardar iniciales
		String iniciales = "";
		// pongo el nombre en formato correcto
		String nombreFormateado = formateaNombre(nombre);
		// Creo un array para dividir el nombre
		String[] partesNombre = nombreFormateado.split(" ");
		// Recorro el array para que vaya guardando las iniciales de el nombre.
		for (String partes : partesNombre) {
			iniciales += partes.substring(0, 1);
		}
		return iniciales;
	}

	// Método para devolver un alumno ficticio con nombre y curso válido y correo
	// pasado por parámetro.
	public static Alumno getAlumnoFicticio(String correo) {
		return new Alumno("Waldo Geraldo Faldo", correo, Curso.TERCERO);
	}

	// --------------Inicio de getters y setters---------------------------------
	public Curso getCurso() {
		return curso;
	}

	// Comprueba que el curso no es nulo.
	public void setCurso(Curso curso) {
		if (curso == null) {
			throw new NullPointerException("ERROR: El curso no puede ser nulo.");
		}

		this.curso = curso;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCorreo() {
		return correo;
	}

	// Comprueba que el nombre no sea nulo y que coincida con la expresión regular
	private void setNombre(String nombre) {
		if (nombre == null) {
			throw new NullPointerException("ERROR: El nombre no puede ser nulo.");
		}

		if (!nombre.matches(ER_NOMBRE)) {
			throw new IllegalArgumentException("ERROR: El nombre no tiene un formato válido.");
		}

		this.nombre = formateaNombre(nombre);
	}

	// Comprueba que el correo no sea nulo y que coincida con la expresión regular
	private void setCorreo(String correo) {
		if (correo == null) {
			throw new NullPointerException("ERROR: El correo no puede ser nulo.");
		}

		if (!correo.matches(ER_CORREO)) {
			throw new IllegalArgumentException("ERROR: El formato del correo no es válido.");
		}

		this.correo = correo;
	}
	// ------------------Fin de getters y setters----------------------------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("nombre=%s (%s), correo=%s, curso=%s", formateaNombre(nombre), getIniciales(), correo,
				curso);
	}
}
