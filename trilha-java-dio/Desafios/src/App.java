import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double saldo = scanner.nextDouble();

        if (saldo < 0.00) {
            System.out.println("Negativado");
        } else if (saldo <= 500.0) {
            System.out.println("Baixo");
        } else {
            System.out.println("Confortavel");
        }

        scanner.close();
    }
}
