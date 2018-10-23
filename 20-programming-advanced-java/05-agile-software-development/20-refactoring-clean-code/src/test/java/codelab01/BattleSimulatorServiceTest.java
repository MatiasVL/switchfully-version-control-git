package codelab01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BattleSimulatorServiceTest {

    private BattleSimulatorService battleSimulatorService;

    @BeforeEach
    void setupBattleSimulator() {
        battleSimulatorService = new BattleSimulatorService();
    }

    @Test
    void simulateBattle_givenAttackingArmyAttackingStrengthLowerThanDoubleOfDefendingArmyDefendingStrength_thenFalse() {
        // GIVEN
        Army attackingArmy = new Army(new Soldier[]{
                new Soldier(5, 0),
                new Soldier(15, 0)}
        );
        Army defendingArmy = new Army(new Soldier[]{
                new Soldier(0, 6),
                new Soldier(0, 9)}
        );

        // WHEN
        boolean result = battleSimulatorService.simBat(attackingArmy, defendingArmy);

        // THEN
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void simulateBattle_givenAttackingArmyAttackingStrengthDoubleOfDefendingArmyDefendingStrength_thenFalse() {
        // GIVEN
        Army attackingArmy = new Army(new Soldier[]{
                new Soldier(10, 0),
                new Soldier(20, 0)}
        );
        Army defendingArmy = new Army(new Soldier[]{
                new Soldier(0, 5),
                new Soldier(0, 10)}
        );

        // WHEN
        boolean result = battleSimulatorService.simBat(attackingArmy, defendingArmy);

        // THEN
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void simulateBattle_givenAttackingArmyAttackingStrengthMoreThanDoubleOfDefendingArmyDefendingStrength_thenTrue() {
        // GIVEN
        Army attackingArmy = new Army(new Soldier[]{
                new Soldier(10, 0),
                new Soldier(25, 0)}
        );
        Army defendingArmy = new Army(new Soldier[]{
                new Soldier(0, 5),
                new Soldier(0, 5)}
        );

        // WHEN
        boolean result = battleSimulatorService.simBat(attackingArmy, defendingArmy);

        // THEN
        Assertions.assertThat(result).isTrue();
    }

}