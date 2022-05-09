# Receipt
Coding Challenge Itemis

This Repository is suppposed to eventually have a program that can print receipts for shopping baskets.

Main Project Structure:
(in Java)

A shopping package that contains:
A Main class for entering products to add to the shopping basket. (probably commandline style? JavaFX not out of the window yet)
An Item class for products for shopping. Just for saving data and calculating tax.
A Receipt class for creating items, storing them and printing the receipt.

a test package for unit tests:
A class for testing the Item functions and the receipt functions. (How do i check the receipt programmatically?)

Requirements:

Every Item has:
  - name    (name of item)
  - type    (e.g. book)
  - imported  (boolean)
  - price   (base price)
  - tax   (full additional tax for each product)
  - getters{}/setters{} for each
  - calculateTax{}  (calculates tax right on item creation)
  - fullPrice{}   (returns the price including tax for an item)


Receipt has:
  - ArrayList<Item>
  - displayCart{} (shows current content of shopping cart)
  - printReceipt{}  (creates a textfile with the specified receipt information)
  
Main:
  - will be a loop for now, continuously asking questions and processing user inputs
  - also listing the shopping cart every now and then
