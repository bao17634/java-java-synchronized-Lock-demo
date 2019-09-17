package synchronized_demo;


import synchronized_demo.entity.Account;

/**
 * @ClassName: AccountOperator
 * @Description: 账户操作
 * @Author: yanrong
 * @Date: 8/28/2019 2:35 PM
 * @Version: 1.0
 */
public class AccountOperator implements Runnable{
    private Account account;
    public AccountOperator(Account account) {
        this.account = account;
    }
    public void run() {
        // 这里面给account加锁
        synchronized (account) {
            //存钱
            account.deposit(500);
            //取钱
            account.withdraw(500);
            System.out.println(Thread.currentThread().getName() + ":" + account.getBalance());
        }
    }
}
