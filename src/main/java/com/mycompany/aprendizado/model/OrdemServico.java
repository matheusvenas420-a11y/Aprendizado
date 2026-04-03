package com.mycompany.aprendizado.model;

public class OrdemServico {
    protected int id;
    protected String nome;
    protected double valor;
    protected int prazo;
    protected String tipo_servico;

    public OrdemServico(String nome, double valor, int prazo, String tipo_servico) {
        this.nome = nome;
        this.valor = valor;
        this.prazo = prazo;
        this.tipo_servico = tipo_servico;
    }

    public OrdemServico(int id, String nome, double valor, int prazo, String tipo_servico) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.prazo = prazo;
        this.tipo_servico = tipo_servico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTipo_servico() {
        return tipo_servico;
    }

    public void setTipo_servico(String tipo_servico) {
        this.tipo_servico = tipo_servico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    @Override
    public String toString() {
        return "OrdemServico{" + "id=" + id + ", nome=" + nome + ", valor=" + valor + ", prazo=" + prazo + ", tipo_servico=" + tipo_servico + '}';
    }
}
