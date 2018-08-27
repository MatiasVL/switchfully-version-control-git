package nested_classes.code_example00_static_nested_class.v1_public;

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

        private int bonus;

        public BonusCalculator(int bonus) {
            this.bonus = bonus;
        }

        public int getYearlyBonusPay(int salary){
            return (salary + bonus) / MONTHS_PER_YEAR;
        }

    }
}
