package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.util.Entidade;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.Aluno;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.enums.Likert;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "RESPOSTA")
public class Resposta extends Entidade {

    private static final long serialVersionUID = -319862261811464750L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID")
//    private Integer idResposta;
//
//    @ManyToOne
//    @JoinColumn(name = "ID_QUESTAO")
//    private Questao questao;
//
//    @ManyToOne
//    @JoinColumn(name = "ID_AVALIACAO")
//    private Avaliacao avaliacao;
//
//    @ManyToOne
//    @JoinColumn(name = "ID_ALUNO")
//    private Aluno aluno;
//
//    @Column(name = "RESPOSTA")
//    private Likert resposta;
//
//    public Avaliacao getIdAvaliacao() {
//        return avaliacao;
//    }
//
//    public void setIdAvaliacao(Avaliacao avaliacao) {
//        this.avaliacao = avaliacao;
//    }
//
//    public Integer getIdResposta() {
//        return idResposta;
//    }
//
//    public void setIdResposta(Integer idResposta) {
//        this.idResposta = idResposta;
//    }
//
//    public Questao getQuestao() {
//        return questao;
//    }
//
//    public void setQuestao(Questao questao) {
//        this.questao = questao;
//    }
//
//    public Aluno getAluno() {
//        return aluno;
//    }
//
//    public void setAluno(Aluno aluno) {
//        this.aluno = aluno;
//    }
//
//    public Likert getResposta() {
//        return resposta;
//    }
//
//    public void setResposta(Likert resposta) {
//        this.resposta = resposta;
//    }

}
