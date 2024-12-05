package org.unsam.menu;

import java.time.LocalTime;
import java.util.Scanner;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.unsam.service.*;
import org.unsam.entity.*;

@Component
public class MenuPrueba implements CommandLineRunner {

    @Autowired
    private personaService personaService;
    @Autowired
    private aulaService aulaService;
    @Autowired
    private horarioService horarioService;
    @Autowired
    private asignaturaService asignaturaService;
    @Autowired
    private tipoAulaService tipoAulaService;
    @Autowired
    private tipoPermisoService tipoPermisoService;
    @Autowired
    private carreraService carreraService;
    @Autowired
    private profesorAsignaturaService profesorAsignaturaService;

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú de Prueba ---");
            System.out.println("1. Gestión de Personas");
            System.out.println("2. Gestión de Aulas");
            System.out.println("3. Gestión de Horarios");
            System.out.println("4. Gestión de Asignaturas");
            System.out.println("5. Gestión de Tipos de Aula");
            System.out.println("6. Gestión de Tipos de Permiso");
            System.out.println("7. Gestión de Carreras");
            System.out.println("8. Ver Aulas Ocupadas");
            System.out.println("9. Ver Profesores y sus Asignaturas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    menuPersonas();
                    break;
                case 2:
                    menuAulas();
                    break;
                case 3:
                    menuHorarios();
                    break;
                case 4:
                    menuAsignaturas();
                    break;
                case 5:
                    menuTiposAula();
                    break;
                case 6:
                    menuTiposPermiso();
                    break;
                case 7:
                    menuCarreras();
                    break;
                case 8:
                    verAulasOcupadas();
                    break;
                case 9:
                    verProfesoresAsignaturas();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        System.out.println("¡Hasta luego!");
    }

    private void menuPersonas() {
        System.out.println("\n--- Gestión de Personas ---");
        System.out.println("1. Listar Personas");
        System.out.println("2. Agregar Persona");
        System.out.println("0. Volver");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                listarPersonas();
                break;
            case 2:
                agregarPersona();
                break;
        }
    }

    private void menuAulas() {
        System.out.println("\n--- Gestión de Aulas ---");
        System.out.println("1. Listar Aulas");
        System.out.println("2. Agregar Aula");
        System.out.println("0. Volver");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                listarAulas();
                break;
            case 2:
                agregarAula();
                break;
        }
    }

    private void menuHorarios() {
        System.out.println("\n--- Gestión de Horarios ---");
        System.out.println("1. Listar Horarios");
        System.out.println("2. Agregar Horario");
        System.out.println("0. Volver");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                listarHorarios();
                break;
            case 2:
                agregarHorario();
                break;
        }
    }

    private void menuAsignaturas() {
        System.out.println("\n--- Gestión de Asignaturas ---");
        System.out.println("1. Listar Asignaturas");
        System.out.println("2. Agregar Asignatura");
        System.out.println("0. Volver");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                listarAsignaturas();
                break;
            case 2:
                agregarAsignatura();
                break;
        }
    }

    private void menuTiposAula() {
        System.out.println("\n--- Gestión de Tipos de Aula ---");
        System.out.println("1. Listar Tipos de Aula");
        System.out.println("2. Agregar Tipo de Aula");
        System.out.println("0. Volver");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                listarTiposAula();
                break;
            case 2:
                agregarTipoAula();
                break;
        }
    }

    private void menuTiposPermiso() {
        System.out.println("\n--- Gestión de Tipos de Permiso ---");
        System.out.println("1. Listar Tipos de Permiso");
        System.out.println("2. Agregar Tipo de Permiso");
        System.out.println("0. Volver");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                listarTiposPermiso();
                break;
            case 2:
                agregarTipoPermiso();
                break;
        }
    }

    private void menuCarreras() {
        System.out.println("\n--- Gestión de Carreras ---");
        System.out.println("1. Listar Carreras");
        System.out.println("2. Agregar Carrera");
        System.out.println("0. Volver");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                listarCarreras();
                break;
            case 2:
                agregarCarrera();
                break;
        }
    }

private void listarPersonas() {
    System.out.println("\nListado de Personas:");
    personaService.listarPersonas().forEach(p -> {
        System.out.println(p.getId() + ": " + p.getNombre() + " " + p.getApellido() + " - Rol: " + p.getRol());
    });
}

