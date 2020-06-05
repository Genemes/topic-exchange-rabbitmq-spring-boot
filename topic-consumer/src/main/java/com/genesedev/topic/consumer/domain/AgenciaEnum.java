package com.genesedev.topic.consumer.domain;

public enum AgenciaEnum {

    VOTORANTIM(655, "B.Votorantim"),
    BRASIL(1, "B.Brasil"),
    ITAU(341, "Itaú"),
    BRADESCO(237, "Bradesco"),
    SANTANDER(33, "Santander");

    private int cod;
    private String descricao;

    private AgenciaEnum(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static AgenciaEnum toEnum (Integer cod) {
        if(cod == null) {
            return null;
        }

        for (AgenciaEnum x : AgenciaEnum.values()) {
            if(cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: "+ cod);
    }

    public static String toStr (Integer cod) {
        if(cod == null) {
            return null;
        }

        for (AgenciaEnum x : AgenciaEnum.values()) {
            if(cod.equals(x.getCod())) {
                return x.descricao;
            }
        }

        throw new IllegalArgumentException("Id inválido: "+ cod);
    }
}
