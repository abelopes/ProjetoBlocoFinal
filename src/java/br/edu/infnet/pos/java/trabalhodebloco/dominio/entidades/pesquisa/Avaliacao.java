package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.enviodeemail.Mensagem;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.Turma;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "AVALIACAO")
public class Avaliacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    @Lob
    @Column(name = "COMENTARIOS_E_SUGESTOES")
    private String comentariosESugestoes;

    @Column(name = "DT_FIM")
    private LocalDate fim;

    @Column(name = "DT_INICIO")
    private LocalDate inicio;

    @Column(name = "OBJETIVO", length = 200)
    private String objetivo;

    @ManyToMany
    @JoinTable(name = "AVALIACAO_QUESTAO",
            joinColumns = @JoinColumn(name = "id_avaliacao"),
            inverseJoinColumns = @JoinColumn(name = "id_questao"))
    private Set<Questao> questao = new HashSet<>();

    @Transient
    private Formulario formulario;

    @Transient
    private Mensagem mensagem;

    @Transient
    private List<Turma> turmas;

    @Transient
    private List<Questao> questoes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComentariosESugestoes() {
        return comentariosESugestoes;
    }

    public void setComentariosESugestoes(String comentariosESugestoes) {
        this.comentariosESugestoes = comentariosESugestoes;
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

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public Set<Questao> getQuestao() {
        return questao;
    }

    public void setQuestao(Set<Questao> categoria) {
        this.questao = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Avaliacao other = (Avaliacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
