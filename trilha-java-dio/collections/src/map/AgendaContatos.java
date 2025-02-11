package map;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    public static void main(String[] args) {
        Map<String, Integer> agendaContato = new HashMap<>();

        agendaContato.put("João", 99991111);
        agendaContato.put("Maria", 99992222);
        agendaContato.put("Pedro", 99993333);
        agendaContato.put("Luis", 99994444);
        agendaContato.put("Vitoria", 99995555);
        agendaContato.put("Raquel", 99996666);
        agendaContato.put("Sophia", 99997777);

        System.out.println("Exibir contatos");
        System.out.println(agendaContato);
        System.out.println("|-------------------------------------------------------------|");

        agendaContato.remove("Pedro");
        System.out.println("Exibir contatos");
        System.out.println(agendaContato);
        System.out.println("|-------------------------------------------------------------|");

        Integer numeroTelefone = agendaContato.get("João");
        System.out.println("Exibir número telefone por nome");
        System.out.println(numeroTelefone);
        System.out.println("|-------------------------------------------------------------|");

        Map<String, String> palavrasDeFamosos = new HashMap<>();
        palavrasDeFamosos.put("Winston Churchill", "O sucesso é ir de fracasso em fracasso sem perder o entusiasmo.");
        palavrasDeFamosos.put("John Lennon",
                "A vida é o que acontece enquanto você está ocupado fazendo outros planos.");
        palavrasDeFamosos.put("Albert Einstein", "A única coisa que interfere com meu aprendizado é a minha educação.");
        palavrasDeFamosos.put("Henry Ford",
                "O insucesso é apenas uma oportunidade para recomeçar com mais inteligência.");
        palavrasDeFamosos.put("Mahatma Gandhi", "Seja a mudança que você quer ver no mundo.");
        palavrasDeFamosos.put("Charles Chaplin", "A persistência é o caminho do êxito.");
        palavrasDeFamosos.put("Marie Curie", "Nada na vida deve ser temido, apenas compreendido.");
        palavrasDeFamosos.put("Mahatma", "Você deve ser a própria mudança que deseja ver no mundo.");
        palavrasDeFamosos.put("Platão", "Coragem é saber o que não temer.");
        palavrasDeFamosos.put("Albert", "A criatividade é a inteligência se divertindo.");

        System.out.println("Exibir Frases");
        System.out.println(palavrasDeFamosos);
        System.out.println("|-------------------------------------------------------------|");

        System.out.println("Removendo uma frase");
        palavrasDeFamosos.remove("Albert");
        System.out.println(palavrasDeFamosos);
        System.out.println("|-------------------------------------------------------------|");

        System.out.println("Buscar frase por altor");
        String frase = palavrasDeFamosos.get("Henry Ford");
        System.out.println(frase);
        System.out.println("|-------------------------------------------------------------|");

    }
}
