package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public boolean registrarUsuario(Usuario usuario) {
        return usuarios.add(usuario);
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public List<Libro> buscarLibrosPorTitulo(String titulo) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro l : libros) {
            if (l.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    public List<Libro> buscarLibrosPorAutor(String autor) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro l : libros) {
            if (l.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    public Libro obtenerLibroPorISBN(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }

    public List<Libro> mostrarLibrosDisponibles() {
        List<Libro> resultado = new ArrayList<>();
        for (Libro l : libros) {
            if (l.estaDisponible()) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    public List<Libro> mostrarTodosLosLibros() {
        return libros;
    }

    public List<Usuario> mostrarUsuarios() {
        return usuarios;
    }

    public Usuario getUsuarioPorId(String identificacion) {
        for (Usuario u : usuarios) {
            if (u.getIdentificacion().equals(identificacion)) {
                return u;
            }
        }
        return null;
    }
}
