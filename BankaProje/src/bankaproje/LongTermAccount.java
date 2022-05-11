/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankaproje;

/**
 *
 * @author HamzaErdal
 */
public class LongTermAccount extends Account{

    private int ID;
    private int interest = 24;
    private float balance;
    
    public LongTermAccount(int ID, float startingBalance){
        this.ID = ID;
        this.balance = startingBalance;
    }
    
    @Override
    void deposit(float amount) {
        this.balance += amount;
        System.out.println(this.ID + "numarali hesabin bakiyesi guncellendi!\nGuncel bakiye: " + 
	Float.toString(this.balance));
	}

    @Override
    void withdraw(float amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(this.ID + "numarali hesabin bakiyesi guncellendi!\nGuncel bakiye: " + 
            Float.toString(this.balance));
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
