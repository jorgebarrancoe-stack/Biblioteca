package biblioteca;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Creamos la biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // 1. Crear libros
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, "111");
        Libro libro2 = new Libro("El Quijote", "Miguel de Cervantes", 1605, "222");
        Libro libro3 = new Libro("1984", "George Orwell", 1949, "333");
        Libro libro4 = new Libro("Rayuela", "Julio Cortázar", 1963, "444");

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);

        System.out.println("Libros en la biblioteca:");
        System.out.println(libro1);
        System.out.println(libro2);
        System.out.println(libro3);
        System.out.println(libro4);

        // 2. Crear usuarios
        Usuario jesu = new Usuario("Jesu", "1001");
        Usuario laura = new Usuario("Laura", "1002");

        biblioteca.registrarUsuario(jesu);
        biblioteca.registrarUsuario(laura);

        System.out.println("");
        System.out.println("Usuarios registrados:");
        System.out.println(jesu);
        System.out.println(laura);

        // 3. Jesu presta un libro (esto debe funcionar)
        System.out.println("");
        boolean resultado1 = jesu.solicitarPrestamo(libro1);
        System.out.println("Jesu pide prestado: Cien años de soledad");
        if (resultado1) {
            System.out.println("Préstamo realizado con éxito.");
        } else {
            System.out.println("No se pudo realizar el préstamo.");
        }

        // 4. Laura intenta pedir el MISMO libro (esto debe fallar)
        boolean resultado2 = laura.solicitarPrestamo(libro1);
        System.out.println("");
        System.out.println("Laura pide prestado el mismo libro (ya prestado a Jesu)");
        if (resultado2) {
            System.out.println("Préstamo realizado con éxito.");
        } else {
            System.out.println("No se pudo prestar: el libro ya está prestado.");
        }

        // 5. Laura pide 3 libros distintos (deben funcionar)
        boolean resultado3 = laura.solicitarPrestamo(libro2);
        System.out.println("");
        System.out.println("Laura pide prestado: El Quijote");
        if (resultado3) {
            System.out.println("Préstamo realizado con éxito.");
        } else {
            System.out.println("No se pudo realizar el préstamo.");
        }

        boolean resultado4 = laura.solicitarPrestamo(libro3);
        System.out.println("Laura pide prestado: 1984");
        if (resultado4) {
            System.out.println("Préstamo realizado con éxito.");
        } else {
            System.out.println("No se pudo realizar el préstamo.");
        }

        boolean resultado5 = laura.solicitarPrestamo(libro4);
        System.out.println("Laura pide prestado: Rayuela");
        if (resultado5) {
            System.out.println("Préstamo realizado con éxito.");
        } else {
            System.out.println("No se pudo realizar el préstamo.");
        }

        // 6. Laura ya tiene 3 libros, intenta pedir un cuarto (esto debe fallar)
        Libro libro5 = new Libro("Fahrenheit 451", "Ray Bradbury", 1953, "555");
        biblioteca.agregarLibro(libro5);

        boolean resultado6 = laura.solicitarPrestamo(libro5);
        System.out.println("");
        System.out.println("Laura ya tiene 3 libros, intenta pedir un 4to: Fahrenheit 451");
        if (resultado6) {
            System.out.println("Préstamo realizado con éxito.");
        } else {
            System.out.println("No se pudo prestar: ya alcanzó el máximo de 3 libros.");
        }

        // 7. Mostrar cuántos libros tiene Laura
        System.out.println("");
        System.out.println(laura);

        // 8. Jesu devuelve su libro
        System.out.println("");
        boolean devuelto = jesu.devolverLibro(libro1);
        if (devuelto) {
            System.out.println("Jesu devolvió el libro: Cien años de soledad");
        } else {
            System.out.println("No se pudo devolver el libro.");
        }
        System.out.println(libro1);

        // 9. Registrar el préstamo con fecha (clase Prestamo)
        Prestamo prestamo1 = new Prestamo(libro2, laura, LocalDate.now());
        System.out.println("");
        System.out.println("Registro del préstamo:");
        System.out.println(prestamo1);
    }
}