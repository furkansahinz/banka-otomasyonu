package Entities;

public class SpecialAccount implements IAccount {

	private int ID;
	private int interest = 12;
	private float balance;
	private int sortitionPoint = 0;

	public SpecialAccount(int ID, float startingBalance) {
		this.ID = ID;
		this.balance = startingBalance;
		checkSortitionPoint();
	}

	@Override
	public void deposit(float amount) {

		this.balance += amount;
		System.out.println(
				this.ID + " numarali hesabin bakiyesi guncellendi!\nGuncel bakiye: " + Float.toString(this.balance));
		checkSortitionPoint();
	}

	@Override
	public void withdraw(float amount) {
		if (amount <= balance) {
			balance -= amount;
			System.out.println(this.ID + " numarali hesabin bakiyesi guncellendi!\nGuncel bakiye: "
					+ Float.toString(this.balance));
			checkSortitionPoint();
		} else {
			System.out.println("Hesapta yeterli bakiye bulunamadi, islem basarili!");
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

	private void checkSortitionPoint() {
		this.sortitionPoint = (int) (this.balance / 2000);
		System.out.println(this.ID + " numarali hesabin cekilis puani -> " + this.sortitionPoint);
	}

	public int getSortitionPoint() {
		return sortitionPoint;
	}

}
