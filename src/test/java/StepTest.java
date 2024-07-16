import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RepositoryPageObjects;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepTest {

    private static final String REPOSITORY = "selenide/selenide";
    private static final int ISSUE = 2775;

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @DisplayName("Lambda steps implementation")
    @Test
    public void testLambdaStep() {

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".search-input-container").click();
            $("#query-builder-test").sendKeys("selenide/selenide");
            $("#query-builder-test").submit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }

    @DisplayName("Web steps implementation")
    @Test
    public void webStepsTest() {

        RepositoryPageObjects repoIssues = new RepositoryPageObjects();

        WebStep steps = new WebStep();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();


        repoIssues
                .checkIssueTab();
    }

}
