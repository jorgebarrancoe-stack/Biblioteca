package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private static final int MAX_LIBROS_PRESTADOS = 3;

    private String nombre;
    private String identificacion;
    private List<Libro> librosPrestados;

    public Usuario(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.librosPrestados = new ArrayList<>();
    }

    // Pide prestado un libro. Falla si el libro no está disponible
    // o si el usuario ya tiene 3 libros prestados.
    public boolean solicitarPrestamo(Libro libro) {
        if (librosPrestados.size() >= MAX_LIBROS_PRESTADOS) {
            return false;
        }
        if (libro.prestar()) {
            librosPrestados.add(libro);
            return true;
        }
        return false;
    }

    public boolean devolverLibro(Libro libro) {
        if (librosPrestados.contains(libro)) {
            libro.devolver();
            librosPrestados.remove(libro);
            return true;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public int cantidadLibrosPrestados() {
        return librosPrestados.size();
    }

    @Override
    public String toString() {
        return nombre + " (" + identificacion + ") - " + cantidadLibrosPrestados() + " libro(s) prestado(s)";
    }
}
