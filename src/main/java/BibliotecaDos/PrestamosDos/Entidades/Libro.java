package BibliotecaDos.PrestamosDos.Entidades;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Libro")
public class Libro {
    @Id
    @Column(unique = true, length = 30)
    private String isbn;
    @Column(nullable = false, length = 50)
    private String titulo;
    @Column(nullable = false, length = 50)
    private String editorial;
    @Column(nullable = false, length = 30)
    private String autor;
    @Column(nullable = false)
    private int numPagina;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Prestamos> prestamo;

    public Libro() {
    }

    public Libro(String isbn, String titulo, String editorial, String autor, int numPagina, Set<Prestamos> prestamo) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.editorial = editorial;
        this.autor = autor;
        this.numPagina = numPagina;
        this.prestamo = prestamo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPagina() {
        return numPagina;
    }

    public void setNumPagina(int numPagina) {
        this.numPagina = numPagina;
    }

    public Set<Prestamos> getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Set<Prestamos> prestamo) {
        this.prestamo = prestamo;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", editorial='" + editorial + '\'' +
                ", autor='" + autor + '\'' +
                ", numPagina=" + numPagina +
                ", prestamo=" + prestamo +
                '}';
    }
}
