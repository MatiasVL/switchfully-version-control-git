package nested_classes.code_example00_static_nested_class.v3_private;

public class Employee {

    private BonusCalculator bonusCalculator;
    private int salary;
    private static final int MONTHS_PER_YEAR = 13;

    public Employee(int salary, int bonus) {
        this.salary = salary;
        bonusCalculator = new BonusCalculator(bonus);
    }

    public int getYearlySalary(){
        return salary * MONTHS_PER_YEAR;
    }

    public int getYearlyBonus(){
        return bonusCalculator.getYearlyBonusPay(salary);
    }

    private static class BonusCalculator {

        private int bonus;

        public BonusCalculator(int bonus) {
            this.bonus = bonus;
        }

        public int getYearlyBonusPay(int salary){
            return (salary + bonus) / MONTHS_PER_YEAR;
        }

    }
}
