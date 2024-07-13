
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
        mainPage
                .openPage()
                .searchForRepository()
                .navigateToIssuesPage();

        repoIssues
                .issues();
    }
}