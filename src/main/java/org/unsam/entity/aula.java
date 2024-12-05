package org.unsam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Aulas")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column(name = "tipo_aula_id")
    private Long tipoAulaId;

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTipoAulaId() {
        return tipoAulaId;
    }

    public void setTipoAulaId(Long tipoAulaId) {
        this.tipoAulaId = tipoAulaId;
    }
}