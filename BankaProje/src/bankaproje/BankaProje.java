
package bankaproje;

import java.util.Scanner;

public class BankaProje {


    public static Bank banka = new Bank("AK BANK");
    public static Scanner islem = new Scanner(System.in);
    public static void main(String[] args) {
        
        
        
        boolean isActive = true;
	int secim = 1;

	System.out.println(banka.getBankName() + "'a Hosgeldiniz!");

	while (isActive) {
		// Ana menu
		if (secim == 1) {
			System.out.println("Lütfen yapmak istediginiz islemi seciniz!");
			System.out.println("1 -> Hesap Olustur");
			System.out.println("2 -> Hesap Sec");
			System.out.println("8 -> Cekilis");
			System.out.println("9 -> Cıkıs");
			int read = islem.nextInt();

			if (read == 1) {
				secim = 2;
			} else if (read == 2) {
				secim = 3;
			} else if (read == 9) {
				System.out.println("Cıkıs Gerceklesti, iyi Günler.");
				isActive = false;
			} else if (read == 8) {
				System.out.println("!!!İslem YAPILIYOR!!! :)");
				banka.makeSortition();
			} else {
				System.out.println("Lütfen Gecerli Bir islem seciniz!");
			}
		}
		// Hesap Olusturma Paneli
		else if (secim == 2) {
			System.out.println("Lütfen acmak istediginiz hesap turunu Secin.");
			System.out.println("1 -> Kısa Vadeli Hesap");
			System.out.println("2 -> Uzun Vadeli Hesap");
			System.out.println("3 -> Ozel Hesap");
			System.out.println("4 -> Vadesiz Hesap");
			int accountType = islem.nextInt();

			System.out.println("Hesap Baslangıc Bakiyesi Giriniz:");
			float startingBalance = islem.nextFloat();

			if (banka.createAccount(accountType, startingBalance)) {
				secim = 1;
			}
		}
		// Hesap secim Paneli
		else if (secim == 3) {
			System.out.println("--- Bankamıza Kayıtlı Hesaplar ---");
			if (banka.getAccounts().size() < 1) {
				System.out.println("Bankaya Kayıtlı Hesap Bulunamadı!");
				secim = 1;
			} else {
				System.out.println("Asagidaki Hesaplardan Birini seciniz.");
				for (Account account : banka.getAccounts()) {
					System.out.println(account.getID() + " <- ID");
				}

				int temp = islem.nextInt();
				try {
					if (banka.getAccounts().get(temp) != null) {
						banka.setActualAccount(banka.getAccounts().get(temp));
						secim = 4;
					} else {
						System.out.println("Lütfen Gecerli Bir Hesap Numarasini Giriniz");
					}
				} catch (Exception e) {
					System.out.println("Secilen Hesap Numarasini Gecerli Aralikta Degil!");
				}

			}
		}
		// Hesap islemleri
		else if (secim == 4) {
			System.out.println("Lütfen yapmak istediginiz islemi Secin.");
			System.out.println("1 -> Para Yatir");
			System.out.println("2 -> Para Cek");
			System.out.println("3 -> Bakiye Sorgula");
			System.out.println("4 -> Baska Hessaba Para Gonder");
			System.out.println("8 -> Ana menu");
			System.out.println("9 -> Cıkıs");

			int read = islem.nextInt();

			if (read == 1) {
				System.out.println("Yatirilacak Para Miktarini Giriniz:");
				float tutar = islem.nextFloat();
				banka.getActualAccount().deposit(tutar);
			} else if (read == 2) {
				System.out.println("Cekmek istediginiz Para Miktarini Giriniz:");
				float tutar = islem.nextFloat();
				banka.getActualAccount().withdraw(tutar);
			} else if (read == 3) {
				System.out.println("Hesaptaki Guncel Bakiye: " + banka.getActualAccount().getBalance());
			} else if (read == 4) {

			} else if (read == 8) {
				secim = 1;
			} else if (read == 9) {
				System.out.println("Cıkıs Gerceklesti, iyi Günler.");
				isActive = false;
			}
		}
	}
        
        
        
        
    }
    
}
