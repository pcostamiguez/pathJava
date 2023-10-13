package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner sc = new Scanner(System.in)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat incomeDateFormater = new SimpleDateFormat("MM/yyyy");

            System.out.println("Enter department's name:");
            String workerDepartment = sc.nextLine();
            System.out.println("Enter worker data:");
            System.out.print("Name: ");
            String workerName = sc.nextLine();
            System.out.print("Level: ");
            String workerLevel = sc.nextLine();
            System.out.print("Base salary: ");
            double workerBaseSalary = sc.nextDouble();
            System.out.print("How many contracts to this worker? ");
            int workerNumberOfContracts = sc.nextInt();

            Worker worker = new Worker(workerName,
                    WorkerLevel.valueOf(workerLevel.toUpperCase()),
                    workerBaseSalary,
                    new Department(workerDepartment));

            for (int i = 1; i <= workerNumberOfContracts; i++) {
                System.out.println("Enter contract #" + i + " data:");
                System.out.print("Date (DD/MM/YYYY): ");

                Date contractDate = dateFormat.parse(sc.next());
                System.out.print("Value per hour: ");
                double contractValuePerHour = sc.nextDouble();
                System.out.print("Duration (hours): ");
                int contractHours = sc.nextInt();

                HourContract contract = new HourContract(contractDate, contractValuePerHour, contractHours);
                worker.addContract(contract);
            }

            System.out.print("Enter month and year to calculate income (MM/YYYY): ");

            String monthAndYear = sc.next();
            int incomeMonth = Integer.parseInt(monthAndYear.substring(0, 2));
            int incomeYear = Integer.parseInt(monthAndYear.substring(3));

            System.out.println("Name: " + worker.getName());
            System.out.println("Department: " + worker.getDepartment().getName());
            System.out.println("Income for "    + monthAndYear + ": R$"
                                                + String.format("%.2f", worker.income(incomeYear, incomeMonth)));

        } catch (Exception e) {
            System.out.println("Houve o seguinte erro: " + e.getMessage());
        }
    }
}
