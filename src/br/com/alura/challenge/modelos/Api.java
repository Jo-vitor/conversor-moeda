package br.com.alura.challenge.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {

    public static Moeda pegaDados(String moedaBase, String moedaAlvo) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        URI minhaUri = URI.create("https://v6.exchangerate-api.com/v6/968be5e8857c8d12a2ef6275/pair/" + moedaBase + "/" + moedaAlvo);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(minhaUri)
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new Gson();
        MoedaExchangeRate moedaExchangeRate = gson.fromJson(json, MoedaExchangeRate.class);

        Moeda moeda = new Moeda(moedaExchangeRate);

        return moeda;
    }
}
