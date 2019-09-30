package codeexamplesfromslides.bank;

public class BankAccount {
    private int balance = 100;

    public void withdraw(int amount){
        if(!canWithdraw(amount)){
            throw new IllegalArgumentException();
        } else {
            balance -= amount;
        }
    }

    /*
    Will execute code even if there is not enough money in the account --> bad

    public void withdraw(int amount){
        balance -= amount;
    }
    */


    /*
    Will do nothing if you call it with too big amount. Fails silently --> bad

    public void withdraw(int amount){
        if(canWithdraw(amount)){
            balance -= amount;
        }
    }
     */

    /**
     * Needed because other classes like BankReceiptProcess need to react when it can't withdraw (like putting everything in a failed list
     *
     * You could catch the exception but this behaviour (withdrawing too much money) is not exceptional behaviour.
     */
    public boolean canWithdraw(int amount){
        return amount <= balance;
    }
}
