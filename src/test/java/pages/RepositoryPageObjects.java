package pages;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class RepositoryPageObjects {

    @DisplayName("Находим таб 2775 и убеждаемся, что он видимый")
    public void issues(){
        $(withText("#2775")).shouldBe(Condition.exist);

//    public void issues(int issue) {
//        $(withText("#" + issue)).should(Condition.exist);
    }
}