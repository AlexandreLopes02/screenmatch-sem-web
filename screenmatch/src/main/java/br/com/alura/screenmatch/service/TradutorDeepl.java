package br.com.alura.screenmatch.service;

import com.deepl.api.DeepLClient;
import com.deepl.api.TextResult;

public class TradutorDeepl {

    private final DeepLClient client;

//     Construtor que recebe a chave da API
    public TradutorDeepl(String apiKey) {
        this.client = new DeepLClient(System.getenv("DEEP_APIKEY"));
    }

//     Método para traduzir
    public String traduzir(String texto, String idiomaAlvo) {
        try {
            TextResult result = client.translateText(texto, null, idiomaAlvo);
            return result.getText();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao traduzir com DeepL: " + e.getMessage(), e);
        }
    }
}
