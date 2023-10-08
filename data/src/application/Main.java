package application;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
	public static void main(String[] args) {
		LocalDate date_hora_local = LocalDate.now();
		LocalDateTime date_hora_time_local = LocalDateTime.now();
		Instant date_hora_global = Instant.now();
//		
		LocalDate format_date_String_dateISO = LocalDate.parse("2022-07-02");
		LocalDateTime format_date_hora_time_String_data = LocalDateTime.parse("2022-07-20T01:30:26");
		Instant format_date_horario_instant = Instant.parse("2022-07-20T01:30:26Z");
//		
		System.out.println("Data hora local: " + date_hora_local);
		System.out.println("Data hora time local: " + date_hora_time_local);
		System.out.println("Data hora global: " + date_hora_global);
//		
//		// Formata date
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
//		
		LocalDate formate_string_data = LocalDate.parse("25/09/2022", fmt1);
		LocalDateTime formate_string_date_time = LocalDateTime.parse("25/09/2022 01:30", fmt2);
//		
		LocalDate d10 = LocalDate.of(2023, 9, 25);
		LocalDateTime d11 = LocalDateTime.of(2023, 9, 25, 2, 33);
//		
		System.out.println("Data formatada de String ISO para o formato data: " + format_date_String_dateISO);
		System.out.println("Data formatada de String ISO para o formato data: " + format_date_hora_time_String_data);
		System.out.println("Formatar data horario instant: " + format_date_horario_instant);
		System.out.println("Formatar data horario instant: " + format_date_horario_instant_global);
		System.out.println("Formatar data horario pegando uma string: " + formate_string_data);
		System.out.println("Formatar data time horario pegando uma string: " + formate_string_date_time);
		System.out.println("d10: " + d10);
		System.out.println("d11: " + d11);
		
		// retornando em formato string
		
		System.out.println("data hora local: " + date_hora_local.format(fmt1));
		System.out.println("data hora local: " + date_hora_local.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println("data hora local: " + fmt1.format(date_hora_local));
		
		System.out.println("Data hora time local: " + date_hora_time_local.format(fmt1));
		System.out.println("Data hora time local: " + date_hora_time_local.format(fmt2));
//		
		System.out.println("Data hora time local: " + fmt3.format(date_hora_global));
		
		// Converte de global para local
		
		LocalDate d1 = LocalDate.ofInstant(format_date_horario_instant_global, ZoneId.systemDefault());
		LocalDateTime d2 = LocalDateTime.ofInstant(format_date_horario_instant_global, ZoneId.systemDefault());
//		
		System.out.println("d1: " + d1);
		System.out.println("d2: " + d2);
		
		// Calculos com data
		
		LocalDate pastWeekLocalDate = format_date_String_dateISO.minusWeeks(7);
		LocalDate nextWeekLocalDate = format_date_String_dateISO.plusWeeks(7);
		
		System.out.println("past week: " + pastWeekLocalDate);
		System.out.println("next week: " + nextWeekLocalDate);
		
		LocalDateTime pastWeekLocalDateTime = format_date_hora_time_String_data.minusWeeks(7);
		LocalDateTime nextWeekLocalDateTime = format_date_hora_time_String_data.plusWeeks(7);
		
		System.out.println("past week: " + pastWeekLocalDateTime);
		System.out.println("next week: " + nextWeekLocalDateTime);
		
		Instant pastWeekInstant = format_date_horario_instant.minus(7, ChronoUnit.DAYS);
		Instant nextWeekInstant = format_date_horario_instant.plus(7, ChronoUnit.DAYS);
		
		System.out.println("past week: " + pastWeekInstant);
		System.out.println("next week: " + nextWeekInstant);
		
		Duration t1 = Duration.between(pastWeekLocalDateTime, nextWeekLocalDateTime);
		System.out.println("t1 dias: " + t1.toDays());
		
		Duration t2 = Duration.between(pastWeekLocalDate.atStartOfDay(), format_date_String_dateISO.atTime(0, 0));
		System.out.println("t1 dias: " + t2.toDays());
	}
}