package testRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\mrajan509\\eclipse-workspace\\BDDTesting1_Cucmber\\Features\\ShoppingTest.feature",
		glue="stepDefinitions",
		dryRun=false,
		monochrome=true
		
		)

public class TestRun {
	

}
