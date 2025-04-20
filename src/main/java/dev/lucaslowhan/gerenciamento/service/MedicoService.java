package dev.lucaslowhan.gerenciamento.service;

import dev.lucaslowhan.gerenciamento.model.Medico;
import dev.lucaslowhan.gerenciamento.repository.MedicoRepository;

import java.util.List;
import java.util.UUID;

public class MedicoService {
    private MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public void cadastrarMedico(Medico medico){
        if(medicoRepository.buscarPorCpf(medico.getCpf())!=null){
            System.out.println("Já existe um médico com esse CPF");
            return;
        }
        medicoRepository.salvar(medico);
    }

    public List<Medico> listarMedicos(){
        return medicoRepository.listarTodos();
    }

    public Medico buscarPorId(UUID id){
        return medicoRepository.buscarPorId(id);
    }

    public Medico buscarPorCPF(String cpf){
        return medicoRepository.buscarPorCpf(cpf);
    }

    public void remover(Medico medico){
        medicoRepository.remover(medico);
    }

    public void removerPorCpf(String cpf){
        Medico medico = medicoRepository.buscarPorCpf(cpf);
        if(medico==null){
            System.out.println("Médico não encontrado.");
            return;
        }
        medicoRepository.removerPorCpf(cpf);
    }
}
