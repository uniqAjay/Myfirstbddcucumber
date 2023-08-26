package TestRuner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)

@CucumberOptions(
		features = ".//Features//AddCustFeature.feature",
		glue = "StepDefination",
		dryRun =false,
		monochrome = true,
//		tags ="@Sanity",
		plugin = {"pretty","html:target/Cucumber-reports/reports1.html"}
		)
public class Run {
	
	

 }
   