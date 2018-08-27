package nested_classes.code_example00_static_nested_class.v3_private;

public class EmployeeService {

    public static void main(String[] args) {

        Employee employee = new Employee(2000, 250);
        int yearlyBonus = employee.getYearlyBonus();
        System.out.println(yearlyBonus);

        // This code will not compile
//        Employee.BonusCalculator bonusCalculator =
//        new Employee.BonusCalculator(250);

    }

}
