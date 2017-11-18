package br.edu.infnet.pos.java.trabalhodebloco.aplicacao.formularioavaliacaoaluno;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.Avaliacao;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.Questao;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.TipoQuestao;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.Topico;
import java.util.ArrayList;

public class FormularioAvaliacaoAlunoController {

    public Avaliacao montarAvaliacaoExemplo() {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setTopicos(new ArrayList<>());

        Topico topico;

        topico = new Topico();
        topico.setTexto("Avaliação geral da Pós-Graduação:");
        topico.setQuestoes(new ArrayList<>());
        topico.getQuestoes().add(criarQuestao(TipoQuestao.LIKERT, "Até agora, o curso está atingindo as minhas expectativas."));
        topico.getQuestoes().add(criarQuestao(TipoQuestao.LIKERT, "Até agora, eu indicaria o curso para um amigo."));
        topico.getQuestoes().add(criarQuestao(TipoQuestao.LIKERT, "Até agora, o curso me parece voltado para as necessidades do mercado."));
        topico.getQuestoes().add(criarQuestao(TipoQuestao.LIKERT, "Até agora, a coordenação pedagógica parece comprometida com a qualidade do curso."));
        topico.getQuestoes().add(criarQuestao(TipoQuestao.LIKERT, "Até agora, minha turma parece proporcionar um networking relevante para a minha carreira."));
        topico.getQuestoes().add(criarQuestao(TipoQuestao.LIKERT, "Até agora, o atendimento de Secretaria que recebi está atingindo as minhas expectativas."));
        avaliacao.getTopicos().add(topico);

        topico = new Topico();
        topico.setTexto("Avaliação do professor do módulo:");
        topico.setQuestoes(new ArrayList<>());
        topico.getQuestoes().add(criarQuestao(TipoQuestao.LIKERT, "O professor contribuiu para o meu aprendizado."));
        topico.getQuestoes().add(criarQuestao(TipoQuestao.LIKERT, "O professor é atencioso e esteve disponível para tirar dúvidas."));
        topico.getQuestoes().add(criarQuestao(TipoQuestao.LIKERT, "O professor aproveitou bem o tempo em sala de aula."));
        topico.getQuestoes().add(criarQuestao(TipoQuestao.LIKERT, "O professor utilizou o Moodle e outros recursos didáticos para ajudar no meu aprendizado."));
        topico.getQuestoes().add(criarQuestao(TipoQuestao.LIKERT, "O professor aproveitou bem os recursos da sala de aula."));
        topico.getQuestoes().add(criarQuestao(TipoQuestao.LIKERT, "Gostaria de cursar outros módulos com esse professor."));
        avaliacao.getTopicos().add(topico);

        topico = new Topico();
        topico.setTexto("Avaliação do conteúdo e infra-estrutura no módulo:");
        topico.setQuestoes(new ArrayList<>());
        topico.getQuestoes().add(criarQuestao(TipoQuestao.LIKERT, "Eu adquiri as competências propostas para o módulo."));
        topico.getQuestoes().add(criarQuestao(TipoQuestao.LIKERT, "O módulo foi útil para o meu crescimento profissional."));
        topico.getQuestoes().add(criarQuestao(TipoQuestao.LIKERT, "A carga horária do módulo foi apropriada."));
        topico.getQuestoes().add(criarQuestao(TipoQuestao.LIKERT, "O acervo da biblioteca atendeu as necessidades desse módulo."));
        topico.getQuestoes().add(criarQuestao(TipoQuestao.LIKERT, "A configuração do(s) computadore(s) e equipamentos da sala de aula e a qualidade do suporte foi apropriada."));
        topico.getQuestoes().add(criarQuestao(TipoQuestao.TEXTUAL, "Você tem comentários e sugestões?"));

        avaliacao.getTopicos().add(topico);

        return avaliacao;
    }

    private Questao criarQuestao(TipoQuestao tipo, String texto) {
        Questao questao = new Questao();
        questao.setTipo(tipo);
        questao.setTexto(texto);
        return questao;
    }

}
