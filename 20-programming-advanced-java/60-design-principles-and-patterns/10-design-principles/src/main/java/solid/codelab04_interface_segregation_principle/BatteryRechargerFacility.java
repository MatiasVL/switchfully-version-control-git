package solid.codelab04_interface_segregation_principle;

import solid.codelab04_interface_segregation_principle.workers.Robot;
import solid.codelab04_interface_segregation_principle.workers.Worker;

public class BatteryRechargerFacility {

    public static void rechargeBatteriesOf(Worker[] rechargers) {
        for (Worker recharger : rechargers) {
            // A required check because of our bad design :'(
            if (recharger instanceof Robot) {
                recharger.rechargeBatteries();
            }
        }
    }

}
