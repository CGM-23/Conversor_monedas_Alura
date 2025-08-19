import java.util.Scanner;
import com.google.gson.JsonObject;

public class Menu {

    private static double tasa(JsonObject rates, String code) {
        if (rates == null) {
            throw new IllegalArgumentException("rates es null");
        }
        if (rates.has(code)) {
            return rates.get(code).getAsDouble();
        }
        throw new IllegalArgumentException("No se encontró la tasa para: " + code);
    }

    public static double convertirMoneda(double monto, double tasaDeCambio) {
        return monto * tasaDeCambio;
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);

        JsonObject rates = Conversor_API.cargarTasasBase();
        double PEN = tasa(rates, "PEN");
        double BRL = tasa(rates, "BRL");
        double COP = tasa(rates, "COP");
        double ARS = tasa(rates, "ARS");

        while (true) {
            System.out.println("""
            ╔═══════════════════════════════════════════════════════╗
            ║                 MENÚ DE CONVERSOR DE MONEDAS          ║
            ╠═══════════════════════════════════════════════════════╣
            ║ 1) Dólar              => Sol peruano                  ║
            ║ 2) Sol peruano        => Dólar                        ║
            ║ 3) Dólar              => Real brasileño               ║
            ║ 4) Real brasileño     => Dólar                        ║
            ║ 5) Dólar              => Peso colombiano              ║
            ║ 6) Peso colombiano    => Dólar                        ║
            ║ 7) Dólar              => Peso argentino               ║
            ║ 8) Peso argentino     => Dólar                        ║
            ║ 9) Salir                                              ║
            ╚═══════════════════════════════════════════════════════╝
            """);
            System.out.print("Elige una opción para convertir: ");
            String op = sc.nextLine().trim();
            if ("9".equals(op)) {
                System.out.println("¡Hasta luego!");
                return;
            }
            if (!op.matches("[1-8]")) {
                System.out.println("Opción inválida.");
                continue;
            }

            try {
                System.out.print("Monto: ");
                double monto = Double.parseDouble(sc.nextLine().trim().replace(",", "."));

                switch (op) {
                    case "1" -> System.out.printf("%.2f USD = %.2f PEN%n", monto, convertirMoneda(monto, PEN));
                    case "2" -> System.out.printf("%.2f PEN = %.2f USD%n", monto, monto / PEN);
                    case "3" -> System.out.printf("%.2f USD = %.2f BRL%n", monto, convertirMoneda(monto, BRL));
                    case "4" -> System.out.printf("%.2f BRL = %.2f USD%n", monto, monto / BRL);
                    case "5" -> System.out.printf("%.2f USD = %.2f COP%n", monto, convertirMoneda(monto, COP));
                    case "6" -> System.out.printf("%.2f COP = %.2f USD%n", monto, monto / COP);
                    case "7" -> System.out.printf("%.2f USD = %.2f ARS%n", monto, convertirMoneda(monto, ARS));
                    case "8" -> System.out.printf("%.2f ARS = %.2f USD%n", monto, monto / ARS);
                }

                System.out.print("¿Quieres hacer otra conversión? (s/n): ");
                String continuar = sc.nextLine().trim().toLowerCase();
                if (!continuar.equals("s")) {
                    System.out.println("¡Gracias por usar el conversor!");
                    break;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Entrada invalida. Debes ingresar un numero.");
            }
        }
    }
}
