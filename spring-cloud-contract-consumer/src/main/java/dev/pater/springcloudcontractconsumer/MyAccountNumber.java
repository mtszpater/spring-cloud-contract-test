package dev.pater.springcloudcontractconsumer;

public class MyAccountNumber {

    public MyAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public MyAccountNumber() {
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    private long accountNumber;
}
