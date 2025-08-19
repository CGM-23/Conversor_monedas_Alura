import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor_API {
    private static final String apiKey = "28375bbf58899ec8bcaa44c2";
    public static JsonObject cargarTasasBase() {
        String url = "https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/USD";
        try {
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build(); // GET implicito
            HttpResponse<String> response = cliente
                    .send(request, HttpResponse.BodyHandlers.ofString());
            var json = response.body();
            Gson gson = new Gson();
            JsonObject root = gson.fromJson(json, JsonObject.class);

            if (response.statusCode() != 200 ||
                    root == null ||
                    !"success".equals(root.get("result").getAsString())) {
                throw new RuntimeException("No se pudo obtener la tasa: " + json);
            }
            JsonObject rates = root.getAsJsonObject("conversion_rates");
            if (rates == null) throw new RuntimeException("Faltan conversion_rates.");
            return rates;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
