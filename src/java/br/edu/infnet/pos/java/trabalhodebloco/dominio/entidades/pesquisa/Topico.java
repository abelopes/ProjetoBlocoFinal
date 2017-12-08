package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.util.Entidade;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TOPICO")
public class Topico extends Entidade {

    private static final long serialVersionUID = 3678988274148225422L;

    @Column(name = "TEXTO")
    private String texto;

    @ManyToOne
    @JoinColumn(name = "ID_AVALIACAO")
    private Avaliacao avaliacao;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.PERSIST)
    private List<Questao> questoes;

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
