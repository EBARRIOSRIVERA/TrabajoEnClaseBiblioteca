package BibliotecaDos.PrestamosDos.Servicios;

import BibliotecaDos.PrestamosDos.Entidades.Libro;
import BibliotecaDos.PrestamosDos.Repositorio.repositorioLibro;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@Service
public class servicioLibro {
    private repositorioLibro repositorio;

    public servicioLibro (repositorioLibro repositorio) {

        this.repositorio = repositorio;
    }
    public ArrayList<Libro> listaLibros() { //Consultar Todos

        return (ArrayList<Libro>) repositorio.findAll();
    }
    public Optional<Libro> buscaLibro(String isbn) { //Consultar Libro Por Id
        return repositorio.findById(isbn);
    }

    public ArrayList<Libro> buscaLibroAutor(String autor) { //Buscar Libro Por Autor
        return repositorio.findByAutor(autor);

    }
    public String agregaLibro(Libro libro) {
        if (!buscaLibro(libro.getIsbn()).isPresent()) {
            repositorio.save(libro);
            return "Libro Registrado exitosamente.";
        } else {
            return "El libro ya existe.";
        }
    }
    public String actualizaLibro(Libro libro) {
        if (!buscaLibro(libro.getIsbn()).isPresent()) {
            repositorio.save(libro);
            return "LIbro Actualizado Exitosamente";
        } else {
            return "El Libro No Existe";
        }
    }
    public String actualizaEditorial(String isbn, String editorial) {
        if (!buscaLibro(isbn).isPresent()) {
                Libro libro1 = repositorio.findById(isbn).get();
                libro1.setEditorial(editorial);
                repositorio.save(libro1);
                return "Editorial Actualizada";
        } else {
                return "Libro A Actualizar No Existe";
        }
    }
    public String eliminaLibro(String isbn) {
        if (!buscaLibro(isbn).isPresent()) {
            repositorio.deleteById(isbn);
            return "Libro Eliminado";
        } else {
            return "El Libro a eliminar no existe";
        }
    }
    public Libro actualizaCampo(String isbn, Map<Object,Object> libroMap){
        Libro libro=repositorio.findById(isbn).get();

        libroMap.forEach((key,value)->{
                Field campo= ReflectionUtils.findField(Libro.class, (String) key);
                campo.setAccessible(true);
                ReflectionUtils.setField(campo, libro, value);
        });
        return repositorio.save(libro);
    }
}
