package br.edu.infnet.pos.java.trabalhodebloco.aplicacao.formularioavaliacaoaluno;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.Aluno;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.AlunoFacade;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.Modulo;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.ModuloFacade;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.Professor;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.Turma;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.TurmaFacade;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.Avaliacao;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.Questao;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.TipoQuestao;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.Topico;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.enums.Sexo;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.beans.AvaliacaoFacade;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.enums.Likert;
import java.util.List;

@Named("formularioAvaliacaoAlunoController")
@RequestScoped
public class FormularioAvaliacaoAlunoController {

    @EJB
    private AvaliacaoFacade avaliacaoFacade;

    @EJB
    private AlunoFacade alunoFacade;

    @EJB
    private ModuloFacade moduloFacade;

    @EJB
    private TurmaFacade turmaFacade;

    private Integer idAluno;
    private Aluno aluno;

    private Integer idAvaliacao;
    private Avaliacao avaliacao;

    private Integer idModulo;
    private Modulo modulo;

    private Integer idTurma;
    private Turma turma;

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
        this.idAluno = aluno.getId();
    }

    public void criarAvaliacaoExemplo() {
        avaliacaoFacade.create(montarAvaliacaoExemplo());
    }

    public void criarAlunoExemplo() {
        alunoFacade.create(montarAlunoExemplo());
    }

    public Avaliacao montarAvaliacaoExemplo() {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setCodigoAlfanumerico("0B1W4NK3N0B1" + Math.random());
        avaliacao.setInicio(LocalDate.of(2017, Month.MARCH, 01));
        avaliacao.setFim(LocalDate.of(2017, Month.JULY, 10));
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

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
        this.aluno = alunoFacade.find(idAluno);
    }

    public Aluno montarAlunoExemplo() {
        Aluno novoAluno = new Aluno();
        novoAluno.setNome("Bruce Notario");
        novoAluno.setCpf("12345678901");
        novoAluno.setMatricula("999444222");
        novoAluno.setSexo(Sexo.MASCULINO);
        novoAluno.setDataNascimento(LocalDate.of(1985, Month.SEPTEMBER, 12));
        novoAluno.setTurmas(new ArrayList<>());
        novoAluno.getTurmas().add(new Turma());
        novoAluno.getTurmas().get(0).setInicio(LocalDate.of(2000, Month.SEPTEMBER, 12));
        novoAluno.getTurmas().get(0).setFim(LocalDate.of(2000, Month.SEPTEMBER, 20));
        novoAluno.getTurmas().get(0).setProfessor(new Professor());
        novoAluno.getTurmas().get(0).getProfessor().setNome("John Lenon");
        novoAluno.getTurmas().get(0).setModulos(new ArrayList<>());
        novoAluno.getTurmas().get(0).getModulos().add(new Modulo());
        novoAluno.getTurmas().get(0).getModulos().get(0).setNome("Módulo da Banda de Pagode");
        return novoAluno;
    }

    void setModulosAluno(ArrayList<Object> arrayList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
        this.avaliacao = avaliacaoFacade.find(idAvaliacao);
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Integer getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
        this.modulo = moduloFacade.find(idModulo);
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
        this.turma = turmaFacade.find(idTurma);
    }
    
    public void salvarRespostas() {
        System.out.println();
    }

    public Likert[] getValoresLikert() {
        return Likert.values();
    }    
}
