package dev.lucaslowhan.gerenciamento.test;

import dev.lucaslowhan.gerenciamento.model.Paciente;
import dev.lucaslowhan.gerenciamento.repository.PacienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.lucaslowhan.gerenciamento.service.PacienteService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class PacienteServiceTest {
    private PacienteService pacienteService;

    @BeforeEach
    public void setUp(){
        PacienteRepository pacienteRepository = new PacienteRepository();
        pacienteService = new PacienteService(pacienteRepository);
    }

    @Test
    public void deveCadastrarPaciente(){
        Paciente paciente = new Paciente("Lucas","123123123","8399999999","teste@teste.com",03/12/1993);
        pacienteService.cadastrarPaciente(paciente);

        Paciente encontrado = pacienteService.buscarPacientePorCpf("123123123");
        assertNotNull(encontrado);
        assertEquals("Lucas",encontrado.getNome());
    }

    @Test
    public void naoDeveCadastrarCpfDuplicado(){
        Paciente paciente1 = new Paciente("Lucas", "123", "99999-9999","teste1@teste.com" , 01/01/2000);
        Paciente paciente2 = new Paciente("Outro", "123", "99999-9999","teste2@teste.com" , 01/01/2000);

        pacienteService.cadastrarPaciente(paciente1);
        pacienteService.cadastrarPaciente(paciente2);

        List<Paciente> lista = pacienteService.listarPacientes();
        assertEquals(1,lista.size());
        assertEquals("Lucas", lista.get(0).getNome());
    }
    @Test
    public void deveRemoverPaciente() {
        Paciente paciente = new Paciente("Lucas", "321", "91111-1111","teste3@teste.com" ,01/01/2001);
        pacienteService.cadastrarPaciente(paciente);
        pacienteService.removerPorCpf("321");

        Paciente resultado = pacienteService.buscarPacientePorCpf("321");
        assertNull(resultado);
    }
}
