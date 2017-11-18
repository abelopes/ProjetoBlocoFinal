package br.edu.infnet.pos.java.trabalhodebloco.aplicacao.formularioavaliacaoaluno;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.Avaliacao;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.Questao;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.TipoQuestao;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.Topico;
import br.edu.infnet.pos.java.trabalhodebloco.infra.eao.AvaliacaoEAO;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

@Named("formularioAvaliacaoAlunoController")
@RequestScoped
public class FormularioAvaliacaoAlunoController {

    @PersistenceContext(unitName = "ProjetoBloco4PU") // TODO RETIRAR ISSO DAQUI
    private EntityManager em; // TODO RETIRAR ISSO DAQUI

    public void criarAvaliacaoExemplo() { // TODO RETIRAR ISSO DAQUI
        em.persist(montarAvaliacaoExemplo()); // TODO RETIRAR ISSO DAQUI
    } // TODO RETIRAR ISSO DAQUI

    public Avaliacao montarAvaliacaoExemplo() {

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setTopicos(new ArrayList<>());

        Topico topico;

        topico = criarTopicoComQuestoesLikert(
                "Avaliação geral da Pós-Graduação:",
                "Até agora, o curso está atingindo as minhas expectativas.", "Até agora, eu indicaria o curso para um amigo.",
                "Até agora, o curso me parece voltado para as necessidades do mercado.",
                "Até agora, a coordenação pedagógica parece comprometida com a qualidade do curso.",
                "Até agora, minha turma parece proporcionar um networking relevante para a minha carreira.",
                "Até agora, o atendimento de Secretaria que recebi está atingindo as minhas expectativas."
        );
        avaliacao.getTopicos().add(topico);

        topico = criarTopicoComQuestoesLikert(
                "Avaliação do professor do módulo:",
                "O professor contribuiu para o meu aprendizado.",
                "O professor é atencioso e esteve disponível para tirar dúvidas.",
                "O professor aproveitou bem o tempo em sala de aula.",
                "O professor utilizou o Moodle e outros recursos didáticos para ajudar no meu aprendizado.",
                "O professor aproveitou bem os recursos da sala de aula.",
                "Gostaria de cursar outros módulos com esse professor."
        );
        avaliacao.getTopicos().add(topico);

        topico = criarTopicoComQuestoesLikert(
                "Avaliação do conteúdo e infra-estrutura no módulo:",
                "Eu adquiri as competências propostas para o módulo.",
                "O módulo foi útil para o meu crescimento profissional.",
                "A carga horária do módulo foi apropriada.",
                "O acervo da biblioteca atendeu as necessidades desse módulo.",
                "A configuração do(s) computadore(s) e equipamentos da sala de aula e a qualidade do suporte foi apropriada."
        );
        topico.getQuestoes().add(criarQuestao(TipoQuestao.TEXTUAL, "Você tem comentários e sugestões?"));
        avaliacao.getTopicos().add(topico);

        return avaliacao;
    }

    private Topico criarTopicoComQuestoesLikert(String textoTopico, String... textosQuestoes) {
        Topico topico = new Topico();
        topico.setTexto(textoTopico);
        topico.setQuestoes(new ArrayList<>());
        for (String textoQuestao : textosQuestoes) {
            topico.getQuestoes().add(criarQuestao(textoQuestao));
        }
        return topico;
    }

    private Questao criarQuestao(TipoQuestao tipo, String texto) {
        Questao questao = new Questao();
        questao.setTipo(tipo);
        questao.setTexto(texto);
        return questao;
    }

    private Questao criarQuestao(String texto) {
        return criarQuestao(TipoQuestao.LIKERT, texto);
    }
}
