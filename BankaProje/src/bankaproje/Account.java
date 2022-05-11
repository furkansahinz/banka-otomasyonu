package bankaproje;

abstract class  Account {
    
    abstract void deposit(float amount);
    abstract void withdraw(float amount);
    abstract float getBalance();
    abstract int getID();
    abstract float getBenefit(float amount);
    
    
}
