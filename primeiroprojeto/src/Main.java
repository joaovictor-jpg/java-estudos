public class Main {
    public static void main(String[] args) {
        System.out.println("Esse é o Screen Match");
        System.out.println("Filme: Top´Gun: Maverick");

        int anoDeLancamento = 2022;
        System.out.println("Ano de lançamento: " + anoDeLancamento);

        boolean incluidoNoPlano = true;
        System.out.println("Esse filme: Top´Gun: Maverick, está incluso no plano? " + incluidoNoPlano);

        float notaFilme = 8.1f;
        System.out.println("O valor do filme: " + notaFilme);

        double media = (9.8 + 6.3 + 8.0) / 3;
        System.out.println("Média: " + media);

        String sinopse = "Filme de aventura com galã dos anos 80";
        System.out.println("Sinopse: " + sinopse);

        int classificacao = (int) (media / 2);
        System.out.println(classificacao);

        Media.calcularMedia(5, 9);
        Desconto.calcularDesconto();
    }
}