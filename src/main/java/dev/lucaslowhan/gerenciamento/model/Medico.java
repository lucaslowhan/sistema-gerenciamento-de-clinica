package dev.lucaslowhan.gerenciamento.model;

import java.util.Objects;

public class Medico extends Pessoa{
    private String especialidade;
    private String crm;

    public Medico(String nome, String cpf, String telefone, String email, String especialidade, String crm) {
        super(nome, cpf, telefone, email);
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getCrm() {
        return crm;
    }

    @Override
    public String toString() {
        return super.toString() +
                "especialidade='" + especialidade + '\'' +
                ", crm='" + crm + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Medico medico = (Medico) o;
        return Objects.equals(crm, medico.crm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), crm);
    }
}
