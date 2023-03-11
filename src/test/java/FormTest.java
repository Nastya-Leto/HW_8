import pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class FormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        String userName = "Anastasiya",
                userLastName = "Zak",
                email = "stasia-oops@yandex.ru",
                gender = "Female",
                phone = "8927111111",
                subjects = "Arts",
                hobbies = "Music",
                state = "NCR",
                city = "Noida",
                address = "Samara",
                file = "pictures/img1.png";

        new RegistrationPage().openPage()
                .closeBanner()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setEMail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate("27", "May", "1991")
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .addFile(file)
                .setSubmit();


        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", "Zak Anastasiya")
                .verifyResults("Student Email", "stasia-oops@yandex.ru")
                .verifyResults("Gender", "Female")
                .verifyResults("Mobile", "8927111111")
                .verifyResults("Date of Birth", "27 May,1991")
                .verifyResults("Subjects", "Arts")
                .verifyResults("Hobbies", "Music")
                .verifyResults("Picture", "img1.png")
                .verifyResults("Address", "Samara")
                .verifyResults("State and City", "NCR Noida");

    }
}