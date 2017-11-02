package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.enums.Sexo;

@Entity
@DiscriminatorValue(value = "ALUNO")
public class Aluno extends Pessoa {

	@Column(name = "CPF", length = 11)
	private String cpf;

	@Column(name = "DATA_NASCIMENTO")
	private LocalDate dataNascimento;

	@Column(name = "EMAIL", length = 150)
	private String email;

	@Column(name = "IDENTIDADE", length = 50)
	private String identidade;

	@Column(name = "MATRICULA", length = 50)
	private String matricula;

	@Column(name = "NOME_DA_MAE", length = 150)
	private String nomeMae;

	@Column(name = "SEXO")
	private Sexo sexo;

	@ManyToMany(mappedBy = "alunos")
	private List<Turma> turmas;

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

}