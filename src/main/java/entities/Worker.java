package entities;

import enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public void addContract(HourContract contract){
        if(!contractCheck(contract)){
            contracts.add(contract);
        }else{
            throw new IllegalArgumentException("O contrato já foi adicionado!");
        }
    }

    public void removeContract(HourContract contract){
        if(contractCheck(contract)){
            contracts.remove(contract);
        }else{
            throw new IllegalArgumentException("O contrato não existe!");
        }
    }

    public Boolean contractCheck(HourContract contract){
        return contracts.contains(contract);
    }

    public Double income(Integer year, Integer month){
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for (HourContract c : contracts){
            cal.setTime(c.getDate());
            int contractYear = cal.get(Calendar.YEAR);
            int contractMonth = 1 + cal.get(Calendar.MONTH);
            if(year == contractYear && month == contractMonth){
                sum += c.totalValue();
            }
        }
        return sum;
    }

    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
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

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", baseSalary=" + baseSalary +
                '}';
    }
}
