package dev.lucaslowhan.gerenciamento.repository;

import dev.lucaslowhan.gerenciamento.model.Paciente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class PacienteRepository {
    private List<Paciente> pacientes;

    public PacienteRepository(){
        this.pacientes = new ArrayList<>();
    }

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
        if (cpf == null || cpf.isEmpty()) return null;
        for(Paciente paciente:pacientes){
            if(cpf.equals(paciente.getCpf())){
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

    public void removerPorCpf(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            System.out.println("CPF inválido.");
            return;
        }

        Iterator<Paciente> iterator = pacientes.iterator();
        while (iterator.hasNext()) {
            Paciente paciente = iterator.next();
            if (cpf.equals(paciente.getCpf())) {
                iterator.remove(); // <- forma segura de remover enquanto itera
                System.out.println("Paciente removido com sucesso.");
                return;
            }
        }

        System.out.println("Paciente com CPF " + cpf + " não encontrado.");
    }

}
