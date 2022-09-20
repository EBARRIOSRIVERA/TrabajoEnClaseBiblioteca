package BibliotecaDos.PrestamosDos.Repositorio;

import BibliotecaDos.PrestamosDos.Entidades.Estudiante;
import BibliotecaDos.PrestamosDos.Entidades.Prestamos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface repositorioPrestamo extends JpaRepository<Prestamos, Integer> {

    ArrayList<Prestamos> findByEstudiante(Estudiante estudiante);

}
