package map;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import map.entities.Evento;

public class AgendaEventos {
    public static void main(String[] args) {
        Map<LocalDate, Evento> eventosMap = new HashMap<>();

        eventosMap.put(LocalDate.of(2025, 5, 10), new Evento("Festival de Música", "Banda XYZ"));
        eventosMap.put(LocalDate.of(2025, 7, 20), new Evento("Feira Tecnológica", "Palestrante John Doe"));
        eventosMap.put(LocalDate.of(2025, 9, 12), new Evento("Exposição de Arte", "Artista Ana Souza"));
        eventosMap.put(LocalDate.of(2025, 6, 15), new Evento("Conferência de Negócios", "CEO da Startup ABC"));
        eventosMap.put(LocalDate.of(2025, 8, 5), new Evento("Show de Comédia", "Comediante Carlos Silva"));

        System.out.println("Exibir lista de eventos");
        System.out.println(eventosMap);
        System.out.println("|-----------------------------------------------------------------------------|");

        System.out.println("Exibir evento por data");
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        System.out.println(eventosTreeMap);
        System.out.println("|-----------------------------------------------------------------------------|");

        System.out.println("Retorna o próximo evento");
        LocalDate dataAtual = LocalDate.now();
        for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                System.out.println("O próximo evento: " + entry.getValue() + " acontecerá na data " + entry.getKey());
                break;
            }
        }
    }
}
