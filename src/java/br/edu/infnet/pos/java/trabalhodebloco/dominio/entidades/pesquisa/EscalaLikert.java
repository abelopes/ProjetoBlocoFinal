package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

public enum EscalaLikert {

    CONCORDO_TOTALMENTE("Concordo totalmente"),
    CONCORDO("Concordo"),
    NAO_CONCORDO_NEM_DISCORDO("Não concordo nem discordo"),
    DISCORDO("Discordo"),
    DISCORDO_TOTALMENTE("Discordo totalmente"),
    NAO_SEI_AVALIAR("Não sei avaliar");

    private final String descricao;

    EscalaLikert(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
