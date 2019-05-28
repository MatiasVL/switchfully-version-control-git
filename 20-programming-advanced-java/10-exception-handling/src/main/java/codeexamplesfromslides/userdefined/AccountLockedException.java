package codeexamplesfromslides.userdefined;

public class AccountLockedException extends RuntimeException {

    public AccountLockedException() {
        super("This account is locked. No operations are allowed");
    }
}
