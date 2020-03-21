package makechange;

import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {
		/* The user is prompted asking for the price of the item. */
		Scanner sc = new Scanner(System.in);
		
		double change, cashTendered = 0.0;
		double cashBack, amount, cashLeft;
		double totalPrice = 0.0;
		double quarters, dimes, nickles, pennies;
		int ones, fives, tens, tewnties;
		
		//constant change in register
		double quartersToCust = 0.25;
		double dimessToCust = 0.10;
		double nicklesToCust = 0.05;
		double penniesToCust = 0.01;
		double oneToCust = 1.00;
		double fivesToCust = 5.00;
		double tensToCust = 10.00;
		double twentiesToCust = 20.00;
		
		
		System.out.print("Welcome to SD Corner Store \n");
		System.out.println("Enter total sale price of item/items: (0 to cancel order)");
		totalPrice = sc.nextDouble();
		cashTendered = cashTendered + totalPrice;
		
		/* The user is then prompted asking how much money was tendered by the customer. */
//		System.out.println("Enter amount tendered. We don't accept bills larger than $20.00USD: ");
//		cashTendered = sc.nextDouble();
		
		while(totalPrice != 0.0) {
			//Display an appropriate message 
			//if the customer provided too little money or the exact amount.
			
			System.out.println("Add more items or 0 for total: ");
			totalPrice = sc.nextDouble();
			cashTendered = cashTendered + totalPrice;
		}
		//display item total and cash total
		System.out.printf("Item total is : %.2f%n", totalPrice);
		
		sc.close();
	}

}
