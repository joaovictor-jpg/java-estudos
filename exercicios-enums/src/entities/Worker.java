package entities;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	private Department deprecated;
	private List<HourContract> contracts = new ArrayList<HourContract>();

	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department deprecated) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.deprecated = deprecated;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public void addContract(HourContract contract) {
		this.contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		this.contracts.remove(contract);
	}

	public Department getDeprecated() {
		return deprecated;
	}

	public void setDeprecated(Department deprecated) {
		this.deprecated = deprecated;
	}

	public Double income(Integer year, Integer month) throws ParseException {

		Calendar cal = Calendar.getInstance();
		
		Double sum = 0.0;

		for (HourContract hourContract : contracts) {
			cal.setTime(hourContract.getDate());
			if (cal.get(Calendar.YEAR) == year && (1 + cal.get(Calendar.MONTH)) == month) {
				sum += hourContract.totalValue();
			}
		}
		
		return sum + this.baseSalary;
	}

}
