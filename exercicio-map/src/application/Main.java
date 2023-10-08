package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			Map<String, Integer> votos = new HashMap<>();

			while (line != null) {
				String[] list = line.split(",");
				if (votos.containsKey(list[0])) {
					int sum = votos.get(list[0]) + Integer.parseInt(list[1]);
					votos.put(list[0], sum);
				} else {
					votos.put(list[0], Integer.parseInt(list[1]));
				}
				line = br.readLine();
			}

			for (String key : votos.keySet()) {
				System.out.println(key + ": " + votos.get(key));
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			sc.close();
		}
	}

}
