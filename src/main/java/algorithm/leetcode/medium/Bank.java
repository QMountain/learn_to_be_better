package algorithm.leetcode.medium;

public class Bank {

    public long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 > balance.length || account1 < 1) {
            return false;
        }
        if (account2 > balance.length || account2 < 1) {
            return false;
        }
        if (balance[account1 - 1] >= money) {
            balance[account1-1] -= money;
            balance[account2-1] = balance[account2 - 1]+money;
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if (account > balance.length || account < 1) {
            return false;
        }
        balance[account-1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > balance.length || account < 1) {
            return false;
        }
        long left = balance[account - 1];
        if (left >= money) {
            balance[account-1] -= money;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Bank bank = new Bank(new long[]{10L,100L,20L,50L,30L});
        System.out.println(bank.withdraw(3, 10));
        System.out.println(bank.transfer(5, 1, 20));
        System.out.println(bank.deposit(5, 20));
        System.out.println(bank.transfer(3, 4, 15));
        System.out.println(bank.withdraw(10, 50));

        Bank bank2 = new Bank(new long[]{0L});
        System.out.println(bank2.deposit(1, 1000000000000L));
        System.out.println(bank2.transfer(1, 1, 1000000000000L));
        System.out.println(bank2.withdraw(1, 1000000000000L));
        System.out.println(bank2.deposit(1, 0L));
        System.out.println(bank2.transfer(1, 1,0));
        System.out.println(bank2.withdraw(1,0));

        Bank bank3 = new Bank(new long[]{0L});
        System.out.println(bank3.deposit(1, 2));
        System.out.println(bank3.transfer(1, 1, 1));
        System.out.println(bank3.transfer(1, 1,3));
    }
}
