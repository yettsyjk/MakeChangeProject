package makechange;


import java.text.DecimalFormat;
import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {
			double totalPrice = 0.0, price = 0.0;
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Welcome to Corner Store. \n");
			//User is prompted asking for the price of the item
			System.out.print("Attendant: Please Enter Item Cost: ($2 is $2.00, $5 is $5.00)");
			price = sc.nextDouble();
			totalPrice = totalPrice + price;
			
			while(price != 0) {
			System.out.print("Attendant: Please Enter Another Item Cost OR, 0 for Total: ($2 is $2.00)");
			price = sc.nextDouble();
			totalPrice = totalPrice + price;
			System.out.printf("Total Amount Due:$ %.2f%n", totalPrice);
			}
			
			System.out.println("Attendant: Please Enter Amount Tendered by Customer: ($5 is 5.00):");
			double cashTendered = sc.nextDouble();
			
			sc.close();
			
			//calculate customer cashBack options 
			double cashBack = cashTendered - totalPrice;
//			System.out.println(cashBack + "cashBack");
			if(cashTendered < totalPrice) {
			//display message to customer when provided too little money  
				tooShort(totalPrice, cashTendered);
		   //method for calculating amount tendered more than the cost of item 
			} else if (cashTendered > totalPrice ){
				createChange(cashBack, cashTendered, totalPrice);
			} else {
			//display message to customer when provided exact amount 
				greetingBye(totalPrice, cashTendered, cashBack);
			}
		}

		public static void createChange(double cashBack, double cashTendered, double totalPrice) {
			DecimalFormat twoDecimals = new DecimalFormat("#.00");
			//scale down
			cashBack = cashTendered - totalPrice + 0.0005;

			printHeader();
			System.out.println("Thanks! Your change is: $" + twoDecimals.format(cashBack));
			if(cashBack >= 20.00) {
				int twenty = (int)(cashBack / 20);
				System.out.println("Change: "+ twenty + ": Twenty Dollar Bill(s)");
				cashBack -= twenty * 20;
			}
			if(cashBack >= 10.00) {
				int ten = (int)(cashBack / 10);
				System.out.println("Change: "+ ten + ": Ten Dollar Bill(s)");
				cashBack -= ten * 10;
			}
			if(cashBack >= 5.00) {
				int five = (int)(cashBack / 5);
				System.out.println("Change: "+ five + ": Five Dollar Bill(s)");
				cashBack -= five * 5;
			}
			if(cashBack >= 1.00) {
				int one = (int)(cashBack / 1.00);
				System.out.println("Change: "+ one+ ": One Dollar Bill(s)");
				cashBack -= one * 1;
			} else {
				
			}
			if(cashBack >= 0.25) {
				int quarter = (int)(cashBack / 0.25);
				System.out.println("Change: "+ quarter+ ": Quarter(s)");
				cashBack -= quarter * 0.25;
			}
			if(cashBack >= 0.10) {
				int dime = (int)(cashBack / 0.10);
				System.out.println("Change: "+ dime + ": Dime(s)");
				cashBack -= dime* 0.10;
			}
			if(cashBack >= 0.05) {
				int nickel = (int)(cashBack / 0.05);
				System.out.println("Change: "+ nickel + ": Nickel(s)");
				cashBack -=  nickel * 0.05;
			}
			if(cashBack >= 0.01) {
				int penny = (int)(cashBack / 0.01);
				System.out.println("Change: "+ penny+ ": Penny(ies)");
				cashBack -=  penny * 0.01;
			}
			
			printReceipt();
			
		}
		
		public static void tooShort(double totalPrice, double cashTendered) {
			
			Scanner sc = new Scanner(System.in);

			System.out.println("Hmm, Would you like to put something back? or Please provide the remaining amount: $"+ (totalPrice - cashTendered));		
		}
		
		public static void printHeader() {
			System.out.println("///////////////////////////////////////");
			System.out.println("/////////// CORNER STORE //////////////");
			System.out.println("///////////  DENVER, CO  //////////////");
		}
		
		public static void printReceipt() {
			System.out.println("////////// CORNER STORE ///////////////");
			System.out.println("///////////////////////////////////////");
			System.out.println("      Come Back To See Us Again!       ");
		}
		public static void greetingBye(double totalPrice, double cashTendered, double cashBack) {
			System.out.println("You provided exact change. \nThat doesn't happen much these days.");
			printHeader();
			System.out.println("Total Items: $"+ totalPrice+ " \n");
			System.out.println("Total Cash: $"+ cashTendered+ " \n");
			System.out.println("Total Cash Back: $"+ cashBack+ " \n");
			printReceipt();
		}
		
	}