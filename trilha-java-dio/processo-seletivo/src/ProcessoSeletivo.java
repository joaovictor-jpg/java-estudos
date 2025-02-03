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
