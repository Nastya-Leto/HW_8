import com.github.javafaker.Faker;
import pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static utils.RandomUtils.getRandomInt;
import static utils.RandomUtils.getRandomItemFromArray;

public class FormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {

        Faker faker = new Faker();
        String[] genders = {"Male", "Female", "Other"};
        String[] subjects = {"Arts", "Accounting", "English"};
        String[] hobbies = {"Sports", "Reading", "Music"};
        //String[] state = {"NCR", "Uttar Pradesh", "Haryana","Rajasthan"};
        String[] city = {"Delhi", "Gurgaon", "Noida"};
        String[] month = {"January", "February", "March","April", "May", "June",
                "July", "August", "September","October", "November", "December"};

        String userName = faker.pokemon().name(),
                userLastName = faker.gameOfThrones().house(),
                email = faker.internet().emailAddress(),
                gender = getRandomItemFromArray(genders),
                phone = faker.number().digits(10),
                userSubjects = getRandomItemFromArray(subjects),
                userHobbies = getRandomItemFromArray(hobbies),
                userState = "NCR",
                userCity = getRandomItemFromArray(city),
                address = faker.rickAndMorty().location(),
                file = "pictures/img1.png",
                userDate = String.valueOf(getRandomInt(10,28)),
        userMonth = getRandomItemFromArray(month),
        userYear = String.valueOf(getRandomInt(1900,2100));
        //userDate = getRandomInt(10,100);


        new RegistrationPage().openPage()
                .closeBanner()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setEMail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate(userDate, userMonth, userYear)
                //.setBirthDate("27", "May", "1991")
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
                .verifyResults("Date of Birth", userDate + " " + userMonth + "," + userYear)
                .verifyResults("Subjects", userSubjects)
                .verifyResults("Hobbies", userHobbies)
                .verifyResults("Picture", "img1.png")
                .verifyResults("Address", address)
                .verifyResults("State and City",userState + " "+ userCity);

    }
}