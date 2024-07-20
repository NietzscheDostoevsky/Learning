package Ola;

public class Ola {
	
	String userName; 
	double walletMoney; 
	
	Ola(String userName, double walletMoney){
		this.userName = userName; 
		this.walletMoney = walletMoney; 
	}
	
	Ola() {
		
	}
	
	public void userDetails() {
		System.out.println(userName);
		System.out.println(walletMoney);
	}
}
