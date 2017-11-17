package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue(value = "LIKERT")
public class RespostaLikert extends Resposta<EscalaLikert> {

    private static final long serialVersionUID = 7813061893072973223L;

    @Column(name = "VALOR_LIKERT")
    @Enumerated(EnumType.STRING)
    private EscalaLikert valor;

    public RespostaLikert() {
        valor = EscalaLikert.NAO_SEI_AVALIAR;
    }

    @Override
    public EscalaLikert getValor() {
        return valor;
    }

    @Override
    public void setValor(EscalaLikert valor) {
        this.valor = valor;
    }

}
