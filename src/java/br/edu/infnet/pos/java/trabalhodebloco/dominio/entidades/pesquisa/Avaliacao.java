package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.util.Entidade;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.OneToMany;

@Entity
@Table(name = "AVALIACAO")
public class Avaliacao extends Entidade {

    private static final long serialVersionUID = 7138098198142465498L;

    @OneToMany(mappedBy = "avaliacao")
    private List<Resposta> respostas;

    @OneToMany(mappedBy = "avaliacao")
    private List<Questao> questoes;

    @Column(name = "DATA_HORA_INICIO")
    private LocalDateTime inicio;

    @Column(name = "DATA_HORA_FIM")
    private LocalDateTime fim;

    @Lob
    @Column(name = "OBJETIVO")
    private String objetivo;

    @Column(name = "CODIGO_ALFANUMERICO", unique = true)
    private String codigoAlfanumerico;

    public String getCodigoAlfanumerico() {
        return codigoAlfanumerico;
    }

    public void setCodigoAlfanumerico(String codigoAlfanumerico) {
        this.codigoAlfanumerico = codigoAlfanumerico;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

}
