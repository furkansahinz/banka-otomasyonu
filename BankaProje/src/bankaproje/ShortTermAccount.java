package bankaproje;

public class ShortTermAccount extends Account{
    
	private int ID;
	private int interest = 17;
	private float balance;
        
	public ShortTermAccount(int ID, float startingBalance) {
		this.ID = ID;
		this.balance = startingBalance;
	}

    @Override
    void deposit(float amount) {
        this.balance += amount;
	System.out.println(
			this.ID + " numarali hesabin bakiyesi guncellendi!\nGuncel bakiye: " + 
                        Float.toString(this.balance));
    }

    @Override
    void withdraw(float amount) {
        if (amount <= balance) {
		balance -= amount;
		System.out.println(this.ID + " numarali hesabin bakiyesi guncellendi!\nGuncel bakiye: "
				+ Float.toString(this.balance));
	} else {
		System.out.println("Hesapta yeterli bakiye bulunamadi, islem basarili!");
	}
    }

    @Override
    float getBalance() {
        return this.balance;
    }

    @Override
    int getID() {
        return this.ID;
    }

    @Override
    float getBenefit(float amount) {
        return this.balance;
    }
    
}
