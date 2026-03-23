package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BasePage;

public class LoginModal extends BasePage {
    private final By loginModal = By.id("dialog");
    private final By registerTab = By.id("riuClassRegister");

    private final By registerTitle = By.xpath("//h2/b");
    private final By nameTextBox = By.id("name_input_input");
    private final By surnameTextBox = By.id("surname_input_input");
    private final By emailTextBox = By.id("email_input_input");
    private final By countrySelect = By.id("country_select_menuButton");
    private final By Argentina = By.id("AR");
    private final By genreSelect = By.id("genderSelect_menuButton");
    private final By male = By.id("H");
    private final By salesInfoRadioBtn = By.id("controlInformationYes");
    private final By termsCheckBox = By.id("acceptConditionsCheck");

    public LoginModal(WebDriver driver){
        super(driver);
    }

    public boolean isLoginModalVisible(){
        return isDisplayed(this.loginModal);
    }

    public boolean isRegisterTabVisible(){
        return isDisplayed(this.registerTab);
    }

    public boolean isRegisterTabClickable(){
        return isClickable(this.registerTab);
    }

    public void clickRegisterTab(){
        click(this.registerTab);
    }

    public boolean isRegisterTitleVisible(){
        return isDisplayed(this.registerTitle);
    }

    public boolean isNameTextBoxVisible(){
        return isDisplayed(this.nameTextBox);
    }

    public boolean isNameTextBoxClickable(){
        return isClickable(this.nameTextBox);
    }

    public void typeName(String name){
        type(this.nameTextBox, name);
    }

    public boolean isLastNameTextBoxVisible(){
        return isDisplayed(this.surnameTextBox);
    }

    public boolean isLastNameTextBoxClickable(){
        return isClickable(this.surnameTextBox);
    }

    public void typeLastName(String lastname){
        type(this.surnameTextBox, lastname);
    }

    public boolean isEmailTextBoxVisible(){
        return isDisplayed(this.emailTextBox);
    }

    public boolean isEmailTextBoxClickable(){
        return isClickable(this.emailTextBox);
    }

    public void typeEmail(String email){
        type(this.emailTextBox, email);
    }

    public boolean isCountrySelectVisible(){
        return isDisplayed(this.countrySelect);
    }

    public boolean isCountrySelectClickable(){
        return isClickable(this.countrySelect);
    }

    public void clickCountrySelect(){
        click(this.countrySelect);
    }

    public boolean isArgOptVisible(){
        return isDisplayed(this.Argentina);
    }

    public void selectArgentina(){
        click(this.Argentina);
    }
    
    public boolean isGenreSelectVisible(){
        return isDisplayed(this.genreSelect);
    }

    public boolean isGenreSelectClickable(){
        return isClickable(this.genreSelect);
    }

    public void clickGenreSelect(){
        click(this.genreSelect);
    }

    public boolean isMaleOptVisible(){
        return isDisplayed(this.male);
    }

    public void selectMale(){
        click(this.male);
    }

    public boolean isSalesRadioBtnVisible(){
        return isDisplayed(this.salesInfoRadioBtn);
    }

    public boolean isSalesRadioBtntClickable(){
        return isClickable(this.salesInfoRadioBtn);
    }

    public void clickSalesRadioBtn(){
        click(this.salesInfoRadioBtn);
    }

    public boolean isTermsCheckVisible(){
        return isDisplayed(this.termsCheckBox);
    }

    public boolean isTermsCheckClickable(){
        return isClickable(this.termsCheckBox);
    }

    public void clickTermsCheck(){
        click(this.termsCheckBox);
    }

    public boolean isTermsUnchecked(){
        return !isChecked(this.termsCheckBox);
    }

}
