package stepdefinitions;

import Pages.AppointmentPage;
import io.cucumber.java.en.And;

import static Factory.DriverFactory.driver;

public class AppointmentPageSteps {

    AppointmentPage appointmentPage = new AppointmentPage(driver);

    @And("make appointment")
    public void makeAppointment() {
        appointmentPage.enterdetails();

    }


}
