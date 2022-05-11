/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankaproje;

/**
 *
 * @author HamzaErdal
 */
public class SpecialAccount extends Account{
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
    void deposit(float amount) {
        this.balance += amount;
        System.out.println(
                this.ID + " numarali hesabin bakiyesi guncellendi!\nGuncel bakiye: " + 
                        Float.toString(this.balance));
        checkSortitionPoint();
    }

    @Override
    void withdraw(float amount) {
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

    private void checkSortitionPoint() {
        this.sortitionPoint = (int) (this.balance / 2000);
	System.out.println(this.ID + " numarali hesabin cekilis puani -> " + 
                this.sortitionPoint);
    }
    public int getSortitionPoint() {
	return sortitionPoint;
}
    
}
