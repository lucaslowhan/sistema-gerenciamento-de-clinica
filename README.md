# 🏥 Sistema de Gerenciamento de Clínica

Projeto desenvolvido em **Java puro**, com o objetivo de praticar os conceitos de programação orientada a objetos, organização em camadas, boas práticas e testes automatizados com JUnit. O sistema simula o gerenciamento básico de uma clínica médica, incluindo **pacientes**, **médicos** e **consultas**.

---

## 🚀 Funcionalidades

- ✅ Cadastro de pacientes e médicos
- ✅ Agendamento de consultas com descrição
- ✅ Listagem de todas as consultas
- ✅ Listagem de consultas por paciente
- ✅ Busca e validação por CPF/CRM
- ✅ Remoção de pacientes e médicos
- ✅ Testes com JUnit

---

## 🧠 Conceitos aplicados

- Programação Orientada a Objetos (POO)
- Encapsulamento, Herança e Polimorfismo
- Separação por camadas: `model`, `repository`, `service`, `app`
- Boas práticas com uso de `List`, validações e estruturas de controle
- Testes de unidade com JUnit 5
- Organização de projeto com Maven

---

## 📁 Estrutura de Diretórios

``` bash
sistema-gerenciamento-de-clinica/ 
├── src/ 
│ ├── main/ 
│ │ └── java/ 
│ │ └── dev/lucaslowhan/gerenciamento/ 
│ │ │ ├── app/ # Classe Main (execução) 
│ │ │ ├── model/ # Entidades: Paciente, Medico, Consulta 
│ │ │ ├── repository/ # Acesso e persistência em memória 
│ │ │ └── service/ # Regras de negócio 
├── test/ 
│ └── java/ 
│ │ └── dev/lucaslowhan/gerenciamento/test/ 
│ │ └── TesteSistemaTest.java # Testes JUnit
```

---

## 🧪 Testes com JUnit

O projeto possui testes automatizados para validar as funcionalidades principais:

- Cadastro de paciente e médico
- Agendamento de consulta
- Prevenção de duplicatas (CPF e CRM)
- Listagem de consultas
- Remoção de registros

### ✅ Exemplo de teste:

``` java
@Test
public void deveCadastrarPacienteComSucesso() {
    Paciente paciente = new Paciente("João Silva", "123.456.789-00");
    pacienteService.cadastrarPaciente(paciente);

    Paciente resultado = pacienteRepository.buscarPacientePorCpf("123.456.789-00");
    assertNotNull(resultado);
    assertEquals("João Silva", resultado.getNome());
}
```

### 🧪 Como rodar os testes
``` bash
mvn test
```
---

## 🛠️ Como executar o projeto
### 📦 Requisitos
- Java 17+
- Maven instalado
### ▶️ Passos para rodar:
``` bash
# Clone o repositório
git clone https://github.com/lucaslowhan/sistema-gerenciamento-de-clinica.git

# Acesse o diretório
cd sistema-gerenciamento-de-clinica

# Compile o projeto
mvn compile

# Execute a aplicação principal
mvn exec:java -Dexec.mainClass="dev.lucaslowhan.gerenciamento.app.Main"

# Rode os testes
mvn test
```
---
## ✍️ Autor
### Lucas Lowhan
Estudante de Engenharia de Software, apaixonado por desenvolvimento back-end e boas práticas de programação.
#### [GitHub](https://github.com/lucaslowhan/) || [LinkedIn](https://www.linkedin.com/in/lucaslowhan/)