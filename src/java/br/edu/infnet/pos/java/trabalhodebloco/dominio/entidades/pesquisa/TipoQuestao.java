package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.pesquisa;

public enum TipoQuestao {

    LIKERT("Likert"),
    TEXTUAL("Textual");

    private final String descricao;

    TipoQuestao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
