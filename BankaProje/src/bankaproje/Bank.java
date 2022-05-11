/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankaproje;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author HamzaErdal
 */

public class Bank {

    private String bankName;
    private Account actualAccount;
    private List<Account> accounts;
    private int minimumRequiredBalanceShort = 1000;
    private int minimumRequiredBalanceLong = 1500;
    private int minimumRequiredBalanceSpecial;
    private int minimumRequiredBalanceCurrent = 0;
    
    public Bank(String bankName) {
            this.bankName = bankName;
            accounts = new ArrayList<Account>();
}
    
    
    public String getBankName() {
		return bankName;
    }

    public Account getActualAccount() {
            return actualAccount;
    }

    public void setActualAccount(Account actualAccount) {
            this.actualAccount = actualAccount;
    }
    
    public boolean createAccount(int type, float tutar){
        if (type == 1){
            if (tutar >= this.getMinimumRequiredBalanceShort()) {
                Account initialAccount = new ShortTermAccount(this.accounts.size(), tutar);
                this.accounts.add(initialAccount);
                this.actualAccount = initialAccount;
                System.out.println("Hesap Basariyla Olusturuldu!");
                return true;
            }else{
                System.out.println("Kisa Vadeli hesap icin belirtilen minimum bakiye:" + minimumRequiredBalanceShort);
                return false;
            }
        }else if (type == 2) {
            if (tutar >= this.getMinimumRequiredBalanceLong()) {
                Account initialAccount = new LongTermAccount(this.accounts.size(), tutar);
                this.accounts.add(initialAccount);
                this.actualAccount = initialAccount;
                System.out.println("Hesap Basariyla Olusturuldu!");
                return true;
            }else{
                System.out.println("Uzun Vadeli Hesap icin belirtilen minimum bakiye: " + minimumRequiredBalanceLong);
                return false;
            }
        }else if (type == 3){
            if (tutar >= this.getMinimumRequiredBalanceSpecial()){
                Account initialAccount = new SpecialAccount(this.accounts.size(), tutar);
                this.accounts.add(initialAccount);
                this.actualAccount = initialAccount;
                System.out.println("Hesap Basariyla Olusturuldu!");
                return true;
            }else{
                System.out.println("Kisa Vadeli Hesap icin belirtilen minimum bakiye: " + minimumRequiredBalanceSpecial);
                return false;
            }
        }else if (type == 4) {
            if (tutar >= this.getMinimumRequiredBalanceCurrent()) {
                Account initialAccount = new CurrentAccount(this.accounts.size(), tutar);
                this.accounts.add(initialAccount);
                this.actualAccount = initialAccount;
                System.out.println("Hesap Basariyla Olusturuldu!");
                return true;
            }else{
                System.out.println("Kisa Vadeli Hesap icin belirtilen minimum bakiye: " + minimumRequiredBalanceCurrent);
                return false;
            }
        }else{
            System.out.println("Lutfen Gecerli Bir Islem Seciniz!");
            return false;
        }
    }
    
    public List<Account> getAccounts(){
        return this.accounts;
    }
    public int getMinimumRequiredBalanceShort(){
        return minimumRequiredBalanceShort;
    }
    public int getMinimumRequiredBalanceLong(){
        return minimumRequiredBalanceLong;
    }
    public int getMinimumRequiredBalanceSpecial(){
        return minimumRequiredBalanceSpecial;
    }
    public int getMinimumRequiredBalanceCurrent(){
        return minimumRequiredBalanceCurrent;
    }
    
    public void makeSortition(){
        List<SpecialAccount> specialAccounts = new ArrayList<SpecialAccount>();
        List<SpecialAccount> sortitionList = new ArrayList<SpecialAccount>();
        
        //Özel Hesapların Belirlenmesi
        for (Account account : accounts) {
		if (account.getClass() == SpecialAccount.class) {
			specialAccounts.add((SpecialAccount) account);
		}
	}
        //Özel Hesaplarin Carpanlarinin Belirlenmesi
        for (int i = 0; i <= (specialAccounts.size() - 1); i++) {
		for (int times = specialAccounts.get(i).getSortitionPoint(); times >= 1; times--) {
			sortitionList.add(specialAccounts.get(i));
		}
	}
        //Farkli Her ID Numarasinin Bir Kez Yazdirmak icin
        List<Integer> checkedIndex = new ArrayList<Integer>();
        for (SpecialAccount account : sortitionList) {
		if (checkedIndex.contains(account.getID())) {
			continue;
		}
		checkedIndex.add(account.getID());
		System.out.println("ID: " + account.getID() + " | Cekilis Puani: " + account.getSortitionPoint());
		}
        // Kazanani Belirleme --> https://www.baeldung.com/java-random-list-element
        Random random = new Random();
        SpecialAccount winner = sortitionList.get(random.nextInt(sortitionList.size()));
        
        System.out.println("10000 TL'lik odulun sahibi!...");
        try {
		TimeUnit.SECONDS.sleep(1);
		System.out.println("3...");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("2..");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("1.");
		TimeUnit.SECONDS.sleep(1);
	} catch (InterruptedException e) {
		System.out.println("Beklenmedik Bir Hata Oldu :(");
	}
        System.out.println("**^^** Cekilicin kazanani ----------> " + winner.getID() + " Numarali Hesap **^^**");
	winner.deposit(10000);
    }  
}
