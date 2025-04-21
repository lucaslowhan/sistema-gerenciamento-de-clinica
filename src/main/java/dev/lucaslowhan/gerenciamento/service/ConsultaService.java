package dev.lucaslowhan.gerenciamento.service;

import dev.lucaslowhan.gerenciamento.model.Consulta;
import dev.lucaslowhan.gerenciamento.model.Medico;
import dev.lucaslowhan.gerenciamento.model.Paciente;
import dev.lucaslowhan.gerenciamento.repository.ConsultaRepository;
import dev.lucaslowhan.gerenciamento.repository.MedicoRepository;
import dev.lucaslowhan.gerenciamento.repository.PacienteRepository;

import java.time.LocalDateTime;
import java.util.List;

public class ConsultaService {
    private ConsultaRepository consultaRepository;
    private PacienteRepository pacienteRepository;
    private MedicoRepository medicoRepository;
    public ConsultaService(ConsultaRepository consultaRepository, MedicoRepository medicoRepository, PacienteRepository pacienteRepository) {
        this.consultaRepository = consultaRepository;
        this.medicoRepository = medicoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public void agendarConsulta(String cpfPaciente, String crmMedico, String descricao){
        Paciente paciente = pacienteRepository.buscarPorCpf(cpfPaciente);
        Medico medico = medicoRepository.buscarPorCrm(crmMedico);
        if(paciente==null || medico==null){
            System.out.println("Paciente ou medico não encontrado.");
            return;
        }

        Consulta consulta = new Consulta(paciente,medico,descricao);
        consultaRepository.salvar(consulta);
        System.out.println("Consulta agendada.");
    }

    public void cancelarConsulta(Consulta consulta){
        consultaRepository.removerConsulta(consulta);
        System.out.println("Consulta cancelada");
    }

    public List<Consulta> listarConsultasPorPaciente(String cpfPaciente){
        return (List<Consulta>) consultaRepository.buscarPorPaciente(pacienteRepository.buscarPorCpf(cpfPaciente));
    }

    public List<Consulta> listarConsultasPorMedico (String crmMedico){
        return (List<Consulta>) consultaRepository.buscarPorMedico(medicoRepository.buscarPorCrm(crmMedico));
    }

    public List<Consulta> listarTodasConsultas() {
        return consultaRepository.listarTodos();
    }

}
