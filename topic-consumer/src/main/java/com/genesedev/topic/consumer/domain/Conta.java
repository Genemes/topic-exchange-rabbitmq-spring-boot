package com.genesedev.topic.consumer.domain;

import java.io.Serializable;

public class Conta implements Serializable {

    private String cliente;
    private String agencia;
    private String conta;

    public Conta(){}

    public Conta(String cliente, String agencia, String conta) {
        this.cliente = cliente;
        this.agencia = agencia;
        this.conta = conta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    @Override
    public String toString() {
        return "{ cliente: "+ cliente + ", " +
                "agencia:" + agencia + ", " +
                "conta:" + conta + "}";
    }
}
