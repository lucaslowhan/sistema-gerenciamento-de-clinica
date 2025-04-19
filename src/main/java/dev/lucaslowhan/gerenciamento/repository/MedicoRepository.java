package dev.lucaslowhan.gerenciamento.repository;

import dev.lucaslowhan.gerenciamento.model.Medico;
import dev.lucaslowhan.gerenciamento.model.Paciente;

import java.util.List;
import java.util.UUID;

public class MedicoRepository {
    private List<Medico> medicos;

    public void salvar(Medico medico){
        medicos.add(medico);
    }

    public List<Medico> listarTodos(){
        return medicos;
    }

    public Medico buscarPorId(UUID id){
        for(Medico medico:medicos){
            if(medico.getId().equals(id)){
                return medico;
            }
        }
        return null;
    }

    public Medico buscarPorCpf(String cpf){
        for(Medico medico:medicos){
            if(medico.getCpf().equals(cpf)){
                return medico;
            }
        }
        return null;
    }

    public void remover(Medico medico){
        if(medicos.contains(medico)){
            medicos.remove(medico);
        }
    }

    public void removerPorCpf(String cpf){
        for(Medico medico:medicos){
            if(medico.getCpf().equals(cpf)){
                medicos.remove(medico);
            }
        }
    }
}
