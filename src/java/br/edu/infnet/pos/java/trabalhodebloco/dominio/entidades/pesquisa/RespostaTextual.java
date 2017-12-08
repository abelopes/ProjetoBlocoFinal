package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
@DiscriminatorValue(value = "TEXTUAL")
public class RespostaTextual extends Resposta<String> {

    private static final long serialVersionUID = -4504941583616592025L;

    @Lob
    @Column(name = "VALOR_TEXTUAL")
    private String valor;

    public RespostaTextual() {
        valor = "";
    }

    @Override
    public String getValor() {
        return valor;
    }

    @Override
    public void setValor(String valor) {
        this.valor = valor;
    }

}
