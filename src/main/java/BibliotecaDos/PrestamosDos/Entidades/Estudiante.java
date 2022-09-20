package BibliotecaDos.PrestamosDos.Entidades;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Estudiante")
public class Estudiante {

    @Id
    @Column(unique = true,length = 30)
    private String documento;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String apellido;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false)
    private String telefono;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Prestamos> prestamo;

    public Estudiante() {
    }

    public Estudiante(String documento, String nombre, String apellido, String email, String telefono, Set<Prestamos> prestamo) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.prestamo = prestamo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<Prestamos> getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Set<Prestamos> prestamo) {
        this.prestamo = prestamo;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", prestamo=" + prestamo +
                '}';
    }
}
