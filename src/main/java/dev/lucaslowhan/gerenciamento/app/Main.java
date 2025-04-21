package dev.lucaslowhan.gerenciamento.app;

import dev.lucaslowhan.gerenciamento.model.Medico;
import dev.lucaslowhan.gerenciamento.model.Paciente;
import dev.lucaslowhan.gerenciamento.repository.ConsultaRepository;
import dev.lucaslowhan.gerenciamento.repository.MedicoRepository;
import dev.lucaslowhan.gerenciamento.repository.PacienteRepository;
import dev.lucaslowhan.gerenciamento.service.ConsultaService;
import dev.lucaslowhan.gerenciamento.service.MedicoService;
import dev.lucaslowhan.gerenciamento.service.PacienteService;

public class Main {
    public static void main(String[] args) {

        MedicoRepository medicoRepository = new MedicoRepository();
        PacienteRepository pacienteRepository = new PacienteRepository();
        ConsultaRepository consultaRepository = new ConsultaRepository();

        MedicoService medicoService = new MedicoService(medicoRepository);
        PacienteService pacienteService = new PacienteService(pacienteRepository);
        ConsultaService consultaService = new ConsultaService(consultaRepository,medicoRepository,pacienteRepository);

        medicoService.cadastrarMedico(new Medico("Lucas","000000000",
                "88888888","teste@teste.com","Otorrino","12312"));
        pacienteService.cadastrarPaciente(new Paciente("Lowhan","11111111111",
                "89689657","teste02@teste.com",03/12/1993));
        consultaService.agendarConsulta("11111111111","12312","Consulta Otorrino");

    }
}
