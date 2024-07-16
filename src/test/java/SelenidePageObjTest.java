
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPageObjects;
import pages.RepositoryPageObjects;

public class SelenidePageObjTest extends TestBase {

    public MainPageObjects mainPage = new MainPageObjects();
    public RepositoryPageObjects repoIssues = new RepositoryPageObjects();

    @DisplayName("Проверяем, что в репозитории Selenide на вкладке Issues имеется таб 2775")
    @Test
    public void checkIssuesTestPO() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        mainPage
                .openPage()
                .searchForRepository()
                .navigateToIssuesPage();

        repoIssues
                .checkIssueTab();
    }
}