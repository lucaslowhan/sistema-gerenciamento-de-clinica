package dev.lucaslowhan.gerenciamento.test;

import dev.lucaslowhan.gerenciamento.model.Consulta;
import dev.lucaslowhan.gerenciamento.model.Medico;
import dev.lucaslowhan.gerenciamento.model.Paciente;
import dev.lucaslowhan.gerenciamento.repository.ConsultaRepository;
import dev.lucaslowhan.gerenciamento.repository.MedicoRepository;
import dev.lucaslowhan.gerenciamento.repository.PacienteRepository;
import dev.lucaslowhan.gerenciamento.service.ConsultaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConsultaServiceTest {
    private ConsultaService consultaService;

    @BeforeEach
    public void setUp(){
        PacienteRepository pacienteRepository = new PacienteRepository();
        MedicoRepository medicoRepository = new MedicoRepository();
        ConsultaRepository consultaRepository = new ConsultaRepository();

        pacienteRepository.salvar(new Paciente("Lucas","11111111111","88888888","testepaciente@teste.com",03032020));
        medicoRepository.salvar(new Medico("João","12312312312","88899965","testemedico@medico.com","Cardiologista","12312"));

        consultaService = new ConsultaService(consultaRepository,medicoRepository,pacienteRepository);
    }

    @Test
    public void deveAgendarConsulta(){
        consultaService.agendarConsulta("11111111111","12312","Rotina");

        List<Consulta>consultas = consultaService.listarConsultasPorPaciente("11111111111");
        assertEquals(1,consultas.size());
        assertEquals("Rotina",consultas.get(0).getDescricao());
    }

    @Test
    public void deveCancelarConsulta(){
        consultaService.agendarConsulta("11111111111","12312","Cancelavel");

        Consulta consulta = consultaService.listarConsultasPorPaciente("11111111111").get(0);
        consultaService.cancelarConsulta(consulta);

        List<Consulta> consultas = consultaService.listarConsultasPorPaciente("11111111111");
        assertEquals(0,consultas.size());
    }
}
