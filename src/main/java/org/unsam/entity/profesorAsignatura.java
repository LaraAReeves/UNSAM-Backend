package org.unsam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Profesores_Asignaturas")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class profesorAsignatura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "persona_id")
    private Long personaId;

    @Column(name = "asignatura_id")
    private Long asignaturaId;

    // Relaciones opcionales si quieres cargar los objetos relacionados
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id", insertable = false, updatable = false)
    private persona profesor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asignatura_id", insertable = false, updatable = false)
    private asignatura asignatura;
    
    public Long getPersonaId() {
        return personaId;
    }

    public Long getAsignaturaId() {
        return asignaturaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    public void setAsignaturaId(Long asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public Long getProfesorId() {
        return this.personaId;  // Retorna personaId ya que representa el ID del profesor
    }
}