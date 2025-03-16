package automation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"summary"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@Get",
        features = "src/test/resources/features/",
        glue = {"automation/stepdefinitions/Hooks","automation/stepdefinitions"}

)
public class ApiRunners {
}
