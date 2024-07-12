package stepdefinitions;

import Pages.AppointmentTypes;
import io.cucumber.java.en.And;

import java.sql.SQLException;

import static Factory.DriverFactory.driver;

public class AppointmentCategorypageSteps {

AppointmentTypes appointmentTypes=new AppointmentTypes(driver);

    @And("make appointment {string}")
    public void makeAppointment(String appointmentType) {

        appointmentTypes.AppointmentCategory(appointmentType);

    }
    @And("Select {string}")
    public void select(String HealthcareType) {

        appointmentTypes.HealthCareselection(HealthcareType);
    }

    @And("Book Appointment")
    public void bookAppointment() {
        appointmentTypes.ClickBookAppmnt();

    }

  /*  @And("Select Date")
    public void selectDate() throws InterruptedException {
        appointmentTypes.SelectDate();
    }
*/
    @And("Select apppointmentdate {string} and {string} and {string}")
    public void selectApppointmentdateAndAnd(String Month, String Date, String Year) throws InterruptedException {
        appointmentTypes.SelectAppointmentDate(Month,Date,Year);


    }


    @And("verify Comment in history is matching with comment provided")
    public void verifyCommentInHistoryIsMatchingWithCommentProvided() throws SQLException {
appointmentTypes.validateComment();
appointmentTypes.VerifydetailsWithDB();

    }

    @And("Enter Comments {string}")
    public void enterComments(String CommentsText) {

        appointmentTypes.EnterComment(CommentsText);
    }
}
