package Entities;

public class CurrentAccount implements IAccount {

	private int ID;
	private float interest = 0;
	private float balance;

	public CurrentAccount(int ID, float startingBalance) {
		this.ID = ID;
		this.balance = startingBalance;
	}

	@Override
	public void deposit(float amount) {

		this.balance += amount;
		System.out.println(
				this.ID + " numarali hesabin bakiyesi guncellendi!\nGuncel bakiye: " + Float.toString(this.balance));
	}

	@Override
	public void withdraw(float amount) {
		if (amount <= balance) {
			balance -= amount;
			System.out.println(this.ID + " numarali hesabin bakiyesi guncellendi!\nGuncel bakiye: "
					+ Float.toString(this.balance));
		} else {
			System.out.println("Hesapta yeterli bakiye bulunamadi, islem basarisiz!");
		}
	}

	@Override
	public float getBalance() {
		return this.balance;
	}

	@Override
	public int getID() {
		return this.ID;
	}

	@Override
	public float getBenefit() {
		return this.balance;
	}

}
