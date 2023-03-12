package tests;

import com.github.javafaker.Faker;

import static utils.RandomUtils.getRandomInt;
import static utils.RandomUtils.getRandomItemFromArray;

public class TestData {

    public static String[]
            genders = {"Male", "Female", "Other"},
            subjects = {"Arts", "Accounting", "English"},
            hobbies = {"Sports", "Reading", "Music"},
            city = {"Delhi", "Gurgaon", "Noida"},
            month = {"January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"};

    Faker faker = new Faker();

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
            userBirthDate = String.format("%02d", faker.number().numberBetween(1, 28)),
            userBirthMonth = getRandomItemFromArray(month),
            userBirthYear = String.valueOf(getRandomInt(1900, 2100));
}
