package listWorking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.add("Maria");
		list.add("Alex");
		list.add("Bob");
		list.add("Anna");

//		list.add(2, "Marcos");

//		list.remove("Anna");

//		list.remove(1);

		for (String nome : list) {
			System.out.println(nome);
		}

		System.out.println("|-----------------------------------------------|");

		list.removeIf(nome -> nome.charAt(0) == 'M');
		for (String nome : list) {
			System.out.println(nome);
		}

		System.out.println("|-----------------------------------------------|");

		System.out.println("Index of Bob: " + list.indexOf("Bob"));

		System.out.println("|-----------------------------------------------|");

		List<String> result = list.stream().filter(nome -> nome.charAt(0) == 'A').collect(Collectors.toList());
		for (String nome : result) {
			System.out.println(nome);
		}

		System.out.println("|-----------------------------------------------|");
		
		String nome = list.stream().filter(name -> name.charAt(0) == 'A').findFirst().orElse(null);
		System.out.println(nome);

	}
}
