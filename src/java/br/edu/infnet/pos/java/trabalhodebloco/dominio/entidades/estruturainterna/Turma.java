package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa.Resposta;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.util.Entidade;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TURMA")
public class Turma extends Entidade {

    private static final long serialVersionUID = -8916695384405405035L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "NOME")
    private String nome;
    
    @Column(name = "DT_INICIO")
    private LocalDate inicio;

    @Column(name = "DT_FIM")
    private LocalDate fim;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_PROFESSOR")
    private Professor professor;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "TURMA_MODULO", joinColumns = {
        @JoinColumn(name = "ID_TURMA")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_MODULO")})
    private List<Modulo> modulos;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "TURMA_ALUNO", joinColumns = {
        @JoinColumn(name = "ID_TURMA")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_ALUNO")})
    private List<Aluno> alunos;

    @OneToMany(mappedBy = "turma")
    private List<Resposta> respostas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }    
    
    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

}
