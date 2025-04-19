package dev.lucaslowhan.gerenciamento.model;

import java.time.LocalDate;

public class Paciente extends Pessoa{
    private LocalDate dataNascimento;

    public Paciente(String nome, String cpf, String telefone, String email, LocalDate dataNascimento) {
        super(nome, cpf, telefone, email);
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return super.toString() +
                "dataNascimento=" + dataNascimento +
                '}';
    }
}
