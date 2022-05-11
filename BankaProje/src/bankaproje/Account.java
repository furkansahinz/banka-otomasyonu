/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankaproje;

/**
 *
 * @author HamzaErdal
 */
abstract class  Account {
    
    abstract void deposit(float amount);
    abstract void withdraw(float amount);
    abstract float getBalance();
    abstract int getID();
    abstract float getBenefit(float amount);
    
    
}
