package code_example00_static_nested_class.v1_public;

public class EmployeeService {

    public static void main(String[] args) {
        Employee.BonusCalculator bonusCalculator =
                new Employee.BonusCalculator(250);
        bonusCalculator.getYearlyBonusPay(2000);
    }

}
