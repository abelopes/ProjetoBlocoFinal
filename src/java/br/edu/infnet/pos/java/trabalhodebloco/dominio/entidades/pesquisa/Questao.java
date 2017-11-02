package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.enviodeemail.Mensagem;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.Turma;

@Entity
@Table(name = "QUESTAO")

public class Questao {

        @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
        
        @Column(name = "TEXTO", length = 200)
	private String texto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}