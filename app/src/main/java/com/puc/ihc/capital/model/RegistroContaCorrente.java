package com.puc.ihc.capital.model;

public class RegistroContaCorrente {
    private String data;
    private String desc;
    private String valor;


    public RegistroContaCorrente() {

    }

    public RegistroContaCorrente(String data, String desc, String valor) {
        this.data = data;
        this.desc = desc;
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
