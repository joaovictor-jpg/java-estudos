package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.entities.Employees;

public class Main {
	public static void main(String[] args) {
		
		List<Employees> list = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\joao\\Desktop\\in.CSV"))) {
			
			String employeeCSV = br.readLine();
			while(employeeCSV != null) {
				String[] vet = employeeCSV.split(",");
				list.add(new Employees(vet[0], Double.parseDouble(vet[1])));
				employeeCSV = br.readLine();
			}
			
			Collections.sort(list);
			
			for (Employees employees : list) {
				System.out.println(employees.getName() + ", " + String.format("%.2f", employees.getWage()));
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
