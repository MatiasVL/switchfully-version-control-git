package code_example00_static_nested_class.v2_instance;

public class Employee {

    private int salary;
    private static final int MONTHS_PER_YEAR = 13;

    public Employee(int salary) {
        this.salary = salary;
    }

    public int getYearlySalary(){
        return salary * MONTHS_PER_YEAR;
    }

    public static class BonusCalculator {

        private Employee employee;

        public BonusCalculator(Employee employee) {
            this.employee = employee;
        }

        public int getYearlyBonusPay(int bonus){
            return (employee.salary + bonus) / MONTHS_PER_YEAR;
        }

    }
}
