package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import java.util.List;

public class Formulario {

	private Avaliacao avaliacao;
	private List<Resposta> respostas;

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

}