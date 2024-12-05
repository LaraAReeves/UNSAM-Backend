package org.unsam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.unsam.service.tipoPermisoService;

@Entity
@Table(name = "Personas")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String email;
    
    @Column(name = "tipo_permiso_id") // Campo para el tipo de permiso
    private Long tipoPermisoId;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;
    
    public Long getId() {
        return id;
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setNombre(String newNombre) {
         this.nombre = newNombre;
    }

    public void setApellido(String newApellido) {
        this.apellido = newApellido;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    // Servicio para acceder a los tipos de permiso
    @Autowired
    private tipoPermisoService tipoPermisoService;
    
    // Método para obtener el nombre del rol basado en el tipo de permiso
    public String getRol() {
        if (tipoPermisoId != null) {
            Optional<tipoPermiso> tipoPermisoOptional = tipoPermisoService.obtenerTipoPermisoPorId(tipoPermisoId);
            if (tipoPermisoOptional.isPresent()) {
                return tipoPermisoOptional.get().getNombre(); // Retorna el nombre del rol
            }
        }
        return "Rol no asignado"; // Retorna un mensaje si no hay rol asignado
    }
    
    // Método para establecer el tipo de permiso
    public void setTipoPermisoId(Long tipoPermisoId) {
        this.tipoPermisoId = tipoPermisoId;

        // Obtener el tipo de permiso desde la base de datos
        Optional<tipoPermiso> tipoPermisoOptional = tipoPermisoService.obtenerTipoPermisoPorId(tipoPermisoId);
        if (tipoPermisoOptional.isPresent()) {
            // Si se encuentra el tipo de permiso, se puede realizar alguna acción
            String nombrePermiso = tipoPermisoOptional.get().getNombre();
            System.out.println("Rol asignado: " + nombrePermiso);
        } else {
            System.out.println("Tipo de permiso no encontrado");
        }
    }
}

