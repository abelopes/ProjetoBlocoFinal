package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.util.Entidade;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.Aluno;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.Modulo;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.Turma;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESPOSTA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public abstract class Resposta<T> extends Entidade {

    private static final long serialVersionUID = -319862261811464750L;

    @ManyToOne
    @JoinColumn(name = "ID_ALUNO")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "ID_AVALIACAO")
    private Avaliacao avaliacao;

    @ManyToOne
    @JoinColumn(name = "ID_QUESTAO")
    private Questao questao;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_TURMA")
    private Turma turma;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_MODULO")
    private Modulo modulo;

    public abstract T getValor();

    public abstract void setValor(T valor);

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

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    

}
