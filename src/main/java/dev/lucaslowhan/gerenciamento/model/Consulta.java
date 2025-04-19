package dev.lucaslowhan.gerenciamento.model;

import java.time.LocalDateTime;

public class Consulta {
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataHora;
    private String descricao;

    public Consulta(Paciente paciente, Medico medico, String descricao) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora.now();
        this.descricao = descricao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "paciente=" + paciente +
                ", medico=" + medico +
                ", dataHora=" + dataHora +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
