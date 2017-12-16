package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.util.Entidade;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "QUESTAO")
public class Questao extends Entidade {

    private static final long serialVersionUID = -512868865480632740L;

    @OneToMany(mappedBy = "questao")
    private List<Resposta> respostas;

    @ManyToOne
    @JoinColumn(name = "ID_AVALIACAO")
    private Avaliacao avaliacao;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoQuestao tipo;

    @Column(name = "TEXTO", length = 200)
    private String texto;
    
    @ManyToOne
    @JoinColumn(name = "ID_TOPICO")
    private Topico topico;

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public TipoQuestao getTipo() {
        return tipo;
    }

    public void setTipo(TipoQuestao tipo) {
        this.tipo = tipo;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    @Override
    public String toString() {
        return this.getTexto();
    }
    
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Questao) && ((Questao) obj).getId().equals(getId());
    }
}
