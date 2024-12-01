import modal.Calculadora;
import modal.Musica;
import modal.Pessoa;

public class Main {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.nome = "O meu poderoso chefão";
        meuFilme.anoDelancamento = 1970;
        meuFilme.duracaoEmMinutos = 180;

        meuFilme.exibirFichaTecnica();

        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println(meuFilme.somaDasAvaliacoes);
        System.out.println(meuFilme.totalDeAvaliacoes);
        System.out.println(meuFilme.pegaMedia());

        Pessoa.saudacao();

        double valor = Calculadora.dobrarValor(8);
        System.out.println(valor);

        Musica musica = new Musica();

        musica.titulo = "MEU CARRO NÃO TEM PORTA";
        musica.artista = "LUVASDJ DIEGO O ÚNICO";
        musica.anoLancamento = 2024;
        musica.avaliacao = 5.4;
        musica.numAvaliacoes = 5;

        System.out.println(musica.toString());

    }
}