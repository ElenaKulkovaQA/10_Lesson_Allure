
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebStep {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Обращаемся к поисковой строке  и ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(".search-input-container").click();
        $("#query-builder-test").sendKeys("selenide/selenide");
        $("#query-builder-test").submit();

    }

    @Step(" Кликаем по ссылке репозитория{repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();

    }

    @Step("Открываем таб Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
        // добавили снапшот для аллюр отчета
        Allure.getLifecycle().addAttachment(
                "Исходники страницы",
                "text/html",
                "html",
                WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
        );
        attachScreenshot();// добавили скриншот на этом шаге из аттачмента (ниже) для аллюр отчета

    }

    // аттачмент на скриншот
    @Attachment(value = "Мой любимый скриншот", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}