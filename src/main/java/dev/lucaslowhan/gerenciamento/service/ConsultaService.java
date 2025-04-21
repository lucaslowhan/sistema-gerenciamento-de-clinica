package dev.lucaslowhan.gerenciamento.service;

import dev.lucaslowhan.gerenciamento.model.Consulta;
import dev.lucaslowhan.gerenciamento.model.Medico;
import dev.lucaslowhan.gerenciamento.model.Paciente;
import dev.lucaslowhan.gerenciamento.repository.ConsultaRepository;
import dev.lucaslowhan.gerenciamento.repository.MedicoRepository;
import dev.lucaslowhan.gerenciamento.repository.PacienteRepository;

import java.time.LocalDateTime;
import java.util.Collections;
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
        if(cpfPaciente == null || cpfPaciente.isEmpty()){
            System.out.println("CPF INVALIDO");
            return Collections.emptyList();
        }
        Paciente paciente = pacienteRepository.buscarPorCpf(cpfPaciente);
        if(paciente==null){
            System.out.println("Paciente não encontrado");
            return Collections.emptyList();
        }

        return consultaRepository.buscarPorPaciente(paciente);
    }

    public List<Consulta> listarConsultasPorMedico (String crmMedico){
        if(crmMedico == null|| crmMedico.isEmpty()){
            System.out.println("CPF INVALIDO");
            return Collections.emptyList();
        }
        Medico medico = medicoRepository.buscarPorCrm(crmMedico);
        if(medico==null){
            System.out.println("Médico não encontrado");
            return Collections.emptyList();
        }
        return consultaRepository.buscarPorMedico(medico);
    }

    public List<Consulta> listarTodasConsultas() {
        return consultaRepository.listarTodos();
    }

}
