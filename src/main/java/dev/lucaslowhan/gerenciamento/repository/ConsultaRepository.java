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

    public List<Consulta> buscarPorPaciente(Paciente paciente){
        List<Consulta> consultasPacientes = new ArrayList<>();
        for(Consulta consulta:consultas){
            if(consulta.getPaciente().equals(paciente)){
                consultasPacientes.add(consulta);
            }
        }
        return consultasPacientes;
    }

    public List<Consulta> buscarPorMedico(Medico medico){
        List<Consulta> consultasMedicos = new ArrayList<>();
        for(Consulta consulta:consultas){
            if(consulta.getMedico().equals(medico)){
                consultasMedicos.add(consulta);
            }
        }
        return consultasMedicos;
    }

    public void removerConsulta(Consulta consulta){
        if(consultas.contains(consulta)){
            consultas.remove(consulta);
        }
    }
}
