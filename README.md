
# Incomes Expenses - QA Assessment

#README - Author - Sanele Mbense - Date: 06 April 2022

brief description of the approach and tools used

Tools used:
	- Intellij - Java
	- Maven
	- J-unit 
	- Cucumber BDD Framework
	- Chromedrive
	- Firefox
	
Approach:
I used the above tools as they were the most fitting for testing/automating the site also the tests are in simple text (Gherkin syntax) easy to read and understand what the test is doing, I also added notes on each test so you know exactly what the code is doing.

Setup:

	 - Copy repository 
	 - Run the docker site
	 - Install Intellij
	 - Download Chromedrive (99.0.4844.51)
	 - Download geckodrive (latest)	
	 - Open project on Intellij
	 - ensure you check the project dependencies to make sure you have all installed and downloaded before running the project
	 - Go to Registration.Feature and Run the tests from there or Click on the top bar green play button (Run)


Test cases covered:

	- Creating a new user
	- Creating a budget
	- Adding couple of transactions in different categories
	- Making sure the totals and subtotals match (Fails)
	- Deleting a transactions/category (Passes without adding code to delete - Please see issues list)
	- Create 2nd user (Multi-user) and assign an already created budget list

Issues/Bugs found:
- Site does not save the registration or user once session is closed, tests required that a user is created everytime when running tests 
- Budget/Transactions pages use the same xpath name/code... this means that you cannot create multiple budget lists or transactions when the tests are running as the second creation deletes the previously created budget list/transactions. This also means that the Data needed for the Stats page or amounts are deleted as well only one can be shown during the test runs. 

Please Note: All tests were tested manually (totals matched when testing manually).