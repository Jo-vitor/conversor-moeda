package br.com.alura.challenge.principal;

import br.com.alura.challenge.modelos.Api;
import br.com.alura.challenge.modelos.Moeda;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("""
                    ***************************************
                    Menu conversor de moedas:
                    
                    1) Dólar americano => Real brasileiro
                    2) Real brasileiro => Dólar americano
                    3) Euro => Real brasileiro
                    4) Real brasileiro => Euro
                    5) Peso argentino => Real brasileiro
                    6) Real brasileiro => Peso argentino
                    7) Sair
                    ***************************************
                    
                    Escolha uma opção:
                    """);
            opcao = leitura.nextInt();

            if(opcao >= 1 && opcao <= 6) {
                Moeda moeda = null;

                System.out.println("Qual valor deseja converter?:");
                double valor = leitura.nextDouble();

                try {
                        if(opcao == 1){
                            moeda = Api.pegaDados("USD", "BRL");
                        } else if(opcao == 2){
                            moeda = Api.pegaDados("BRL", "USD");
                        } else if(opcao == 3){
                            moeda = Api.pegaDados("EUR", "BRL");
                        } else if(opcao == 4){
                            moeda = Api.pegaDados("BRL", "EUR");
                        } else if(opcao == 5){
                            moeda = Api.pegaDados("ARS", "BRL");
                        } else if(opcao == 6){
                            moeda = Api.pegaDados("BRL", "ARS");
                        }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                if(moeda != null){
                    double valorConvertido = moeda.calcularConversao(valor);

                    System.out.println("Valor %.2f [%s] corresponde ao valor final de => %.2f [%s]"
                            .formatted(valor, moeda.getMoedaBase(), valorConvertido, moeda.getMoedaAlvo()));
                }
            } else if(opcao == 7) {
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }
    }
}