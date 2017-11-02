package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "PROFESSOR")
public class Professor extends Pessoa {

	@Lob
	@Column(name = "CURRICULO_RESUMIDO")
	private String curriculoResumido;

	@OneToMany(mappedBy = "professor")
	private List<Turma> turmas;

	public String getCurriculoResumido() {
		return curriculoResumido;
	}

	public void setCurriculoResumido(String curriculoResumido) {
		this.curriculoResumido = curriculoResumido;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

}
