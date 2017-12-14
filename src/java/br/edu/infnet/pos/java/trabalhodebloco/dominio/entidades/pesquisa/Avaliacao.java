package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.util.Entidade;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
@Table(name = "AVALIACAO")
public class Avaliacao extends Entidade {

    private static final long serialVersionUID = 7138098198142465498L;

    @OneToMany(mappedBy = "avaliacao", cascade = CascadeType.PERSIST)
    private List<Resposta> respostas;

    @OneToMany(mappedBy = "avaliacao", cascade = CascadeType.PERSIST)
    private List<Topico> topicos;

    @Column(name = "DATA_HORA_INICIO")
    private LocalDate inicio;

    @Column(name = "DATA_HORA_FIM")
    private LocalDate fim;

    @Lob
    @Column(name = "OBJETIVO")
    private String objetivo;

    @Column(name = "CODIGO_ALFANUMERICO", unique = true)
    private String codigoAlfanumerico;

    public List<Topico> getTopicos() {
        return topicos;
    }

    public void setTopicos(List<Topico> topicos) {
        this.topicos = topicos;
    }

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

    public LocalDate getFim() {
        return fim;
    }

    public void setFim(LocalDate fim) {
        this.fim = fim;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }
    
       @Override
    public String toString() {
        return this.getObjetivo();
    }

}
