package BibliotecaDos.PrestamosDos.Repositorio;

import BibliotecaDos.PrestamosDos.Entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repositorioEstudiante extends JpaRepository<Estudiante, String> {

}
