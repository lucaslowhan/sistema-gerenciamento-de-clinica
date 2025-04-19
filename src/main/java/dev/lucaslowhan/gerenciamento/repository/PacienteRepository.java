package dev.lucaslowhan.gerenciamento.repository;

import dev.lucaslowhan.gerenciamento.model.Paciente;

import java.util.List;
import java.util.UUID;

public class PacienteRepository {
    private List<Paciente> pacientes;

    public void salvar(Paciente paciente){
        pacientes.add(paciente);
    }

    public List<Paciente> listarTodos(){
        return pacientes;
    }

    public Paciente buscarPorId(UUID id){
        for(Paciente paciente:pacientes){
            if(paciente.getId().equals(id)){
                return paciente;
            }
        }
        return null;
    }

    public Paciente buscarPorCpf(String cpf){
        for(Paciente paciente:pacientes){
            if(paciente.getCpf().equals(cpf)){
                return paciente;
            }
        }
        return null;
    }

    public void remover(Paciente paciente){
        if(pacientes.contains(paciente)){
            pacientes.remove(paciente);
        }
    }

    public void removerPorCpf(String cpf){
        for(Paciente paciente:pacientes){
            if(paciente.getCpf().equals(cpf)){
                pacientes.remove(paciente);
            }
        }
    }

}
