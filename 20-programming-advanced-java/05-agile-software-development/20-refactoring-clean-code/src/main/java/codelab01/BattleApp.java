package codelab01;

public class BattleApp {

    public static void main(String[] args) {

        BattleSimulatorService battleSimulatorService = new BattleSimulatorService();

        Army army1 = new Army(new Soldier[]{
                new Soldier(10, 10),
                new Soldier(15, 5),
                new Soldier(5, 10),
                new Soldier(5, 25)}
        );
        Army army2 = new Army(new Soldier[]{
                new Soldier(5, 5),
                new Soldier(5, 5),
                new Soldier(10, 5)}
        );

        boolean result = battleSimulatorService.simulateBattle(army1, army2);

        System.out.println("Did army 1 defeat army 2? " + result);

    }

}
