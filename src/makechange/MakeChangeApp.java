package makechange;


import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);
			System.out.print("Welcome to Corner Store. \n");
			//User is prompted asking for the price of the item
			System.out.print("Attendant: Please Enter Item Cost: ($2 is $2.00, $5 is $5.00)");
			double totalPrice = sc.nextDouble();
			
			//
			System.out.println("Attendant: Please Enter Amount Tendered by Customer: ($5 is 5.00, $12 is $12.00):");
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
				createChange(cashBack);
			} else {
			//display message to customer when provided exact amount 
				greetingBye(totalPrice, cashTendered, cashBack);
			}
		}

		public static void createChange(double cashBack) {
			//scale down
			int twenty = 2000, ten = 1000, five = 500, one = 100, quarter = 25, dime = 10, nickel = 5, penny = 1;
			//Calculation to pennies and rounding down and decimal places
			int change = (int)(Math.floor(cashBack * 100));
			
			int convertTwenty = change / twenty;
			//use division and modulo to get remainder
			change = change % twenty;
			printHeader();
		
			System.out.println("Thanks! Your change is: $" + cashBack + ".\nYou get " + convertTwenty + " twenty dollar bills.");
			
			int convertTen = change / ten;
			change = change % ten;
			System.out.println("You get " + convertTen + " ten dollar bills.");
			
			int convertFive = change / five;
			change = change % five;
			System.out.println("You get " + convertFive + " five dollar bills.");
			
			int convertOne = change / one;
			change = change % one;
			System.out.println("You get " + convertOne + " one dollar bills.");
			
			int convertQuarter = change / quarter;
			change = change % quarter;
			System.out.println("You get " + convertQuarter + " quarters.");
			
			int convertDime = change / dime;
			change = change % dime;
			System.out.println("You get " + convertDime + " dimes.");
			
			int convertNickel = change / nickel;
			change = change % nickel;
			System.out.println("You get " + convertNickel  + " nickels.");
			
			int convertPenny = change / penny;
			change = change % penny;
			System.out.println("You get " + convertPenny + " pennies.");
			printReceipt();
			
		}
		
		public static void tooShort(double totalPrice, double cashTendered) {
			System.out.println("Hmm, Would you like to put something back? or Please provide the remainig amount: $"+ (totalPrice - cashTendered));
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
		public static void greetingBye(double totalPrice, double cashTendered, double cashBack) {
			System.out.println("You provided exact change. \nI don't see that happen much these days.");
			printHeader();
			System.out.println("Total Items: $"+ totalPrice+ " \n");
			System.out.println("Total Cash: $"+ cashTendered+ " \n");
			System.out.println("Total Cash Back: $"+ cashBack+ " \n");
			printReceipt();
		}
		
	}