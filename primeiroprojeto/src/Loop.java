import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        double notaDoFilme = 0.0;
        double mediaDeAvaliacoes = 0.0;

        double mediaAvaliacao = 0;
        double nota = 0;
        int totalDeNotas = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("Diga sua avaliação para o filme");
            notaDoFilme = leitura.nextDouble();
            mediaDeAvaliacoes += notaDoFilme;
        }

        System.out.println("Média de avaliação " + mediaDeAvaliacoes/3);

        while (nota != -1) {
            System.out.println("Diga sua avaliação para o filme ou -1 para encerrar  ");
            nota = leitura.nextDouble();

            if (nota != -1) {
                mediaAvaliacao +=  nota;
                totalDeNotas++;
            }

        }

        System.out.println("Média de avaliações " + mediaAvaliacao / totalDeNotas);
    }
}
