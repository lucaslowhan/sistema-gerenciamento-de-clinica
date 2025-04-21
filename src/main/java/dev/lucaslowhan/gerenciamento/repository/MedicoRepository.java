package dev.lucaslowhan.gerenciamento.repository;

import dev.lucaslowhan.gerenciamento.model.Medico;
import dev.lucaslowhan.gerenciamento.model.Paciente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class MedicoRepository {
    private List<Medico> medicos;

    public MedicoRepository(){
        this.medicos = new ArrayList<>();
    }

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

    public Medico buscarPorCpf(String cpf) {
        if (cpf == null || cpf.isEmpty()) return null;

        for (Medico medico : medicos) {
            if (cpf.equals(medico.getCpf())) {
                return medico;
            }
        }
        return null;
    }

    public Medico buscarPorCrm(String crm){
        for(Medico medico:medicos){
            if(medico.getCrm().equals(crm)){
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
        if(cpf == null || cpf.isEmpty()){
            System.out.println("CPF invalido");
            return;
        }

        Iterator<Medico> iterator = medicos.iterator();
        while (iterator.hasNext()){
            Medico medico = iterator.next();
            if(cpf.equals(medico.getCpf())){
                iterator.remove();
                System.out.println("Medico removido com sucesso.");
                return;
            }
        }

        System.out.println("Medico com CPF "+ cpf + " não encontrado.");
    }
}
