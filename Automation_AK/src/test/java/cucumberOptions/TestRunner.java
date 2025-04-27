package cucumberOptions;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.CucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(  
	    features = "src/test/java/features",
	    glue="stepDefinations",
	    plugin = {"pretty","html:target/cucumber.html"})
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    //@DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
