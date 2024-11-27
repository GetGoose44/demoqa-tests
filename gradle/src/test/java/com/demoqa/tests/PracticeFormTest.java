package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTest {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        // Открываем страницу формы
        open("/automation-practice-form");

        // Заполняем "First Name" и "Last Name"
        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");

        // Заполняем "Email"
        $("#userEmail").setValue("john.doe@example.com");

        // Выбираем пол (Gender)
        $("[for='gender-radio-1']").click(); // Male

        // Заполняем "Mobile Number"
        $("#userNumber").setValue("9876543210");

        // Указываем дату рождения (Date of Birth)
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--001").click();

        // Заполняем поле "Subjects"
        $("#subjectsInput").setValue("Maths").pressEnter();

        // Выбираем хобби
        $("[for='hobbies-checkbox-1']").click(); // Sports

        // Загружаем изображение
        $("#uploadPicture").uploadFile(new File("src/test/resources/test-picture.jpg"));

        // Заполняем "Current Address"
        $("#currentAddress").setValue("123 Main Street, Cityville");

        // Выбираем штат (State) и город (City)
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        // Нажимаем кнопку "Submit"
        $("#submit").click();

        // Проверяем успешное отправление формы
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
    }
}
