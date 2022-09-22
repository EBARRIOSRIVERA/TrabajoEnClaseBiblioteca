package BibliotecaDos.PrestamosDos.Controlador;

import BibliotecaDos.PrestamosDos.Entidades.Libro;
import BibliotecaDos.PrestamosDos.Servicios.servicioLibro;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class controladorLibro {
    private servicioLibro servicio;

    public controladorLibro(servicioLibro servicio) {

        this.servicio = servicio;
    }
    @GetMapping("/ListaLibros")
    public List<Libro> listar() {

        return servicio.listaLibros();
    }
    @GetMapping("/BuscaLibro/{id}")
    public Optional<Libro> buscaLibro(@PathVariable("id") String isbn){

        return servicio.buscaLibro(isbn);
    }
    @GetMapping("/BuscaLibroAutor/{autor}")
    public ArrayList<Libro> buscaLibroAutor(@PathVariable("autor") String autor){
        return servicio.buscaLibroAutor(autor);
    }
    @PostMapping("/AgregaLibro")
    public String agregaLibro(@RequestBody Libro libro){

        return servicio.agregaLibro(libro);
    }
    @PutMapping("/ActualizaLibro")
    public String actualizaLibro(@RequestBody Libro libro){

        return servicio.actualizaLibro(libro);
    }
    @PatchMapping("/ActualizaEdit/{isbn}/{edit}")
    public String actualizaEdit(@PathVariable("isbn") String isbn, @PathVariable("edit") String editorial){
        return servicio.actualizaEditorial(isbn, editorial);
    }
    @PatchMapping("/ActualizaCampo/{isbn}")
    public Libro actualizaCampo(@PathVariable("isbn")String isbn, @RequestBody Map<Object,Object> libroMap){
        return servicio.actualizaCampo(isbn, libroMap);
    }
    @DeleteMapping("/EliminaLibro/{id}")
    public String eliminaLibro(@PathVariable("id") String isbn){

        return servicio.eliminaLibro(isbn);
    }

}
