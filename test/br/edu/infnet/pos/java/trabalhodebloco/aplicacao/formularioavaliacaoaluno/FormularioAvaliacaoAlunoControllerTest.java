package br.edu.infnet.pos.java.trabalhodebloco.aplicacao.formularioavaliacaoaluno;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.Aluno;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.AlunoFacade;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.Modulo;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.ModuloFacade;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.Avaliacao;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.TipoQuestao;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.beans.AvaliacaoFacade;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.enums.Sexo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FormularioAvaliacaoAlunoControllerTest {

    @InjectMocks
    private FormularioAvaliacaoAlunoController controller;

    @Mock
    private AvaliacaoFacade mockAvaliacaoFacade;

    @Mock
    private AlunoFacade mockAlunoFacade;

    @Mock
    private ModuloFacade mockModuloFacade;

    @Test
    public void deveCriarUmFormularioDeExemplo() {
        Avaliacao avaliacao = controller.montarAvaliacaoExemplo();

        assertNotNull(avaliacao);

        assertEquals("0B1W4NK3N0B1", avaliacao.getCodigoAlfanumerico());
        assertEquals(LocalDateTime.of(1985, Month.SEPTEMBER, 12, 6, 0), avaliacao.getInicio());
        assertEquals(LocalDateTime.of(2000, Month.SEPTEMBER, 12, 6, 0), avaliacao.getFim());
        assertEquals("Avaliar o curso de especialização em engenharia de software", avaliacao.getObjetivo());

        assertEquals(avaliacao.getTopicos().get(0).getTexto(), "Avaliação geral da Pós-Graduação:");

        assertEquals(avaliacao.getTopicos().get(0).getQuestoes().get(0).getTexto(), "Até agora, o curso está atingindo as minhas expectativas.");
        assertEquals(avaliacao.getTopicos().get(0).getQuestoes().get(0).getTipo(), TipoQuestao.LIKERT);

        assertEquals(avaliacao.getTopicos().get(0).getQuestoes().get(1).getTexto(), "Até agora, eu indicaria o curso para um amigo.");
        assertEquals(avaliacao.getTopicos().get(0).getQuestoes().get(1).getTipo(), TipoQuestao.LIKERT);

        assertEquals(avaliacao.getTopicos().get(0).getQuestoes().get(2).getTexto(), "Até agora, o curso me parece voltado para as necessidades do mercado.");
        assertEquals(avaliacao.getTopicos().get(0).getQuestoes().get(2).getTipo(), TipoQuestao.LIKERT);

        assertEquals(avaliacao.getTopicos().get(0).getQuestoes().get(3).getTexto(), "Até agora, a coordenação pedagógica parece comprometida com a qualidade do curso.");
        assertEquals(avaliacao.getTopicos().get(0).getQuestoes().get(3).getTipo(), TipoQuestao.LIKERT);

        assertEquals(avaliacao.getTopicos().get(0).getQuestoes().get(4).getTexto(), "Até agora, minha turma parece proporcionar um networking relevante para a minha carreira.");
        assertEquals(avaliacao.getTopicos().get(0).getQuestoes().get(4).getTipo(), TipoQuestao.LIKERT);

        assertEquals(avaliacao.getTopicos().get(0).getQuestoes().get(5).getTexto(), "Até agora, o atendimento de Secretaria que recebi está atingindo as minhas expectativas.");
        assertEquals(avaliacao.getTopicos().get(0).getQuestoes().get(5).getTipo(), TipoQuestao.LIKERT);

        assertEquals(avaliacao.getTopicos().get(1).getTexto(), "Avaliação do professor do módulo:");

        assertEquals(avaliacao.getTopicos().get(1).getQuestoes().get(0).getTexto(), "O professor contribuiu para o meu aprendizado.");
        assertEquals(avaliacao.getTopicos().get(1).getQuestoes().get(0).getTipo(), TipoQuestao.LIKERT);

        assertEquals(avaliacao.getTopicos().get(1).getQuestoes().get(1).getTexto(), "O professor é atencioso e esteve disponível para tirar dúvidas.");
        assertEquals(avaliacao.getTopicos().get(1).getQuestoes().get(1).getTipo(), TipoQuestao.LIKERT);

        assertEquals(avaliacao.getTopicos().get(1).getQuestoes().get(2).getTexto(), "O professor aproveitou bem o tempo em sala de aula.");
        assertEquals(avaliacao.getTopicos().get(1).getQuestoes().get(2).getTipo(), TipoQuestao.LIKERT);

        assertEquals(avaliacao.getTopicos().get(1).getQuestoes().get(3).getTexto(), "O professor utilizou o Moodle e outros recursos didáticos para ajudar no meu aprendizado.");
        assertEquals(avaliacao.getTopicos().get(1).getQuestoes().get(3).getTipo(), TipoQuestao.LIKERT);

        assertEquals(avaliacao.getTopicos().get(1).getQuestoes().get(4).getTexto(), "O professor aproveitou bem os recursos da sala de aula.");
        assertEquals(avaliacao.getTopicos().get(1).getQuestoes().get(4).getTipo(), TipoQuestao.LIKERT);

        assertEquals(avaliacao.getTopicos().get(1).getQuestoes().get(5).getTexto(), "Gostaria de cursar outros módulos com esse professor.");
        assertEquals(avaliacao.getTopicos().get(1).getQuestoes().get(5).getTipo(), TipoQuestao.LIKERT);

        assertEquals(avaliacao.getTopicos().get(2).getTexto(), "Avaliação do conteúdo e infra-estrutura no módulo:");

        assertEquals(avaliacao.getTopicos().get(2).getQuestoes().get(0).getTexto(), "Eu adquiri as competências propostas para o módulo.");
        assertEquals(avaliacao.getTopicos().get(2).getQuestoes().get(0).getTipo(), TipoQuestao.LIKERT);

        assertEquals(avaliacao.getTopicos().get(2).getQuestoes().get(1).getTexto(), "O módulo foi útil para o meu crescimento profissional.");
        assertEquals(avaliacao.getTopicos().get(2).getQuestoes().get(1).getTipo(), TipoQuestao.LIKERT);

        assertEquals(avaliacao.getTopicos().get(2).getQuestoes().get(2).getTexto(), "A carga horária do módulo foi apropriada.");
        assertEquals(avaliacao.getTopicos().get(2).getQuestoes().get(2).getTipo(), TipoQuestao.LIKERT);

        assertEquals(avaliacao.getTopicos().get(2).getQuestoes().get(3).getTexto(), "O acervo da biblioteca atendeu as necessidades desse módulo.");
        assertEquals(avaliacao.getTopicos().get(2).getQuestoes().get(3).getTipo(), TipoQuestao.LIKERT);

        assertEquals(avaliacao.getTopicos().get(2).getQuestoes().get(4).getTexto(), "A configuração do(s) computadore(s) e equipamentos da sala de aula e a qualidade do suporte foi apropriada.");
        assertEquals(avaliacao.getTopicos().get(2).getQuestoes().get(4).getTipo(), TipoQuestao.LIKERT);

        assertEquals(avaliacao.getTopicos().get(2).getQuestoes().get(5).getTexto(), "Você tem comentários e sugestões?");
        assertEquals(avaliacao.getTopicos().get(2).getQuestoes().get(5).getTipo(), TipoQuestao.TEXTUAL);
    }

    @Test
    public void deveMontarUmAlunoDeExemplo() {
        Aluno aluno = controller.montarAlunoExemplo();
        assertEquals("Bruce Notario", aluno.getNome());
        assertEquals("12345678901", aluno.getCpf());
        assertEquals("999444222", aluno.getMatricula());
        assertEquals(Sexo.MASCULINO, aluno.getSexo());
        assertEquals(LocalDate.of(1985, Month.SEPTEMBER, 12), aluno.getDataNascimento());
        assertEquals(1, aluno.getTurmas().size());
        assertEquals(LocalDate.of(2000, Month.SEPTEMBER, 12), aluno.getTurmas().get(0).getInicio());
        assertEquals(LocalDate.of(2000, Month.SEPTEMBER, 20), aluno.getTurmas().get(0).getFim());
        assertNotNull(aluno.getTurmas().get(0).getProfessor());
        assertEquals("John Lenon", aluno.getTurmas().get(0).getProfessor().getNome());
        assertNotNull(aluno.getTurmas().get(0).getModulos());
        assertEquals(1, aluno.getTurmas().get(0).getModulos().size());
        assertEquals("Módulo da Banda de Pagode", aluno.getTurmas().get(0).getModulos().get(0).getNome());
    }

    @Test
    public void deveSerPossivelAtribuidUmIdDeUsuarioAoController() {
        final Integer ID_ALUNO = 234234;
        final Aluno esperado = new Aluno();
        esperado.setId(ID_ALUNO);
        when(mockAlunoFacade.find(ID_ALUNO)).thenReturn(esperado);
        controller.setIdAluno(ID_ALUNO);
        assertEquals(ID_ALUNO, controller.getAluno().getId());
    }

    @Test
    public void deveTerUmGetParaIdAluno() {
        final Integer ID_ALUNO = 74564;
        controller.setIdAluno(ID_ALUNO);
        assertEquals(ID_ALUNO, controller.getIdAluno());
    }

    @Test
    public void deveChamarFacadeAoCriarNoBancoUmaAvaliacaoDeExemplo() {
        controller.criarAvaliacaoExemplo();
        verify(mockAvaliacaoFacade).create(Mockito.any());
    }

    @Test
    public void deveChamarFacadeAoCriarNoBancoUmAlunoDeExemplo() {
        controller.criarAlunoExemplo();
        verify(mockAlunoFacade).create(Mockito.any());
    }

    @Test
    public void deveSerPossivelAlterarUmAluno() {
        final String NOME_ALUNO = "Bruce Notario";
        final Aluno aluno = new Aluno();
        aluno.setNome(NOME_ALUNO);
        controller.setAluno(aluno);
        assertEquals(NOME_ALUNO, controller.getAluno().getNome());
    }

    @Test
    public void seOAlunoForAlteradoOIdTambemDeveSerAlterado() {
        final Integer ID_ALUNO = 234784982;
        Aluno aluno = new Aluno();
        aluno.setId(ID_ALUNO);
        controller.setAluno(aluno);
        assertEquals(ID_ALUNO, controller.getIdAluno());
    }

    @Test
    public void aoAlterarUmIdDeAlunoDeveSeBuscarOAlunoNaBase() {
        final Integer ID_ALUNO = 2345234;
        controller.setIdAluno(ID_ALUNO);
        verify(mockAlunoFacade).find(ID_ALUNO);
    }

    @Test
    public void oAlunoEncontradoAoAtribuirUmIdAlunoDeveSerColocadoNoAtributoAluno() {
        final Integer ID_ALUNO = 88969905;
        final String NOME_ALUNO = "Yuval noah Harari";
        final Aluno alunoEsperado = new Aluno();
        alunoEsperado.setId(ID_ALUNO);
        alunoEsperado.setNome(NOME_ALUNO);
        when(mockAlunoFacade.find(ID_ALUNO)).thenReturn(alunoEsperado);
        controller.setIdAluno(ID_ALUNO);
        assertEquals(ID_ALUNO, controller.getAluno().getId());
        assertEquals(NOME_ALUNO, controller.getAluno().getNome());
    }

    @Test
    public void deveSerPossivelAlterarOsModulosAssociadosAUmAluno() {
        final Integer ID_MODULO = 75775794;
        List<Modulo> modulos = new ArrayList<>();
        Modulo modulo = new Modulo();
        modulo.setId(ID_MODULO);
        modulos.add(modulo);
        controller.setModulosAluno(modulos);
        assertEquals(ID_MODULO, controller.getModulosAluno().get(0).getId());
    }

    @Test
    public void deveBuscarOsModulosAssociadosAoAluno() {
        final Integer ID_ALUNO = 123123;
        controller.setIdAluno(ID_ALUNO);
        verify(mockModuloFacade).buscarModulosPorIdAluno(ID_ALUNO);
    }
    
    @Test
    public void deveRetornarOsModulosAssociadosAoAluno() {        
        final Integer ID_ALUNO = 123123;
        final Integer ID_MODULO = 74546;
        List<Modulo> modulos = new ArrayList();
        Modulo modulo = new Modulo();
        modulo.setId(ID_MODULO);
        modulos.add(modulo);
        when(mockModuloFacade.buscarModulosPorIdAluno(ID_ALUNO)).thenReturn(modulos);
        controller.setIdAluno(ID_ALUNO);
        assertEquals(ID_MODULO, controller.getModulosAluno().get(0).getId());
    }

}
