package gitHub;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class selenideRepository {


    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        String JUnit5 = """
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                """;
        Configuration.holdBrowserOpen = true;
        //открыть репозиторий
        open("https://github.com/");
        actions().sendKeys("s").perform();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $$("[data-testid=results-list]").first().$("a").click();
        //открыть wiki
        $("#wiki-tab").click();
        $(byText("Show 3 more pages…")).click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("JUnit5"));

    }
}