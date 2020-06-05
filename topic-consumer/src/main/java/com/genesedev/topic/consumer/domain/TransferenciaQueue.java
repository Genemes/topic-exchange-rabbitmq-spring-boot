package com.genesedev.topic.consumer.domain;

import java.time.LocalTime;

public class TransferenciaQueue {

    private Conta credito;
    private Conta debito;
    private Integer codigoTranferencia;
    float valor;
    LocalTime horario;

    public TransferenciaQueue() {}

    public TransferenciaQueue(Conta credito, Conta debito, AgenciaEnum codigoTranferencia, float valor, LocalTime horario) {
        this.credito = credito;
        this.debito = debito;
        this.codigoTranferencia = codigoTranferencia.getCod();
        this.valor = valor;
        this.horario = horario;
    }

    public Conta getCredito() {
        return credito;
    }

    public void setCredito(Conta credito) {
        this.credito = credito;
    }

    public Conta getDebito() {
        return debito;
    }

    public void setDebito(Conta debito) {
        this.debito = debito;
    }

    public Integer getCodigoTranferencia() {
        return codigoTranferencia;
    }

    public void setCodigoTranferencia(Integer codigoTranferencia) {
        this.codigoTranferencia = codigoTranferencia;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "TransferenciaQueue{" +
                "credito:" + credito +
                ", debito:" + debito +
                ", codigoTranferencia:" + codigoTranferencia +
                ", valor:" + valor +
                ", horario:" + horario +
                '}';
    }
}
