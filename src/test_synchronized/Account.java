package test_synchronized;

/**
 * @ClassName: Account
 * @Description: 银行账户
 * @Author: yanrong
 * @Date: 8/28/2019 2:34 PM
 * @Version: 1.0
 */
class Account {
    String name;
    float amount;
    public Account(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }


    //存钱方法
    public  void deposit(float amt) {
        amount += amt;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //取钱方法
    public  void withdraw(float amt) {
        amount -= amt;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public float getBalance() {
        return amount;
    }
}


