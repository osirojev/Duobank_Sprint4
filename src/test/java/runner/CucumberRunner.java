package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@api", //@login and @regression //  // "@login or @smoke", "@login and @smoke", "@login and not @smoke", "@login and @smoke and @regression"
        features = "src/test/resources/features/api", // path where the feature files are located
//        features = {"src/test/resources/features/ui", "src/test/resources/features/db"}, // for multiple paths
//        features = "src/test/resources/features/login.feature",  // specific feature file
        glue = "stepDefinitions" // path where the step Definition methods glued to feature file steps are located
       // ,dryRun = true    // this is used to generate step definition snippets without actually running the test
//

        , plugin = {
        "pretty",   // detailed test run results on the console
        "html:target/built-in-html-report.html",  // generates built-in html report
        "json:target/cucumber.json" ,
        "rerun:target/failed-scenarios.txt "// generates a json report that is needed for pretty html report
},
        stepNotifications = true,   // shows detailed step results in report
        snippets = CucumberOptions.SnippetType.CAMELCASE  // generates snippets using camelCase




)
public class CucumberRunner {


}
