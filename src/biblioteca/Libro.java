package biblioteca;

public class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private String isbn;
    private EstadoLibro estado;

    public Libro(String titulo, String autor, int anioPublicacion, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.isbn = isbn;
        this.estado = EstadoLibro.DISPONIBLE; // al crearlo, siempre está disponible
    }

    // Intenta prestar el libro. Solo funciona si estaba disponible.
    public boolean prestar() {
        if (estado == EstadoLibro.DISPONIBLE) {
            estado = EstadoLibro.PRESTADO;
            return true;
        }
        return false;
    }

    public void devolver() {
        estado = EstadoLibro.DISPONIBLE;
    }

    public boolean estaDisponible() {
        return estado == EstadoLibro.DISPONIBLE;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public EstadoLibro getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + " (" + anioPublicacion + ") [" + estado + "]";
    }
}
