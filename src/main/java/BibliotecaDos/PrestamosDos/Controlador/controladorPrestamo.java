package BibliotecaDos.PrestamosDos.Controlador;

import BibliotecaDos.PrestamosDos.Entidades.Prestamos;
import BibliotecaDos.PrestamosDos.Servicios.servicioPrestamo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class controladorPrestamo {

    servicioPrestamo servicio;

    public controladorPrestamo(servicioPrestamo servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/AgregaPrestamo/{isbn}/{doc}")
    public Prestamos agregaPrestamo(@PathVariable("isbn") String isbn, @PathVariable("doc") String doc,
                                    @RequestBody Prestamos prestamos){
        return servicio.agregaPrestamo(isbn, doc, prestamos);
    }

    @GetMapping("/PorEstudiante/{doc}")
    public ArrayList<Prestamos> porEstudiante(@PathVariable("doc")String doc){
        return servicio.porEstudiante(doc);
    }
}