private void agregarPersona() {
    System.out.println("\nAgregar nueva Persona:");
    
    // Preguntar por el nombre
    System.out.print("Nombre: ");
    String nombre = scanner.nextLine();
    
    // Preguntar por el apellido
    System.out.print("Apellido: ");
    String apellido = scanner.nextLine();
    
    // Preguntar por el email
    System.out.print("Email: ");
    String email = scanner.nextLine();

    // Preguntar por el nombre de usuario
    System.out.print("Nombre de usuario: ");
    String nombreUsuario = scanner.nextLine();

    // Preguntar por la contraseña
    System.out.print("Contraseña: ");
    String contrasena = scanner.nextLine(); // En una aplicación real, deberías manejar la contraseña de forma segura

    // Listar tipos de permiso
    System.out.println("\n--- Tipos de Permiso ---");
    tipoPermisoService.listarTiposPermiso().forEach(tp -> 
        System.out.println(tp.getId() + ": " + tp.getNombre()));

    // Preguntar al usuario por el ID del tipo de permiso
    System.out.print("Seleccione el ID del tipo de permiso: ");
    Long tipoPermisoId = scanner.nextLong();
    scanner.nextLine(); // Consumir el salto de línea

    // Crear una nueva instancia de persona
    persona nuevaPersona = new persona();
    nuevaPersona.setNombre(nombre);
    nuevaPersona.setApellido(apellido);
    nuevaPersona.setEmail(email); // Establecer el email
    nuevaPersona.setUsername(nombreUsuario); // Establecer el nombre de usuario
    nuevaPersona.setPassword(contrasena); // Establecer la contraseña
    nuevaPersona.setTipoPermisoId(tipoPermisoId); // Establecer el tipo de permiso

    // Guardar la nueva persona usando el servicio
    personaService.guardarPersona(nuevaPersona);
    System.out.println("Persona agregada con éxito.");
}

    private void listarAulas() {
        System.out.println("\nListado de Aulas:");
        aulaService.listarAulas().forEach(a -> 
            System.out.println(a.getId() + ": " + a.getNombre()));
    }

    private void agregarAula() {
        System.out.println("\nAgregar nueva Aula:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        aula nuevaAula = new aula();
        nuevaAula.setNombre(nombre);
        aulaService.guardarAula(nuevaAula);
        System.out.println("Aula agregada con éxito.");
    }

    private void listarHorarios() {
        System.out.println("\nListado de Horarios:");
        horarioService.listarHorarios().forEach(h -> 
            System.out.println(h.getId() + ": " + h.getDia() + " - " + h.getHoraInicio() + " - " + h.getHoraFin()));
    }

private void agregarHorario() {
    System.out.println("\nAgregar nuevo Horario:");
    System.out.print("Día: ");
    String dia = scanner.nextLine();
    System.out.print("Hora Inicio (formato HH:mm): ");
    String horaInicioStr = scanner.nextLine();
    System.out.print("Hora Fin (formato HH:mm): ");
    String horaFinStr = scanner.nextLine();

    LocalTime horaInicio = LocalTime.parse(horaInicioStr);
    LocalTime horaFin = LocalTime.parse(horaFinStr);

    horario nuevoHorario = new horario();
    nuevoHorario.setDia(dia);
    nuevoHorario.setHoraInicio(horaInicio);
    nuevoHorario.setHoraFin(horaFin);
    
    try {
        horarioService.guardarHorario(nuevoHorario);
        System.out.println("Horario agregado con éxito.");
    } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage()); // Muestra el mensaje de error
    }
}

    private void listarAsignaturas() {
        System.out.println("\nListado de Asignaturas:");
        asignaturaService.listarAsignaturas().forEach(a -> 
            System.out.println(a.getId() + ": " + a.getNombre() + " (" + a.getCodigo() + ")"));
    }

    private void agregarAsignatura() {
        System.out.println("\nAgregar nueva Asignatura:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        asignatura nuevaAsignatura = new asignatura();
        nuevaAsignatura.setNombre(nombre);
        nuevaAsignatura.setCodigo(codigo);
        asignaturaService.guardarAsignatura(nuevaAsignatura);
        System.out.println("Asignatura agregada con éxito.");
    }

    private void listarTiposAula() {
        System.out.println("\nListado de Tipos de Aula:");
        tipoAulaService.listarTiposAula().forEach(ta -> 
            System.out.println(ta.getId() + ": " + ta.getNombre()));
    }

    private void agregarTipoAula() {
        System.out.println("\nAgregar nuevo Tipo de Aula:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        tipoAula nuevoTipoAula = new tipoAula();
        nuevoTipoAula.setNombre(nombre);
        tipoAulaService.guardarTipoAula(nuevoTipoAula);
        System.out.println("Tipo de Aula agregado con éxito.");
    }

    private void listarTiposPermiso() {
        System.out.println("\nListado de Tipos de Permiso:");
        tipoPermisoService.listarTiposPermiso().forEach(tp -> 
            System.out.println(tp.getId() + ": " + tp.getNombre()));
    }

    private void agregarTipoPermiso() {
        System.out.println("\nAgregar nuevo Tipo de Permiso:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        tipoPermiso nuevoTipoPermiso = new tipoPermiso();
        nuevoTipoPermiso.setNombre(nombre);
        tipoPermisoService.guardarTipoPermiso(nuevoTipoPermiso);
        System.out.println("Tipo de Permiso agregado con éxito.");
    }

    private void listarCarreras() {
        System.out.println("\nListado de Carreras:");
        carreraService.listarCarreras().forEach(c -> 
            System.out.println(c.getId() + ": " + c.getNombre()));
    }

    private void agregarCarrera() {
        System.out.println("\nAgregar nueva Carrera:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        carrera nuevaCarrera = new carrera();
        nuevaCarrera.setNombre(nombre);
        carreraService.guardarCarrera(nuevaCarrera);
        System.out.println("Carrera agregada con éxito.");
    }

    private void verAulasOcupadas() {
        System.out.println("\nA ulas Ocupadas:");
        List<horario> horariosActuales = horarioService.listarHorarios();
        horariosActuales.forEach(h -> {
            aula aulaOcupada = aulaService.obtenerAulaPorId(h.getAulaId()).orElse(null);
            if (aulaOcupada != null) {
                System.out.println("Aula: " + aulaOcupada.getNombre() + 
                                 " - Día: " + h.getDia() + 
                                 " - Horario: " + h.getHoraInicio() + " - " + h.getHoraFin());
            }
        });
    }

    private void verProfesoresAsignaturas() {
        System.out.println("\nProfesores y sus Asignaturas:");
        profesorAsignaturaService.listarProfesoresAsignaturas().forEach(pa -> {
            persona profesor = personaService.obtenerPersonaPorId(pa.getProfesorId()).orElse(null);
            asignatura asignatura = asignaturaService.obtenerAsignaturaPorId(pa.getAsignaturaId()).orElse(null);
            if (profesor != null && asignatura != null) {
                System.out.println("Profesor: " + profesor.getNombre() + " " + profesor.getApellido() + 
                                 " - Asignatura: " + asignatura.getNombre());
            }
        });
    }
}