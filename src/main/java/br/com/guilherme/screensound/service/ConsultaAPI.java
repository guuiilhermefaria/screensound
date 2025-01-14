package br.com.guilherme.screensound.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ConsultaAPI {
    private static final OkHttpClient client = new OkHttpClient();

    public static String obterInformacao(String artistName) throws Exception {
        String url = "https://musicbrainz.org/ws/2/artist?query=" + artistName + "&fmt=json";

        Request request = new Request.Builder()
                .url(url)
                .addHeader("User-Agent", "YourAppName/1.0 (your.email@example.com)") // Inclua um User-Agent
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            return response.body().string();
        }
    }
}
