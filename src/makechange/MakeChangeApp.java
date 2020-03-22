package makechange;


import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {
		
		/* The user is prompted asking for the price of the item. */
		Scanner sc = new Scanner(System.in);
		double totalPrice = 0.0;
		double price = 0.0;
		double cashTendered = 0.0;
		
		
		System.out.print("Welcome to Corner Store. \n");
		//prompt cashier to enter cash tendered by customer
		System.out.println("Enter total price of each item:(0 to cancel order) ");
		price = sc.nextDouble();
		totalPrice  = totalPrice + price;
		
		while(price != 0) {
		System.out.println("Add another one item at a time or 0 for total: ");
		price = sc.nextDouble();
		totalPrice  = totalPrice + price;
		//display item total cash total
		System.out.printf("Total Amount Due: %.2f%n", totalPrice);
		}
		double cashBack = getMoney(cashTendered, totalPrice);	
	}
	
	public static double getMoney(double cashTendered, double totalPrice) {
		Scanner sc = new Scanner(System.in);
		double cashBack = 0.0;
		while(cashTendered <= 0) {
		//System.out.printf("\n Total: "+ totalPrice + "\nCash Total: "+ cashTendered +"\nChange is: %.2f%n", cashBack);
		System.out.println("Enter amount to pay for your items: ");
		cashTendered = cashTendered + sc.nextDouble();
		
		System.out.println("Total paid is : "+ cashTendered);
		}
		
		if(cashTendered == totalPrice) {
			greetingBye(totalPrice, cashTendered);
				
			}
		else if(cashTendered <= totalPrice) {
				tooShort();
		} 
		else if(cashTendered >= totalPrice){
			createChange(cashBack);
		} 
		return cashTendered;
	}	
	
	public static double createChange(double cashBack){
		Scanner sc = new Scanner(System.in);
		double cashTendered = 0.0; 
		double totalPrice = 0.0;
		int twenty = 0;
		int ten = 0;
		int five = 0;
		int one = 0;
		double quarter = 0.0;
		double dime = 0.0;
		double nickel = 0.0;
		double penny = 0.0;
		
		System.out.printf("Total Price: $" + totalPrice + "\nCash Total: $"+ cashTendered + "\nChange is: $ %.2f%n", cashBack);
		
		System.out.println("1: "+ cashBack);
		while(cashBack > 20) {
			twenty++;
			cashBack = (cashBack - 20);
			System.out.println(twenty);
		} 
		System.out.println("2: "+ cashBack);
		while(cashBack > 10) {
			ten++;
			cashBack = cashBack - 10;
			System.out.println(ten);
		}
		System.out.println("3: "+ cashBack);
		while(cashBack > 5) {
			five++;
			cashBack = cashBack - 5;
			System.out.println(five);
		}
		System.out.println("4: "+ cashBack);
		while(cashBack >= 1) {
			one++;
			cashBack = cashBack - 1;
			System.out.println(one);
		}
		System.out.println("5: "+ cashBack);
		while(cashBack < 1.00 && cashBack >= 0.25) {
			quarter++;
			cashBack = (int)((cashBack - 0.25) % 0.25);
			System.out.println(quarter);
		}
		System.out.println("6: "+ cashBack);
		while((cashBack < 0.25) && (cashBack >= 0.10)) {
			dime++;
			cashBack = (int)((cashBack - 0.10) % 0.10);
			System.out.println(dime);
		}
		
		cashBack = (int)(Math.round(cashBack * 100.0) / 100.0);
		System.out.println("7: "+ cashBack);
		while(cashBack < 0.10 && cashBack  >= 0.05 ) {
			nickel++;
			cashBack = (int)((cashBack - 0.05) % 0.05);
			System.out.println(nickel);
		}
		cashBack = (int)(Math.round(cashBack * 100.0) / 100.0);
		
		while(cashBack < 0.05 && cashBack >= 0.00) {
			penny++;
			cashBack = (int)(cashBack - 0.01);
			System.out.println(penny);
		}
		//Testing results
		System.out.println(" Change back: ");
		if(twenty > 0) {
			System.out.println(twenty + " twenty dollar bill, \n");
		}
		else {
		}
		if(ten > 0){
			System.out.println(ten + " ten dollar bill, \n");
		}
		else {
		}
		if(five > 0) {
			System.out.println(five + " five dollar bill, \n");
		}
		else {
		}	if(one > 0) {
			System.out.println(one + " one dollar bill, \n");
		} else {
		}	if(quarter > 1) {
			System.out.println(quarter + " quarters, ");
		} 
		else if(quarter == 1) {
			System.out.println(quarter + " quarter, 'n");
		} else {
		}	
		if(dime > 1) {
			System.out.println(dime + " dimes, \n");
		} else if (dime == 1) {
			System.out.println(dime + " dime, \n");
		} else {
		} if(nickel > 1) {
			System.out.println(nickel + " nickels, \n");
		} else if(nickel == 1){
			System.out.println(nickel+ "nickel \n");
		} else {
		}
		if(penny > 1) {
			System.out.println(penny+ "pennies \n");
		} else if(penny == 1)	{
			System.out.println(penny + " penny.");
		} 
		else {
			System.out.print(" Thank you. ");	
			
		}
		return cashBack;
	}


	public static void printHeader() {
		System.out.println("/////////////////////////////////");
		System.out.println("//////// CORNER STORE ///////////");
		System.out.println("////////  DENVER, CO  ///////////");
	}
	
	
	public static void printReceipt() {
		System.out.println("//////// CORNER STORE ///////////");
		System.out.println("/////////////////////////////////");
		System.out.println(" Come Back To See Us Again! ");
	}
	public static void greetingBye(double totalPrice, double cashTendered) {
		System.out.println("You provided exact change. \nThanks most people don't these days.");
		printHeader();
		System.out.println("Total Items: $"+ totalPrice+ " \n");
		System.out.println("Total Cash: $"+ cashTendered+ " \n");
		printReceipt();
	}
	
	public static void tooShort() {
		System.out.println("Hmm, Would you like to put something back? or Please provide more money. ");
	}
}
