public class Filme {
    String nome;
    int anoDelancamento;
    boolean incluidoNoPlano;
    double somaDasAvaliacoes;
    int totalDeAvaliacoes;
    int duracaoEmMinutos;

    void exibirFichaTecnica() {
        System.out.println("Nome do filme: " + this.nome);
        System.out.println("Ano de lançamento: " + this.anoDelancamento);
    }

    void avalia(double nota) {
        this.somaDasAvaliacoes += nota;
        this.totalDeAvaliacoes++;
    }

    double pegaMedia() {
        return this.somaDasAvaliacoes / this.totalDeAvaliacoes;
    }
}
