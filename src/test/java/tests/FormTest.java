package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;
import org.junit.jupiter.api.Test;


public class FormTest extends TestData {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {

        new RegistrationPage().openPage()
                .closeBanner()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setEMail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate(userBirthDate, userBirthMonth, userBirthYear)
                .setSubjects(userSubjects)
                .setHobbies(userHobbies)
                .setAddress(address)
                .setState(userState)
                .setCity(userCity)
                .addFile(file)
                .setSubmit();


        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", userLastName + " " + userName)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", phone)
                .verifyResults("Date of Birth", userBirthDate + " " + userBirthMonth + "," + userBirthYear)
                .verifyResults("Subjects", userSubjects)
                .verifyResults("Hobbies", userHobbies)
                .verifyResults("Picture", "img1.png")
                .verifyResults("Address", address)
                .verifyResults("State and City", userState + " " + userCity);

    }
}