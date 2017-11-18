package br.edu.infnet.pos.java.trabalhodebloco.aplicacao.formularioavaliacaoaluno;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.Avaliacao;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.TipoQuestao;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class FormularioAvaliacaoAlunoControllerTest {

    private FormularioAvaliacaoAlunoController controller;

    @Before
    public void setUp() {
        controller = new FormularioAvaliacaoAlunoController();
    }

    @After
    public void tearDown() {
        controller = null;
    }

    @Test
    public void deveCriarUmFormularioDeExemplo() {
        Avaliacao avaliacao = controller.montarAvaliacaoExemplo();
        
        assertNotNull(avaliacao);

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

}
