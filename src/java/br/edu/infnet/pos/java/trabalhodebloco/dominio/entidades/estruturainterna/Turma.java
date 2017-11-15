package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TURMA")
public class Turma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DT_INICIO")
    private LocalDate inicio;

    @Column(name = "DT_FIM")
    private LocalDate fim;

    @ManyToOne
    @JoinColumn(name = "ID_PROFESSOR")
    private Professor professor;

    @ManyToMany
    @JoinTable(name = "TURMA_MODULO", joinColumns = {
        @JoinColumn(name = "ID_TURMA")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_MODULO")})
    private List<Modulo> modulos;

    @ManyToMany
    @JoinTable(name = "TURMA_ALUNO", joinColumns = {
        @JoinColumn(name = "ID_TURMA")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_ALUNO")})
    private List<Aluno> alunos;

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
