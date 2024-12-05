package org.unsam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "Reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aula_id")
    private aula aula;

    @ManyToOne
    @JoinColumn(name = "horario_id")
    private horario horario;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private persona profesor;

    @Column(name = "fecha")
    private LocalDate fecha;

    // Getters y setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public aula getAula() {
        return aula;
    }
    
    public void setAula(aula aula) {
        this.aula = aula;
    }
    
    public horario getHorario() {
        return horario;
    }
    
    public void setHorario(horario horario) {
        this.horario = horario;
    }
    
    public persona getProfesor() {
        return profesor;
    }
    
    public void setProfesor(persona profesor) {
        this.profesor = profesor;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }
    
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
}