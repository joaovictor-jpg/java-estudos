import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Entrada do saldo inicial
        double saldoInicial = scanner.nextDouble();

        scanner.nextLine();

        // TODO: Na linha abaixo, implemente a entrada das três transações:
        double entradaDeValores = entradaDosValores(scanner);

        // TODO: Na linha abaixo, realize o cálculo do saldo final:
        double saldoFinal = extrato(saldoInicial, entradaDeValores);

        // Saldo final
        System.out.printf("%.2f\n", saldoFinal);

        scanner.close();
    }

    private static double extrato(double saldoInicial, double entradaDeValores) {
        if (entradaDeValores < 0) {
            return saldoInicial + entradaDeValores;
        } else if (saldoInicial == 0) {
            return entradaDeValores;
        } else {
            return saldoInicial - entradaDeValores;
        }
    }

    private static double entradaDosValores(Scanner scanner) {
        double valor = 0.0;
        for (int i = 0; i < 3; i++) {
            valor += scanner.nextDouble();
        }

        return valor;
    }
}
