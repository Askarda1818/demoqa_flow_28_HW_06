import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static  void beforeAll(){
        Configuration.browserSize="1928x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }
    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Smit");
        $("#userEmail").setValue("Smit@mail.ru");
        $("#currentAddress").setValue("Street Pushkina, 12/2");
        $("#permanentAddress").setValue("Sity Baksan");
        $("#submit").click();
        $("#output #name").shouldHave(text("Smit"));
        $("#output #email").shouldHave(text("Smit@mail.ru"));
        $("#output #currentAddress").shouldHave(text("Street Pushkina, 12/2"));
        $("#output #permanentAddress").shouldHave(text("Sity Baksan"));
    }
}
