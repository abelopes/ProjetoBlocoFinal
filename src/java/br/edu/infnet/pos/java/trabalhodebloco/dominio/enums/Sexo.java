package br.edu.infnet.pos.java.trabalhodebloco.dominio.enums;

public enum Sexo {

    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
