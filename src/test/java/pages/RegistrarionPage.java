package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrarionPage {
    private SelenideElement  firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput=$("#userEmail"),
            genterWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            userCalendarInput = $("#dateOfBirthInput"),
            userSubjectsInput = $("#subjectsInput"),
            userHobbiesInput = $("#hobbiesWrapper"),
            userUploadPictureInput= $("#uploadPicture"),
            userCurrentAddress = $("#currentAddress"),
            userState = $("#state"),
            userCity = $("#city"),
            submitClick = $("#submit"),

            chekResultTable = $(".table-responsive")



    ;
     CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrarionPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return  this;
    }

    public  RegistrarionPage setFirstName(String value){
        firstNameInput.setValue(value);
        return  this;
    }
    public  RegistrarionPage setlastName(String value){
        lastNameInput.setValue(value);
        return  this;
    }
    public  RegistrarionPage setUserEmail(String value){
        userEmailInput.setValue(value);
        return  this;
    }
    public  RegistrarionPage setGenterWrapper(String value){
        genterWrapperInput.$(byText(value)).click();
        return  this;
    }
    public  RegistrarionPage setUserNumber(String value){
        userNumberInput.setValue(value);
        return  this;
    }

    public  RegistrarionPage setDateOfBirth(String day, String month, String year){
        userCalendarInput.click();
        calendarComponent.setDate(day,month,year);
        return  this;
    }
    public  RegistrarionPage setSubjects(String value){
        userSubjectsInput.setValue(value).pressEnter();
        return  this;
    }
    public  RegistrarionPage setHobbiesWrapper(String value){
        userHobbiesInput.$(byText(value)).click();
        return  this;
    }

    // метод для загрузки файла
    public RegistrarionPage setUploadPicture(String pathname){
        File file = new File(pathname);
        userUploadPictureInput.uploadFile(file);
        return  this;
    }
    //метод для ввода адреса региона
    public  RegistrarionPage setCurrentAddress(String value){
        userCurrentAddress.setValue(value);
        return  this;
    }

    // метод ввод названия штата
    public  RegistrarionPage setState(String value){
        userState.click();
        userState.$(byText(value)).click();
        return  this;
    }

    public  RegistrarionPage setCity(String value){
        userCity.click();
        userCity.$(byText(value)).click();
        return  this;
    }

    // клик по кнопке
    public  RegistrarionPage setSubmitClick(){
        submitClick.click();
        return  this;
    }

    public  RegistrarionPage checkResult(String key, String value){
        chekResultTable.$(byText(key)).parent().shouldHave(text(value));
        return  this;
    }


}
