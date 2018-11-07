package solid.solution_codelab04_interface_segregation_principle;

import solid.solution_codelab04_interface_segregation_principle.employees.behavior.Rechargeable;

import static java.util.stream.Stream.of;

public class BatteryRechargerFacility {

    public static void rechargeBatteriesOf(Rechargeable[] rechargers) {
        of(rechargers)
                .forEach(Rechargeable::rechargeBatteries);
    }

}
