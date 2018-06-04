package nested_classes.code_example00_static_nested_class.v2_instance;

public class EmployeeService {

    public static void main(String[] args) {
        Employee.BonusCalculator bonusCalculator =
                new Employee.BonusCalculator(new Employee(2000));
        bonusCalculator.getYearlyBonusPay(2000);
    }

}
