package com.zenika.laposte.bdd;


import com.zenika.laposte.LaPosteApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Class to use spring application context while running cucumber
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        plugin = {"pretty"})
@CucumberContextConfiguration
@SpringBootTest(classes = LaPosteApplication.class)
public class RunCucumberTest {



}