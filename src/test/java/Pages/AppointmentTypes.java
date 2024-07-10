package Pages;


import Utilities.CommonMethods;
import Utilities.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import stepdefinitions.AppointmentCategorypageSteps;

import java.time.Month;
import java.util.List;


@Listeners(listeners.class)
public class AppointmentTypes {

    Constants constants = new Constants();
    CommonMethods commonMethods = new CommonMethods();


    private WebDriver driver;

    @FindBy(xpath = "//select[@id='combo_facility']")
    static WebElement Facilities;

    @FindBy(xpath = "//input[@id='radio_program_medicare']")
    static WebElement Medicareradiobtn;

    @FindBy(xpath = "//input[@id='radio_program_medicaid']")
    static WebElement Medicaidobtn;

    @FindBy(xpath = "//input[@id='radio_program_none']")
    static WebElement None;


    @FindBy(xpath = "//textarea[@name='comment']")
    static WebElement Comment;

    @FindBy(xpath = "//button[contains(text(),'Book Appointment')]")
    static WebElement BookAppmntBtn;



    @FindBy(xpath = "//p[@id='visit_date']")
    static WebElement visitDate;

    @FindBy(xpath = "//a[@id='menu-toggle']")
    static WebElement MenuToggle;

    @FindBy(xpath = "//a[text()='History']")
    static WebElement History;

    @FindBy(xpath = "//*[@id='comment']")
    static WebElement LastDataCommentInHistory;


    public AppointmentTypes(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    
    public void AppointmentCategory(String appointmentType) {

        Select Dropdownoptions = new Select(Facilities);
        commonMethods.takeScreenshot();
        List<WebElement> options = Dropdownoptions.getOptions();
        for (WebElement option : options) {
        }
        Dropdownoptions.selectByVisibleText(appointmentType);


    }

    
    public void HealthCareselection(String healthcareType) {

        if (healthcareType.equalsIgnoreCase("Medicare")) {

            Medicareradiobtn.click();
            commonMethods.takeScreenshot();
        } else if (healthcareType.equalsIgnoreCase("Medicaid")) {

            Medicaidobtn.click();
            commonMethods.takeScreenshot();

        } else {
            None.click();


        }


        commonMethods.takeScreenshot();
    }




    public void SelectAppointmentDate(String month, String date, String year) throws InterruptedException {
        SelectDate(month, date, year);



            int NumberofMonth = Month.valueOf(month.toUpperCase()).getValue();
            if(NumberofMonth<10){
            constants.AppointmentDate = date + "/" + "0" + NumberofMonth + "/" + year;
        }else{

                constants.AppointmentDate = date + "/" + NumberofMonth + "/" + year;
            }

        }

    public void SelectDate(String month, String date, String year) throws InterruptedException {


        String MonthYeartext;
        WebElement CalenderPick = driver.findElement(By.xpath("//div//input[@name='visit_date']"));
        CalenderPick.click();
        WebElement MonthYear = driver.findElement(By.className("datepicker-switch"));
        MonthYeartext = MonthYear.getText();


        String Month = MonthYeartext.split(" ")[0].trim();


        String Year = MonthYeartext.split(" ")[1].trim();


        while (!(Month.equals(month) && (Year.equals(year)))) {

            {
                WebElement Next = driver.findElement(By.className("next"));
                Next.click();

                MonthYeartext = driver.findElement(By.className("datepicker-switch")).getText();

                Month = MonthYeartext.split(" ")[0].trim();
                Year = MonthYeartext.split(" ")[1].trim();
            }
            WebElement Exdate = driver.findElement(By.xpath("//tr//td[text()='" + date + "']"));
            Exdate.click();


        }
    }
        
        public void EnterComment(String comments){
            Comment.sendKeys(comments);
            constants.CommentProvidedDuringBooking = comments;
            System.out.println("Comment During Booking "+ constants.CommentProvidedDuringBooking);



        }

    
    public void ClickBookAppmnt() {



        BookAppmntBtn.click();
        constants.VisitdateFromConfirmationScreen = visitDate.getText();
        commonMethods.takeScreenshot();
        Assert.assertEquals(constants.AppointmentDate, constants.VisitdateFromConfirmationScreen);
    }

    public void validateComment(){

  MenuToggle.click();
  History.click();
  System.out.println("Comment in History "+LastDataCommentInHistory.getText());

   constants.CommentInHistory=LastDataCommentInHistory.getText();

   Assert.assertEquals(constants.CommentProvidedDuringBooking,constants.CommentInHistory);

    }
}
