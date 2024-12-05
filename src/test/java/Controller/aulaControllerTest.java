package Controller;
import org.unsam.controller.aulaController;
import org.unsam.service.aulaService;
import org.unsam.entity.aula;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(aulaController.class)
@ExtendWith(MockitoExtension.class)
public class aulaControllerTest {

    @InjectMocks
    private aulaController aulaController;

    @Mock
    private aulaService aulaService;

    private MockMvc mockMvc = MockMvcBuilders.standaloneSetup(aulaController).build();

    @Test
    void listarAulas_exitoso() throws Exception {
        aula aula1 = new aula(1L, "Aula 101", 1L);
        aula aula2 = new aula(2L, "Aula 102", 2L);

        when(aulaService.listarAulas()).thenReturn(Arrays.asList(aula1, aula2));

        mockMvc.perform(get("/aulas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void obtenerAulaPorId_exitoso() throws Exception {
        aula aula = new aula(1L, "Aula 101", 1L);

        when(aulaService.obtenerAulaPorId(anyLong())).thenReturn(Optional.of(aula));

        mockMvc.perform(get("/aulas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Aula 101"));
    }

    @Test
    void obtenerAulaPorId_noEncontrado() throws Exception {
        when(aulaService.obtenerAulaPorId(anyLong())).thenReturn(Optional.empty());

        mockMvc.perform(get("/aulas/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void crearAula_exitoso() throws Exception {
        aula aula = new aula(1L, "Aula 103", 3L);

        when(aulaService.guardarAula(any(aula.class))).thenReturn(aula);

        mockMvc.perform(post("/aulas")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"Aula 103\", \"tipoAulaId\":3}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Aula 103"));
    }

    @Test
    void actualizarAula_exitoso() throws Exception {
        aula aulaActualizada = new aula(1L, "Aula Actualizada", 1L);

        when(aulaService.actualizarAula(anyLong(), any(aula.class))).thenReturn(Optional.of(aulaActualizada));

        mockMvc.perform(put("/aulas/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"Aula Actualizada\", \"tipoAulaId\":1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Aula Actualizada"));
    }

    @Test
    void eliminarAula_exitoso() throws Exception {
        when(aulaService.eliminarAula(anyLong())).thenReturn(true);

        mockMvc.perform(delete("/aulas/1"))
                .andExpect(status().isOk());
    }

    @Test
    void eliminarAula_noEncontrado() throws Exception {
        when(aulaService.eliminarAula(anyLong())).thenReturn(false);

        mockMvc.perform(delete("/aulas/1"))
                .andExpect(status().isNotFound());
    }
}
