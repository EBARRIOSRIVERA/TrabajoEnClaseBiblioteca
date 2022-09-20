package BibliotecaDos.PrestamosDos.Servicios;

import BibliotecaDos.PrestamosDos.Entidades.Prestamos;
import BibliotecaDos.PrestamosDos.Repositorio.repositorioEstudiante;
import BibliotecaDos.PrestamosDos.Repositorio.repositorioLibro;
import BibliotecaDos.PrestamosDos.Repositorio.repositorioPrestamo;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;


@Service
public class servicioPrestamo {

    private repositorioPrestamo pRepo;
    private repositorioLibro libRepo;
    private repositorioEstudiante estRepo;

    public servicioPrestamo(repositorioPrestamo pRepo, repositorioLibro libRepo, repositorioEstudiante estRepo) {
        this.pRepo = pRepo;
        this.libRepo = libRepo;
        this.estRepo = estRepo;
    }

    public Prestamos agregaPrestamo(String isbn, String doc, Prestamos prestamos){
        libRepo.findById(isbn).map(libro -> {
            prestamos.setLibro(libro);
            return libro;
        });
        return estRepo.findById(doc).map(est -> {
            prestamos.setEstudiante(est);
            return pRepo.save(prestamos);
        }).get();

    }
    public ArrayList<Prestamos> porEstudiante(String doc){

        try {
            return estRepo.findById(doc).map(est -> {
                return pRepo.findByEstudiante(est);
            }).get();
        }catch (Exception ex){
            System.out.println("Error: "+ex);
        }
        return null;
    }
}
