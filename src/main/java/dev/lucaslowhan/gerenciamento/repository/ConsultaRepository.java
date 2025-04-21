package dev.lucaslowhan.gerenciamento.repository;

import dev.lucaslowhan.gerenciamento.model.Consulta;
import dev.lucaslowhan.gerenciamento.model.Medico;
import dev.lucaslowhan.gerenciamento.model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class ConsultaRepository {
    private List<Consulta> consultas;

    public ConsultaRepository(){
        consultas = new ArrayList<>();
    }

    public void salvar(Consulta consulta){
        consultas.add(consulta);
    }

    public List<Consulta> listarTodos(){
        return consultas;
    }

    public Consulta buscarPorPaciente(Paciente paciente){
        for(Consulta consulta:consultas){
            if(consulta.getPaciente().equals(paciente)){
                return consulta;
            }
        }
        return null;
    }

    public Consulta buscarPorMedico(Medico medico){
        for(Consulta consulta:consultas){
            if(consulta.getMedico().equals(medico)){
                return consulta;
            }
        }
        return null;
    }

    public void removerConsulta(Consulta consulta){
        if(consultas.contains(consulta)){
            consultas.remove(consulta);
        }
    }
}
