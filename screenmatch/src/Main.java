import br.com.joao.screenmetch.modelos.Filme;

public class Main {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.setNome("O meu poderoso chefão");
        meuFilme.setAnoDelancamento(1970);
        meuFilme.setDuracaoEmMinutos(180);

        meuFilme.exibirFichaTecnica();

        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());

    }
}