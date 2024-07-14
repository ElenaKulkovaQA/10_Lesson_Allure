package pages;
import org.junit.jupiter.api.DisplayName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class MainPageObjects {

    @DisplayName("Открываем главную страницу")
    public MainPageObjects openPage() {
        open("https://github.com/");
        return this;
    }

    @DisplayName("Обращаемся к поисковой строке  и ищем репозиторий {repo}")
    public MainPageObjects searchForRepository() {
        $(".search-input-container").click();
        $("#query-builder-test").sendKeys("selenide/selenide");
        $("#query-builder-test").pressEnter();
        $(linkText("selenide/selenide")).click();
        return this;
    }

    @DisplayName("Навигация по странице - выбрать Issues")
    public MainPageObjects navigateToIssuesPage() {
        $("#issues-tab").click();
        return this;
    }
}

