package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableForma {

    private SelenideElement
            successfulPopUp = $("#example-modal-sizes-title-lg"),
            resultTable = $(".table-responsive"),

            finalResulWindow = $(".modal-dailog");


    public void ResultTable(String studentName, String studentEmail, String gender, String mobile, String dateOfBirth,
                               String subjects, String hobbies, String picture,
                               String address, String stateAndCity) {
        resultTable.$(byText("Student Name")).parent().shouldHave(text(studentName));
        resultTable.$(byText("Student Email")).parent().shouldHave(text(studentEmail));
        resultTable.$(byText("Gender")).parent().shouldHave(text(gender));
        resultTable.$(byText("Mobile")).parent().shouldHave(text(mobile));
        resultTable.$(byText("Date of Birth")).parent().shouldHave(text(dateOfBirth));
        resultTable.$(byText("Subjects")).parent().shouldHave(text(subjects));
        resultTable.$(byText("Hobbies")).parent().shouldHave(text(hobbies));
        resultTable.$(byText("Picture")).parent().shouldHave(text(picture));
        resultTable.$(byText("Address")).parent().shouldHave(text(address));
        resultTable.$(byText("State and City")).parent().shouldHave(text(stateAndCity));
    }

    //  метод для проверки вызова успешного  pop-up
    public ResultTableForma successfulModalDialog(){
        successfulPopUp
                .shouldBe(visible)
                .shouldHave(text("Thanks for submitting the form"));
        return  this;
    }

    public ResultTableForma checkResultFinalTable(String key, String value){
        resultTable.$(byText(key)).parent().shouldHave(text(value));
        return  this;
    }
    public ResultTableForma notResultWindow() {
        finalResulWindow.shouldNot(appear);
        return this;
    }

    public ResultTableForma visibleResultWindow() {
        finalResulWindow.should(appear);
        return this;
    }

    public void ResultTableMinimalAmountData(String studentName, String gender, String mobile) {
        resultTable.$(byText("Student Name")).parent().shouldHave(text(studentName));
        resultTable.$(byText("Gender")).parent().shouldHave(text(gender));
        resultTable.$(byText("Mobile")).parent().shouldHave(text(mobile));

    }



}
