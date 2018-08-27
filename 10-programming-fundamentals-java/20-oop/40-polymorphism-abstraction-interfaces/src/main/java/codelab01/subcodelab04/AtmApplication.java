package codelab01.subcodelab04;

import codelab01.subcodelab04.banking.SimpleBanking;

/**
 * Instead of passing AtmMachine an instance of SimpleBanking,
 * pass it an instance of your own, new, implementation of BankingFacade
 * However, start by executing the current code.
 */
public class AtmApplication {

    public static void main(String[] args) {
        double startingBalance = 250;
        new AtmMachine(new SimpleBanking(startingBalance));
    }

}
