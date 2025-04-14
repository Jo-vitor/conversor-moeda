package br.com.alura.challenge.modelos;

public class Moeda {
    private String moedaBase;
    private String moedaAlvo;
    private double valorConversao;

    public Moeda(String moedaBase, String moedaAlvo, double valorConversao) {
        this.moedaBase = moedaBase;
        this.moedaAlvo = moedaAlvo;
        this.valorConversao = valorConversao;
    }

    public Moeda(MoedaExchangeRate moedaExchangeRate) {
        this.moedaBase = moedaExchangeRate.base_code();
        this.moedaAlvo = moedaExchangeRate.target_code();
        this.valorConversao = moedaExchangeRate.conversion_rate();
    }

    public String getMoedaBase() {
        return moedaBase;
    }

    public String getMoedaAlvo() {
        return moedaAlvo;
    }

    public double getValorConversao() {
        return valorConversao;
    }

    public double calcularConversao(double valor) {
        return valor * valorConversao;
    }

    @Override
    public String toString() {
        return "1 " + moedaBase + " = " + valorConversao + " " + moedaAlvo;
    }
}
