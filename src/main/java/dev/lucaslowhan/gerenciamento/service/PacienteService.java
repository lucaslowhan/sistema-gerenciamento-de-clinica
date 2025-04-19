package dev.lucaslowhan.gerenciamento.service;

import dev.lucaslowhan.gerenciamento.model.Paciente;
import dev.lucaslowhan.gerenciamento.repository.PacienteRepository;

import java.util.List;
import java.util.UUID;

public class PacienteService {
    private PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public void cadastrarPaciente(Paciente paciente){
        if(pacienteRepository.buscarPorCpf(paciente.getCpf()) != null){
            System.out.println("Já existe um paciente com esse CPF");
            return;
        }
        pacienteRepository.salvar(paciente);
    }

    public List<Paciente> listarPacientes(){
        return pacienteRepository.listarTodos();
    }

    public Paciente buscarPorId(UUID id){
        return pacienteRepository.buscarPorId(id);
    }

    public Paciente buscarPacientePorCpf(String cpf){
        return pacienteRepository.buscarPorCpf(cpf);
    }

    public void remover(Paciente paciente){
        pacienteRepository.remover(paciente);
    }

    public void removerPorCpf(String cpf){
        Paciente paciente = pacienteRepository.buscarPorCpf(cpf);
        if(paciente == null){
            System.out.println("Paciente não encontrado.");
            return;
        }
        pacienteRepository.removerPorCpf(cpf);
    }
}
