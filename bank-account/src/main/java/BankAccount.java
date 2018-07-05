class BankAccount {

    private boolean isOpen;
    private int balance;

    /**
     * Opens the bank account
     */
    void open() {
        isOpen = true;
        balance = 0;
    }

    /**
     * Closes the bank account
     */
    void close() {
        isOpen = false;
        balance = 0;
    }

    /**
     * Withdraws the given amount from the account. Synchronized for thread safety.
     * @param amountToWithdraw - The amount of money to withdraw from the bank account.
     * @throws BankAccountActionInvalidException - If the account is closed
     *                                           - If the account is empty
     *                                           - If the amount given as a parameter is negative
     *                                           - If the amount given as a parameter is more than the balance of the account
     */
    synchronized void withdraw(int amountToWithdraw) throws BankAccountActionInvalidException {
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
        balance -= amountToWithdraw;
    }

    /**
     * Deposits the amount of money given as a parameter into the account. Synchronized for thread safety.
     * @param amountToDeposit - The amount of money to deposit into the account
     * @throws BankAccountActionInvalidException - If the account is closed
     *                                           - If the amount given as a parameter is negative
     */
    synchronized void deposit(int amountToDeposit) throws BankAccountActionInvalidException {
        if (!isOpen) {
            throw new BankAccountActionInvalidException("Account closed");
        }
        if (amountToDeposit < 0) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
        balance += amountToDeposit;
    }

    /**
     * Getter method for the account balance
     * @return Returns the current balance of the account
     * @throws BankAccountActionInvalidException - If the account is closed
     */
    int getBalance() throws BankAccountActionInvalidException {
        if (!isOpen) {
            throw new BankAccountActionInvalidException("Account closed");
        }
        return balance;
    }
}
