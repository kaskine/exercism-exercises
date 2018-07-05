class BankAccount {

    private boolean isOpen;
    private int balance;

    void open() {
        synchronized (this) {
            isOpen = true;
            balance = 0;
        }
    }

    void close() {
        synchronized (this) {
            isOpen = false;
            balance = 0;
        }
    }

    void withdraw(int amountToWithdraw) throws BankAccountActionInvalidException {
        if (!isOpen) {
            throw new BankAccountActionInvalidException("Account closed");
        }
        if (balance == 0) {
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        }
        if (amountToWithdraw < 0) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
        if (amountToWithdraw > balance) {
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        }
        synchronized (this) {
            balance -= amountToWithdraw;
        }
    }

    void deposit(int amountToDeposit) throws BankAccountActionInvalidException {
        if (!isOpen) {
            throw new BankAccountActionInvalidException("Account closed");
        }
        if (amountToDeposit < 0) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
        synchronized (this) {
            balance += amountToDeposit;
        }
    }

    int getBalance() throws BankAccountActionInvalidException {
        if (!isOpen) {
            throw new BankAccountActionInvalidException("Account closed");
        }
        synchronized (this) {
            return balance;
        }
    }
}
