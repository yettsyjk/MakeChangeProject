## Make Change Project - Week 1 Skill Distillery
### Java program for SD26 created by Yettsy Knapp

### Overview 
 - In the cash register we will calculate the amount of change returned to a customer based on the purchase price and the amount tendered.
 
### User Stories
- User Story #1
The user is prompted asking for the price of the item.

- User Story #2
The user is then prompted asking how much money was tendered by the customer.

- User Story #3
Display an appropriate message if the customer provided too little money or the exact amount.

- User Story #4
If the amount tendered is more than the cost of the item, display the number of bills and coins that should be given to the customer.

### Technologies Used
- Eclipse IDE
- Java 
- Terminal CLI
- Git
- GitHub version control

### Lessons Learned
1. Testing change result: Initial issue change would print as double instead of integer.
1. CashBack formula was returning precise decimals and wanted to investigate if changing
 it to float instead of double would be better option for receipt.
``double cashBack = cashTendered - totalPrice;``
1. CreateChange() method, the bulk of calculations took place and most of the features occurred. 
1. This was a fun program to create, the main issues were in the CreateChange() and had to re-write scale almost seven times.


### Minimal Viable Product(MVP)
#### MVP: 
	- User(Attendant) will enter individual "tendered" item and stop by enter "0" this will provide a result. 
	- User(Attendant) will be prompted when not enough money is tendered.
	- User(Attendant) will be prompted to enter correct tendered change.
	
#### MVP+
	- User(Attendant) will enter individual "tendered" item and stop by enter "0" this will provide a result.
	- User(Attendant) can't receive bills larger than $30.00, provide message to customer that bill tendered was too large.(Not achieved)

### License
This program is licensed under the MIT license. 

## Copyright (c)2020 Yettsy Knapp
- Let's Connect on [LinkedIn](https://www.linkedin.com/in/yettsy-jo-knapp)