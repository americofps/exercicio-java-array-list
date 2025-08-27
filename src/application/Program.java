package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();

		System.out.println("How many employees will be registered? ");
		int n = sc.nextInt();

		for (int i=1; i<=n; i++) {
			System.out.println();
			System.out.println("Employee #" + i + ": ");

			System.out.print("Id: ");
			int id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.print("Id already exists, please try again: ");
				id = sc.nextInt();
			}
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			Employee emp = new Employee(id, name, salary);
			list.add(emp);
		}
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase : ");
		int idIncrease = sc.nextInt();
		System.out.print("Enter the percentage:");
		double percentage = sc.nextDouble();
		double newSalary = 0.0;
		System.out.println();

		for(Employee employed : list) {
			if(employed.getId() == idIncrease) {
				newSalary = employed.increaseSalary(percentage, employed.getSalary());
				employed.setSalary(newSalary);
				break;
			} else {
				System.out.println("This id does not exist!");
			}
		}
		System.out.println();
		for(Employee employed : list) {
			if(employed.getId()!=0) {
				System.out.println(employed);
			}
		}
		sc.close();
	}

	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId()== id).findFirst().orElse(null);
		return emp != null;
	}
}
