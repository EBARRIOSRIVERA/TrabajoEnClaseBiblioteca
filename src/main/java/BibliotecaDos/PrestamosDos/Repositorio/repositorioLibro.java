package BibliotecaDos.PrestamosDos.Repositorio;

import BibliotecaDos.PrestamosDos.Entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface repositorioLibro extends JpaRepository<Libro, String> {

    ArrayList<Libro> findByAutor(String autor);

}
