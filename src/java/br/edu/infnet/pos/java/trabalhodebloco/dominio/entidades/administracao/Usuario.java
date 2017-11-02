package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.administracao;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.Aluno;
import br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna.Curso;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "USUARIO")
//@PrimaryKeyJoinColumn(name = "aluno_id")
public class Usuario {

       
	private Integer id;
       private String email;
	private String nome;
	private String senha;
	private Boolean senhaTemporaria;
        private Aluno aluno;

        @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
      
        @Column(length = 60, nullable = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

        @Column(length = 60, nullable = true)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

        @Column(length = 10, nullable = true)
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getSenhaTemporaria() {
		return senhaTemporaria;
	}

	public void setSenhaTemporaria(Boolean senhaTemporaria) {
		this.senhaTemporaria = senhaTemporaria;
	}
        
        @ManyToOne
	@JoinColumn(name = "ID_ALUNO")
	
        
        public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


}