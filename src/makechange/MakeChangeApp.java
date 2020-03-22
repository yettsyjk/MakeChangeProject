package makechange;


import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {
		
		getPrice();	
	}
	
	public static double getPrice() {
		/* The user is prompted asking for the price of the item. */
		Scanner sc = new Scanner(System.in);
		double totalPrice = 0.0;
		double price = 0.0;
		
		System.out.print("Welcome to Corner Store. \n");
		System.out.println("Enter total price of each item:(0 to cancel order) ");
		price = sc.nextDouble();
		totalPrice  = totalPrice + price;
		
		while(price != 0) {
		System.out.println("Add another one item at a time or 0 for total: ");
		price = sc.nextDouble();
		totalPrice  = totalPrice + price;
		//display item total and cash total
		System.out.printf("Total Amount Due: %.2f%n", totalPrice);
		}
		//prompt cashier to enter cash tendered by customer

		getMoney();
		return price;
	}
	
	
	public static double getMoney() {
		Scanner sc = new Scanner(System.in);

		double cashTendered = 0.0;
		double totalPrice = 0.0;
		
		//System.out.printf("\n Total: "+ totalPrice + "\nCash Total: "+ cashTendered +"\nChange is: %.2f%n", cashBack);
		System.out.println("Enter amount to pay for your items: ");
		cashTendered = cashTendered + sc.nextDouble();
		
		System.out.println("Total paid is : "+ cashTendered);
		while(true) {
			
			if(cashTendered == 0) {
				greetingBye();
				break;
			} else if(cashTendered <= 0) {
				tooShort();
			} else {
				createChange(cashTendered, totalPrice);
				break;
			}
		}

		return cashTendered;
		
	
	}
	
	public static double createChange(double cashTendered, double totalPrice){
		Scanner sc = new Scanner(System.in);
		double cashBack = (cashTendered - totalPrice);
		int twenty = 0;
		int ten = 0;
		int five = 0;
		int one = 0;
		double quarter = 0.0;
		double dime = 0.0;
		double nickel = 0.0;
		double penny = 0.0;
		
		System.out.printf("Total Price: $" + totalPrice + "\nCash Total: $"+ cashTendered + "\nChange is: $ %.2f%n", cashBack);
		
		while(cashTendered > 20) {
			twenty++;
			cashBack = (cashBack - 20);
			System.out.println(twenty);
		} 
		while(cashTendered > 10) {
			ten++;
			cashTendered = cashTendered - 10;
			System.out.println(ten);
		}
		while(cashTendered > 5) {
			five++;
			cashTendered = cashTendered - 5;
			System.out.println(five);
		}
		while(cashTendered >= 1) {
			one++;
			cashTendered = cashTendered - 1;
			System.out.println(one);
		}
		while(cashTendered < 1.00 && cashTendered >= 0.25) {
			quarter++;
			cashTendered = (int)((cashTendered - 0.25) % 0.25);
			System.out.println(quarter);
		}
		while((cashTendered < 0.25) && (cashTendered >= 0.10)) {
			dime++;
			cashTendered = (int)((cashTendered - 0.10) % 0.10);
			System.out.println(dime);
		}
		cashTendered = (int)(Math.round(cashTendered * 100.0) / 100.0);
		System.out.println(cashTendered);
		while(cashTendered < 0.10 && cashTendered  >= 0.05 % 0.05) {
			nickel++;
			cashTendered = (int)((cashTendered - 0.05) % 0.05);
			System.out.println(nickel);
		}
		cashTendered = (int)(Math.round(cashTendered * 100.0) / 100.0);
		while(cashTendered < 0.05 && cashTendered >= 0.00) {
			penny++;
			cashTendered = (int)(cashTendered - 0.01);
			System.out.println(penny);
		}
		System.out.println(" Change back: ");
		if(twenty > 0) {
			System.out.println(twenty + " twenty dollar bill, \n");
		}
		else if(ten > 0){
			System.out.println(ten + " ten dollar bill, \n");
		}
		else if(five > 0) {
			System.out.println(five + " five dollar bill, \n");
		}
		else if(one > 0) {
			System.out.println(one + " one dollar bill, \n");
		} else if(quarter > 1) {
			System.out.println(quarter + " quarters, ");
		} else if(quarter == 1) {
			System.out.println(quarter + " quarter, 'n");
		} else if(dime > 1) {
			System.out.println(dime + " dimes, \n");
		} else if (dime == 1) {
			System.out.println(dime + " dime, \n");
		} else if(nickel > 1) {
			System.out.println(nickel + " nickel, \n");
		} else if(penny > 1) {
			System.out.println(penny);
		} else if(penny == 1)	{
			System.out.println(penny + " penny.");
		} else {
			System.out.print(" Thank you. ");
			
		}
		return cashTendered;
		
	}

	

	public static void printHeader() {
		System.out.println("/////////////////////////////////");
		System.out.println("//////// CORNER STORE ///////////");
		System.out.println("////////  DENVER, CO  ///////////");
	}
	
	
	public static void printReceipt() {
		System.out.println("//////// CORNER STORE ///////////");
		System.out.println("/////////////////////////////////");
	}
	public static void greetingBye() {
		System.out.println("You provided exact change. Thanks most people don't these days.");
		printHeader();
		printReceipt();
	}
	
	public static void tooShort() {
		System.out.println("Please provide more money or would you like to put something back:");
	}
}
