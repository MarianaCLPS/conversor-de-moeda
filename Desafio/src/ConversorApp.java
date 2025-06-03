import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("********************************************");
            System.out.println("Seja bem-vindo(a) ao Conversor de Moedas!");
            System.out.println("********************************************");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileiro");
            System.out.println("4) Real brasileiro => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Sair");
            System.out.print("Escolha uma opção válida: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> converter(scanner, "Dólar", "Peso argentino", 905.50);
                case 2 -> converter(scanner, "Peso argentino", "Dólar", 1 / 905.50);
                case 3 -> converter(scanner, "Dólar", "Real brasileiro", 5.20);
                case 4 -> converter(scanner, "Real brasileiro", "Dólar", 1 / 5.20);
                case 5 -> converter(scanner, "Dólar", "Peso colombiano", 3900.00);
                case 6 -> converter(scanner, "Peso colombiano", "Dólar", 1 / 3900.00);
                case 7 -> System.out.println("Saindo do conversor...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 7);

        scanner.close();
    }

    public static void converter(Scanner scanner, String de, String para, double taxa) {
        System.out.printf("Digite o valor em %s: ", de);
        double valor = scanner.nextDouble();
        double convertido = valor * taxa;
        System.out.printf("Valor convertido em %s: %.2f\n", para, convertido);
    }
}








