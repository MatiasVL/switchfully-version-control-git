package codeexamplesfromslides.bank;

public class BankReceiptProcessor {

    private BankAccount[] failedAccounts = new BankAccount[10];
    private BankAccount[] accountsToProcess;
    private int index = 0;

    public BankReceiptProcessor(BankAccount[] accountsToProcess) {
        this.accountsToProcess = accountsToProcess;
    }

    public static void main(String[] args) {

        BankAccount[] bankAccounts = new BankAccount[]{
                new BankAccount(),
                new BankAccount(),
                new BankAccount(),
                new BankAccount(),
                new BankAccount(),
                new BankAccount()
        };

        new BankReceiptProcessor(bankAccounts).process();
    }

    public void process() {
        for (BankAccount bankAccount : accountsToProcess) {
            if (bankAccount.canWithdraw(100)) {
                bankAccount.withdraw(100);
            } else {
                failedAccounts[index++] = bankAccount;
            }
        }
    }
}
