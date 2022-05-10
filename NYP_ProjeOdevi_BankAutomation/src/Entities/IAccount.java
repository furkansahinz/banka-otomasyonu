package Entities;

public interface IAccount {

	public void deposit(float amount);

	public void withdraw(float amount);

	public float getBalance();

	public int getID();

	public float getBenefit();

}
