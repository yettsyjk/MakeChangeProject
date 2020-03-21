package makechange;

import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {
		/* The user is prompted asking for the price of the item. */
		Scanner sc = new Scanner(System.in);
		
		double price = 0.0, change = 0.0, cashTendered = 0.0;
		double cashBack = 0.0, amount = 0.0, cashLeft = 0.0;
		double totalPrice = 0.0;
		double quarters = 0.0, dimes= 0.0, nickles = 0.0, pennies = 0.0;
		int ones, fives, tens, twenties;
		
		//constant change in register
		double quartersToCust = 0.25;
		double dimesToCust = 0.10;
		double nicklesToCust = 0.05;
		double penniesToCust = 0.01;
		double onesToCust = 1.00;
		double fivesToCust = 5.00;
		double tensToCust = 10.00;
		double twentiesToCust = 20.00;
		
		
		System.out.print("Welcome to SD Corner Store \n");
		System.out.println("Enter total price of each: (0 to cancel order)");
		price = sc.nextDouble();
		totalPrice = totalPrice  + price;
		
		/* The user is then prompted asking how much money was tendered by the customer. */
//		System.out.println("Enter amount tendered. We don't accept bills larger than $20.00USD: ");
//		cashTendered = sc.nextDouble();
		
		while(price != 0.0) {
			//Display an appropriate message 
			//if the customer provided too little money or the exact amount.
			
			System.out.println("Add more items or 0 for total: ");
			price = sc.nextDouble();
			totalPrice  = totalPrice  + price;
		}
		//display item total and cash total
		System.out.printf("Amount is: %.2f%n", totalPrice);
		
		//prompt cashier to enter cash tendered by customer
		System.out.println("\n "+ "Enter cash tendered: ");
		cashTendered = sc.nextDouble();
		
		while(cashTendered < totalPrice) {
			System.out.println("Hmm, Looks like customer provided $"+ cashTendered+ " instead of $"+ totalPrice+ ". Please ask customer to provide sufficient change. ");
			cashTendered = cashTendered + sc.nextDouble();
			System.out.println("Total paid is : "+ cashTendered);
		}
		//calculate reimbursement for customer
		printHeader();
		cashBack = cashTendered - totalPrice;
		System.out.printf("\n Total: "+ totalPrice + "\nCash Total: "+cashTendered +"\nChange is: %.2f%n", cashBack);
		
		
		//calculate dollar bills to tender to customer
		//using Math.floor method due to rounding down whole dollars
		twenties = (int) Math.floor(cashBack/twentiesToCust);//cast to int from double
		tens = (int) Math.floor(cashBack - twenties * twentiesToCust / tensToCust);//cast to int from double
		fives = (int) Math.floor(cashBack - twenties * twentiesToCust - tens * tensToCust / fivesToCust);//cast to int from double
		ones = (int) Math.floor(cashBack - twenties * twentiesToCust - tens * tensToCust - fives * fivesToCust/ onesToCust);//cast to int from double
	
		cashLeft = (cashBack - twenties * twentiesToCust - tens * tensToCust - fives * fivesToCust - ones * onesToCust);
		
		cashLeft = Math.round(cashLeft * 100.00) / 100.00;
		
		//calculate coins to tender to customer
		quarters = (int)Math.floor(cashLeft/ quartersToCust);
		cashLeft = (cashBack - twenties * twentiesToCust - tens * tensToCust - fives * fivesToCust - ones * onesToCust - quarters * quartersToCust );
		
		cashLeft = Math.round(cashLeft * 100.00) / 100.00;
		
		//calculate coins to tender to customer
		dimes = (int)Math.floor(cashLeft/ dimesToCust);
		cashLeft = (cashBack - twenties * twentiesToCust - tens * tensToCust - fives * fivesToCust - ones * onesToCust - quarters * quartersToCust - dimes * dimesToCust);
		
		
		cashLeft = Math.round(cashLeft * 100.00) / 100.00;
		
		//calculate coins to tender to customer
		nickles = (int)Math.floor(cashLeft/ nicklesToCust);
		cashLeft = (cashBack - twenties * twentiesToCust - tens * tensToCust - fives * fivesToCust - ones * onesToCust - quarters * quartersToCust - nickles * nicklesToCust );

		cashLeft = Math.round(cashLeft * 100.00) / 100.00;
		
		//calculate coins to tender to customer
		pennies = (int)Math.floor(cashLeft/ penniesToCust);
		cashLeft = (cashBack - twenties * twentiesToCust - tens * tensToCust - fives * fivesToCust - ones * onesToCust - quarters * quartersToCust - nickles * nicklesToCust - pennies * penniesToCust);
		
		if(twenties > 0) {
			System.out.println("Customer will be get $20.00: " + twenties + "\n");
		}
		else if(tens > 0) {
			System.out.println("Customer will be get $10.00: " + tens + "\n");
		}
		else if(fives > 0) {
			System.out.println("Customer will be get $5.00: " + fives + "\n");
		}
		else if(ones > 0) {
			System.out.println("Customer will be get $1.00: " + ones + "\n");
		}
		else if(quarters > 0) {
			System.out.println("Remaining change $0.25: " + quarters + "\n");
		}
		else if(dimes > 0) {
			System.out.println("Remaining change $0.10: " + dimes + "\n");
		}
		else if(nickles > 0) {
			System.out.println("Remaining change $0.05: " + nickles + "\n");
		}
		else if(pennies > 0) {
			System.out.println("Remaining change $0.01: " + pennies + "\n");
		}
		sc.close();
		printReceipt();
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

}
