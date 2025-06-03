import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateApiGet {

    public static void main(String[] args) {
        // Sua chave da API e a URL do endpoint
        String apiKey = "e7ef617e77a9d805afd715ae";
        String baseUrl = "https://v6.exchangerate-api.com/v6/";
        String endpoint = "/latest/USD"; // Exemplo para obter as taxas mais recentes baseadas em USD

        String fullUrl = baseUrl + apiKey + endpoint;

        // Cria uma instância do HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Constrói a requisição HTTP GET
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fullUrl)) // Define a URL da requisição
                .GET() // Define o método como GET
                .header("Accept", "application/json") // Opcional: Solicita resposta em JSON
                .build();

        try {
            // Envia a requisição e obtém a resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Imprime o código de status da resposta
            System.out.println("Código de Resposta: " + response.statusCode());

            // Imprime o corpo da resposta (que deve ser o JSON com as taxas de câmbio)
            System.out.println("Resposta da API:\n" + response.body());

        } catch (Exception e) {
            // Trata possíveis erros que podem ocorrer durante a requisição
            System.err.println("Ocorreu um erro ao fazer a requisição HTTP:");
            e.printStackTrace();
        }
    }
}
