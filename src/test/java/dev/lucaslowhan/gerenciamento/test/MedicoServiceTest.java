package dev.lucaslowhan.gerenciamento.test;

import dev.lucaslowhan.gerenciamento.model.Medico;
import dev.lucaslowhan.gerenciamento.repository.MedicoRepository;
import dev.lucaslowhan.gerenciamento.service.MedicoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MedicoServiceTest {
    private MedicoService medicoService;

    @BeforeEach
    public void setUp(){
        MedicoRepository medicoRepository = new MedicoRepository();
        medicoService = new MedicoService(medicoRepository);
    }

    @Test
    public void deveCadastrarMedico(){
        Medico medico = new Medico("João", "12312312312","88888888","testedr@teste.com","Cardiologista","12512");
        medicoService.cadastrarMedico(medico);

        Medico encontrado = medicoService.buscarPorCrm("12512");
        assertNotNull(encontrado);
        assertEquals("João", encontrado.getNome());
    }

    @Test
    public void naoDeveCadastrarMedicoDuplicado(){
        Medico m1 = new Medico("João", "12312312312","88888888","testedr@teste.com","Cardiologista","12512");
        Medico m2 = new Medico("Pedro", "12312312312","88888888","testedr@teste.com","Cardiologista","12512");

        medicoService.cadastrarMedico(m1);
        medicoService.cadastrarMedico(m2);

        List<Medico> lista = medicoService.listarMedicos();
        assertEquals(1,lista.size());
        assertEquals("João", lista.get(0).getNome());
    }

    @Test
    public void deveRemoverMedico(){
        Medico medico = new Medico("João", "12312312312","88888888","testedr@teste.com","Cardiologista","12512");
        medicoService.cadastrarMedico(medico);
        medicoService.removerPorCpf("12312312312");

        Medico resultado = medicoService.buscarPorCPF("12312312312");
        assertNull(resultado);
    }
}
