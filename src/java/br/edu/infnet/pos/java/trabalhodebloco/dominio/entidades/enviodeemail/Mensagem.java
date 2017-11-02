package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.enviodeemail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "MENSAGEM")
@PrimaryKeyJoinColumn(name = "avaliacao_id")
public class Mensagem {

        @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
	
        @Column(name = "DESTINATARIO", length = 50)
        private String destinatario;
        
        @Column(name = "REMETENTE", length = 50)
        private String remetente;

        @Column(name = "MENSAGEM", length = 50)
        private String mensagem;
        
        
        public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

        
	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

        
        public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
        
        
        
	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

}