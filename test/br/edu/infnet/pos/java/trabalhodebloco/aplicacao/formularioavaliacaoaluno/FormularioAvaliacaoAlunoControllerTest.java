package br.edu.infnet.pos.java.trabalhodebloco.aplicacao.formularioavaliacaoaluno;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.Aluno;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.Avaliacao;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.TipoQuestao;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.enums.Sexo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FormularioAvaliacaoAlunoControllerTest {

    @InjectMocks
    private FormularioAvaliacaoAlunoController controller;

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
        controller.setIdAluno(ID_ALUNO);
        assertEquals(ID_ALUNO, controller.getAluno().getId());
    }

    @Test
    public void deveTerUmGetParaIdAluno() {
        final Integer ID_ALUNO = 74564;
        controller.setIdAluno(ID_ALUNO);
        assertEquals(ID_ALUNO, controller.getIdAluno());
    }

}
