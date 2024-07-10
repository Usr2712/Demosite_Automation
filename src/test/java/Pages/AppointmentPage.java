package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AppointmentPage {


    private WebDriver driver;

    @FindBy(xpath = "//select[@id='combo_facility']")
    static WebElement Facility;

    @FindBy(xpath = "//input[@id='radio_program_medicare']")
    static WebElement Medicareradiobtn;

    @FindBy(xpath = "//textarea[@name='comment']")
    static WebElement Comment;

    public AppointmentPage(WebDriver driver){

        this.driver=driver;

        PageFactory.initElements(driver,this);
    }

    public void enterdetails(){


        Select Dropdownoptions= new Select(Facility);
        List<WebElement> options = Dropdownoptions.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        Dropdownoptions.selectByVisibleText("Seoul CURA Healthcare Center");
        Medicareradiobtn.click();
        Comment.sendKeys("Enter Comment");


    }
}
