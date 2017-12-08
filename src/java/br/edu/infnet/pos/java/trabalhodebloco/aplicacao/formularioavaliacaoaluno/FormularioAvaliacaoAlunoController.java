package br.edu.infnet.pos.java.trabalhodebloco.aplicacao.formularioavaliacaoaluno;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.Aluno;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.AlunoFacade;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.Modulo;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.Professor;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.Turma;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.Avaliacao;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.Questao;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.TipoQuestao;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.Topico;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.enums.Sexo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.beans.AvaliacaoFacade;

@Named("formularioAvaliacaoAlunoController")
@RequestScoped
public class FormularioAvaliacaoAlunoController {

    @EJB
    private AvaliacaoFacade avaliacaoFacade;

    @EJB
    private AlunoFacade alunoFacade;

    private Integer idAluno;

    private Aluno aluno;

    public void criarAvaliacaoExemplo() { // TODO RETIRAR ISSO DAQUI ELIMINAR O MÉTODO
        avaliacaoFacade.create(montarAvaliacaoExemplo());
    }

    public void criarAlunoExemplo() { // TODO RETIRAR ISSO DAQUI ELIMINAR O MÉTODO
        alunoFacade.create(montarAlunoExemplo());
    }

    public Avaliacao montarAvaliacaoExemplo() {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setCodigoAlfanumerico("0B1W4NK3N0B1");
        avaliacao.setInicio(LocalDateTime.of(1985, Month.SEPTEMBER, 12, 6, 0));
        avaliacao.setFim(LocalDateTime.of(2000, Month.SEPTEMBER, 12, 6, 0));
        avaliacao.setObjetivo("Avaliar o curso de especialização em engenharia de software");
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

    public Aluno getAluno() {
        return aluno;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
        aluno = null;
        aluno = new Aluno();
        aluno.setId(idAluno);
    }

    public Aluno montarAlunoExemplo() {
        Aluno aluno = new Aluno();
        aluno.setNome("Bruce Notario");
        aluno.setCpf("12345678901");
        aluno.setMatricula("999444222");
        aluno.setSexo(Sexo.MASCULINO);
        aluno.setDataNascimento(LocalDate.of(1985, Month.SEPTEMBER, 12));
        aluno.setTurmas(new ArrayList<>());
        aluno.getTurmas().add(new Turma());
        aluno.getTurmas().get(0).setInicio(LocalDate.of(2000, Month.SEPTEMBER, 12));
        aluno.getTurmas().get(0).setFim(LocalDate.of(2000, Month.SEPTEMBER, 20));
        aluno.getTurmas().get(0).setProfessor(new Professor());
        aluno.getTurmas().get(0).getProfessor().setNome("John Lenon");
        aluno.getTurmas().get(0).setModulos(new ArrayList<>());
        aluno.getTurmas().get(0).getModulos().add(new Modulo());
        aluno.getTurmas().get(0).getModulos().get(0).setNome("Módulo da Banda de Pagode");
        return aluno;
    }
}
