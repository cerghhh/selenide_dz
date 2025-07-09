package selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.WithTagAndText;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorkHoverSolutions {

    @Test
    void hoverSolution() {

        open("https://github.com/");
        $(new WithTagAndText("button", "Solution")).hover();
        $(withTagAndText("button", "Solutions")).sibling(0);
        $(withText("Enterprises")).hover().click();
        $("#hero-section-brand-heading").shouldHave(Condition.exactText("The AI-powered\ndeveloper platform"));
    }


    @Test
    void workdragAndDrop() {

        open("https://the-internet.herokuapp.com/drag_and_drop");

        SelenideElement source = $("#column-a");
        SelenideElement target = $("#column-b");
        source.shouldHave(text("A"));
        target.shouldHave(text("B"));
        source.dragAndDrop(to(target));
        //проверка
        source.shouldHave(text("B"));
        target.shouldHave(text("A"));


    }

    @Test
    void workActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        SelenideElement source = $("#column-a");
        SelenideElement target = $("#column-b");
        source.shouldHave(text("A"));
        target.shouldHave(text("B"));
        actions().clickAndHold(source).moveToElement(target).release().build().perform();
//проверка
        source.shouldHave(text("B"));
        target.shouldHave(text("A"));
    }
}