import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        imprimirSeleconados(selecaoCandidatos());
    }

    static void imprimirSeleconados(String[] candidatos) {

        System.out.println();

        System.out.println("Imprimindo a lista de candidatos informado o indice do elemento");
        for (int i = 0; i < candidatos.length; i++) {
            if(candidatos[i] != null) {
                System.out.println("O candidato de Nº " + (i+1) + " é " + candidatos[i]);
            }
        }

        System.out.println();

        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }

    static boolean atendeu() {
        return new Random().nextInt(3)==1;
    }

    static void entrandoEmContato(String candidato) {
        int tentativaRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atendeu();
            continuarTentando = !atendeu;
            if(continuarTentando) {
                tentativaRealizadas++;
            } else {
                System.out.println("Contato realizado com sucesso");;
            }
        } while(continuarTentando && tentativaRealizadas<3);

        if(atendeu) {
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativaRealizadas + " TENTATIVA");
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MÁXIMO DE TENTATIVAS " + tentativaRealizadas + " REALIZADAS");
        }
    }

    static String[] selecaoCandidatos() {
        String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA",
                "DANIEL", "JORGE" };

        String[] candidatosSelecionados = new String[5];

        int candidatoSelecionador = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while (candidatoSelecionador < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato: " + candidato + ", solicitou este valor de salário " + salarioPretendido);

            if (analisarCandidato(salarioPretendido, salarioBase)) {
                candidatosSelecionados[candidatoSelecionador] = candidato;
                candidatoSelecionador++;
            }

            candidatoAtual++;
        }

        return candidatosSelecionados;

    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    } 

    static boolean analisarCandidato(double salarioPretendido, double salarioBase) {
        if (salarioBase >= salarioPretendido) {
            return true;
        } else {
            return false;
        }
    }
}
