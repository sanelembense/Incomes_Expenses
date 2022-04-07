package Registration;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class RegistrationSteps {
    WebDriver driver = null;
    JavascriptExecutor js = null;
    Variables var = new Variables();


    //@When("tries logging in with a <username> and <password>")
    //public void triesLoggingInWithAUsernameAndPassword() {


    private class Variables {
        String Incomes_Expenses = "http://localhost:3567/";
        String chrome_path = "C:\\Order-Auto-main\\Order-Auto-main\\src\\main\\resources\\drivers\\chromedriver.exe";
        String firefox_path = "C:\\Order-Auto-main\\Order-Auto-main\\src\\main\\resources\\drivers\\geckodriver.exe";
        String Sign_up_button_reg ="//*[@id=\"root\"]/main/div[1]/div[4]/button";
        String Login_button = "//*[@id=\"root\"]/main/div[1]/div[3]/button";
        String username_login = "//*[@id=\"root\"]/main/div[1]/div[1]/div/input";
        String password_login = "//*[@id=\"root\"]/main/div[1]/div[2]/div/input";
        String username_signup = "//*[@id=\"root\"]/main/div[1]/div[1]/div/input";
        String password_signup = "//*[@id=\"root\"]/main/div[1]/div[2]/div/input";
        String confirm_password = "//*[@id=\"root\"]/main/div[1]/div[3]/div/input";
        String add_new_budget_name = "//*[@id=\"root\"]/main/div/div[1]/div[1]/input";
        String add_new_budget_button = "//*[@id=\"root\"]/main/div/div[2]/button";
        String select_category = "//*[@id=\"root\"]/main/div/div[1]/div[2]/select";
        String stats_page = "//*[@id=\"root\"]/nav/ul/li[2]/a";
        String select_other_category = "//*[@id=\"root\"]/main/div/div[1]/div[2]/select/option[7]";
        String select_home_category = "//*[@id=\"root\"]/main/div/div[1]/div[2]/select/option[2]";
        String plus_minus_budget = "//*[@id=\"root\"]/main/div/div[2]/div[1]/button";
        String amount_budget = "//*[@id=\"root\"]/main/div/div[2]/div[2]/input";
        String new_transaction_tab = "//*[@id=\"root\"]/main/div[1]";
        String save_transaction_button = "//*[@id=\"root\"]/main/div/div[2]/button";
        String Filter_by_list = "//*[@id=\"root\"]/main/div[1]/div[1]/div[1]/select";
        String Filter_by_list_option1 = "//*[@id=\"root\"]/main/div[1]/div[1]/div[1]/select/option[2]";
        String filter_by_user = "//*[@id=\"root\"]/main/div[1]/div[1]/div[2]/select";
        String Filter_by_user_option1 = "//*[@id=\"root\"]/main/div[1]/div[1]/div[2]/select/option[2]";
        String total_income_stats = "//*[@id=\"root\"]/main/div[1]/div[2]/div[1]";
        String total_expense_stats = "//*[@id=\"root\"]/main/div[1]/div[2]/div[2]";
        String delete_transaction = "//*[@id=\"root\"]/main/div[1]/div[2]/div/select/option[2]";
        String remove_multi_user_transaction = "//*[@id=\"root\"]/main/div[1]/div[1]/ul/li[2]/div/text()";

    }
    public void SetChromeBrowserDriver(){
        System.setProperty("webdriver.chrome.driver",var.chrome_path);
        driver = new ChromeDriver();

    }
    //public void SetFirefoxBrowserDriver(){
        //System.setProperty("webdriver.gecko.driver",var.firefox_path);
        //driver = new FirefoxDriver();
    //}


    @Before
    public void Load_Browser(){
        //Open website,
        SetChromeBrowserDriver();
        js = (JavascriptExecutor) driver;
        driver.get(var.Incomes_Expenses);
        driver.navigate().to("http://localhost:3567/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));



    }
    @Given("Create_new_user")
    public void Create_new_user() {
        // This function validates that the user is redirected to the sign-up page
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/h1")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/h1")).isDisplayed();
        driver.findElement(By.xpath(var.username_signup)).sendKeys("sanele");
        driver.findElement(By.xpath(var.password_signup)).sendKeys("Test12");
        driver.findElement(By.xpath(var.confirm_password)).sendKeys("Test12");
        driver.findElement(By.xpath(var.Sign_up_button_reg)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }
    @When("click sign-up")
    public void click_sign_up() {
        // This function validates that the user is redirected to the signup page
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/h1")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[1]/div/input")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[2]/div/input")).isDisplayed();

    }
    @Then("redirected to login")
    public void redirected_to_login() {
        // This function validates that the user is redirected to the login page - login with new user
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.getCurrentUrl().contains("http://localhost:3567/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath(var. username_login)).sendKeys("sanele");
        driver.findElement(By.xpath(var. password_login)).sendKeys("Test12");
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[3]/button")).isEnabled();
        driver.findElement(By.xpath(var. Login_button)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@id=\"root\"]/nav/ul/li[3]/button")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"root\"]/nav/ul/li[3]/button")).isEnabled();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.getCurrentUrl().contains("http://localhost:3567/lists");

    }
    @Given("new user completes sign up")
    public void new_user_completes_sign_up() {
        // This function validates that the user is redirected to the sign-up page
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/h1")).isDisplayed();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[2]/a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/h1")).isDisplayed();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[1]/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[1]/div/input")).sendKeys("sanele");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[2]/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[2]/div/input")).sendKeys("Test12");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[3]/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[3]/div/input")).sendKeys("Test12");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[4]/button")).click();
    }

    @When("sign up successful")
    public void Sign_up_successful() {
        // This function validates that the user is redirected to the login page
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/h1")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[1]/div/input")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[2]/div/input")).isDisplayed();

    }

    @Then("returned to login page")
    public void returned_to_login_page() {
        // This function validates that the user is redirected to the login page - login with new user
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[1]/div/input")).sendKeys("sanele");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[2]/div/input")).sendKeys("Test12");
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[3]/button")).isEnabled();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[3]/button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@id=\"root\"]/nav/ul/li[3]/button")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"root\"]/nav/ul/li[3]/button")).isEnabled();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.getCurrentUrl().contains("http://localhost:3567/lists");


    }
    @Given("The user enters an already existing User")
    public void The_user_enters_an_already_existing_email() {
        // This function validates that the user is redirected to the login page
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/h1")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[1]/div/input")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[2]/div/input")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[3]/button")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[2]")).isDisplayed();


    }
    @Given("create multi user completes sign up")
    public void Create_multi_user() {
        // This function validates that the user is redirected to the correct page
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/h1")).isDisplayed();
        driver.findElement(By.xpath(var.username_signup)).sendKeys("Tester");
        driver.findElement(By.xpath(var.password_signup)).sendKeys("54321");
        driver.findElement(By.xpath(var.confirm_password)).sendKeys("54321");
        driver.findElement(By.xpath(var.Sign_up_button_reg)).click();

    }

    @When("multi user successful")
    public void Multi_user_successful() {
        // This function validates that the user is redirected to the correct page
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/h1")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[1]/div/input")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[2]/div/input")).isDisplayed();

    }

    @Then("multi user can login")
    public void Multi_user_can_login() {
        // This function validates that the user is redirected to the correct page
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[1]/div/input")).sendKeys("Tester");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[2]/div/input")).sendKeys("54321");
        driver.findElement(By.xpath(var. Login_button)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id=\"root\"]/nav/ul/li[3]/button")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"root\"]/nav/ul/li[3]/button")).isEnabled();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.getCurrentUrl().contains("http://localhost:3567/lists");

}

    @Given("The user enters incorrect User details")
    public void The_user_enters_incorrect_user_details() {
        // This function validates that the user is redirected to the login page with error displayed
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/h1")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[1]/div/input")).sendKeys("test");
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[2]/div/input")).sendKeys("jsdf");
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[3]/button")).isEnabled();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[3]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[3]/div")).isEnabled();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[3]/div")).isDisplayed();
        driver.getCurrentUrl().contains("http://localhost:3567/login");
    }
    @Given("user creates a new budget")
    public void Create_new_budget() {
        // This function validates that the user is redirected to the correct page
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/h1")).isDisplayed();
        driver.findElement(By.xpath(var.username_signup)).sendKeys("Tester");
        driver.findElement(By.xpath(var.password_signup)).sendKeys("54321");
        driver.findElement(By.xpath(var.confirm_password)).sendKeys("54321");
        driver.findElement(By.xpath(var.Sign_up_button_reg)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(var.username_login)).sendKeys("Tester");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath(var.password_login)).sendKeys("54321");
        driver.findElement(By.xpath(var. Login_button)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.getCurrentUrl().contains("http://localhost:3567/lists");
        driver.findElement(By.xpath(var.add_new_budget_name)).click();
        driver.findElement(By.xpath(var.add_new_budget_name)).sendKeys("Income_Budget");
        driver.findElement(By.xpath(var.add_new_budget_button)).isEnabled();
        driver.findElement(By.xpath(var.add_new_budget_button)).click();

    }

    @When("user opens a new budget page")
    public void new_budget() {
        // This function validates that the user is able to add a transaction in a budget
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]")).click();
        driver.findElement(By.xpath(var.add_new_budget_name)).isDisplayed();

    }

    @And("user adds Budget name")
    public void user_adds_budget_name() {
        // This function validates that the user is able to add details for a transaction
        driver.findElement(By.xpath(var.add_new_budget_name)).sendKeys("Salary");;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath(var.select_category)).click();
        driver.findElement(By.xpath(var.select_other_category)).click();
        driver.findElement(By.xpath(var.amount_budget)).sendKeys("20000");

    }

    @And("user clicks on the add button")
    public void User_clicks_add_budget_button() {
        // This function validates that the user is able to click and add transaction successfully
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/button")).click();
        driver.findElement(By.xpath(var.save_transaction_button)).click();

    }

    @Then("user confirm my budget list")
    public void confirm_my_budget_list() {
        // This function validates that the user is taken to the budget list screen after clicking add, Then adds a second transaction with a different category
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.getCurrentUrl().contains("http://localhost:3567/lists");
        driver.findElement(By.xpath(var.new_transaction_tab)).click();
        driver.findElement(By.xpath(var.add_new_budget_name)).sendKeys("Rent");;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath(var.select_category)).click();
        driver.findElement(By.xpath(var.select_home_category)).click();
        driver.findElement(By.xpath(var.plus_minus_budget)).click();
        driver.findElement(By.xpath(var.amount_budget)).sendKeys("3000");
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/button")).click();
        driver.findElement(By.xpath(var.save_transaction_button)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.getCurrentUrl().contains("http://localhost:3567/lists");

    }
    @Given("Totals and Expenses match")
    public void Given_Totals_and_Expenses_match() {
        // This function validates that the user is create and
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/h1")).isDisplayed();
        driver.findElement(By.xpath(var.username_signup)).sendKeys("Tester");
        driver.findElement(By.xpath(var.password_signup)).sendKeys("54321");
        driver.findElement(By.xpath(var.confirm_password)).sendKeys("54321");
        driver.findElement(By.xpath(var.Sign_up_button_reg)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(var.username_login)).sendKeys("Tester");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath(var.password_login)).sendKeys("54321");
        driver.findElement(By.xpath(var.Login_button)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.getCurrentUrl().contains("http://localhost:3567/lists");
        driver.findElement(By.xpath(var.add_new_budget_name)).click();
        driver.findElement(By.xpath(var.add_new_budget_name)).sendKeys("Income_Budget");
        driver.findElement(By.xpath(var.add_new_budget_button)).isEnabled();
        driver.findElement(By.xpath(var.add_new_budget_button)).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]")).click();
        driver.findElement(By.xpath(var.add_new_budget_name)).sendKeys("Rent_test");;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath(var.select_category)).click();
        driver.findElement(By.xpath(var.select_home_category)).click();
        driver.findElement(By.xpath(var.plus_minus_budget)).click();
        driver.findElement(By.xpath(var.amount_budget)).sendKeys("3000");
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/button")).click();
        driver.findElement(By.xpath(var.save_transaction_button)).click();


    }
    @When ("user opens stats page")
    //User is able to go onto the Statistics page and filter by user and by list
    public void user_filters_by_all_on_Filters() {
        driver.findElement(By.xpath(var.stats_page)).click();
        driver.findElement(By.xpath(var.Filter_by_list)).click();
        driver.findElement(By.xpath(var.Filter_by_list_option1)).click();
        driver.findElement(By.xpath(var.total_income_stats)).isDisplayed();
        driver.findElement(By.xpath(var.total_income_stats)).getText();
        driver.findElement(By.xpath(var.total_expense_stats)).isDisplayed();
        driver.findElement(By.xpath(var.total_expense_stats)).getText();
    }

    @Then ("all total income and total expenses are displayed")
    public void all_total_income_and_total_expenses_are_displayed() {
        driver.findElement(By.xpath(var.stats_page)).click();
        driver.findElement(By.xpath(var.total_expense_stats)).isDisplayed();
        driver.findElement(By.xpath(var.total_expense_stats)).getText();
        driver.findElement(By.xpath(var.total_income_stats)).isDisplayed();
        driver.findElement(By.xpath(var.total_income_stats)).getText();
    }
    @Given("user can add multiple users to a budget")
    public void multi_users_to_budget() {
        // This function validates that the user is able to create 2 users, login with one and the other user is visible in "add user" drop-down
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/h1")).isDisplayed();
        driver.findElement(By.xpath(var.username_signup)).sendKeys("Tester");
        driver.findElement(By.xpath(var.password_signup)).sendKeys("54321");
        driver.findElement(By.xpath(var.confirm_password)).sendKeys("54321");
        driver.findElement(By.xpath(var.Sign_up_button_reg)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/h1")).isDisplayed();
        driver.findElement(By.xpath(var.username_signup)).sendKeys("user2");
        driver.findElement(By.xpath(var.password_signup)).sendKeys("test123");
        driver.findElement(By.xpath(var.confirm_password)).sendKeys("test123");
        driver.findElement(By.xpath(var.Sign_up_button_reg)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(var.username_login)).sendKeys("Tester");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath(var.password_login)).sendKeys("54321");
        driver.findElement(By.xpath(var. Login_button)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.getCurrentUrl().contains("http://localhost:3567/lists");
        driver.findElement(By.xpath(var.add_new_budget_name)).click();
        driver.findElement(By.xpath(var.add_new_budget_name)).sendKeys("House_Budget");
        driver.findElement(By.xpath(var.add_new_budget_button)).isEnabled();
        driver.findElement(By.xpath(var.add_new_budget_button)).click();

    }

    @When("user assigns another user to the budget")
    public void assign_multi_user() {
        // This function validates that the user is able to add a second user from the drop-down
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[2]/div/select")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[2]/div/select/option[2]")).click();

    }

    @Then("confirm successful assignment")
    public void confirm_multi_user() {
        // This function validates that the user is added onto the budget(two users are assigned to the same budget)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[1]/ul/li[2]/div")).isDisplayed();
        driver.getCurrentUrl().contains("http://localhost:3567/lists");
        driver.findElement(By.xpath("//*[@id=\"root\"]/nav/ul/li[3]/button")).click();
        driver.close();
        driver.quit();
    }

    }