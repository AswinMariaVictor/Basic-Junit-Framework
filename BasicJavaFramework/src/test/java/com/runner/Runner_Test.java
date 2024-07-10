package com.runner;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;

import com.baseclass.Base_Class;
import com.sdp.Page_Object_Manager;
import com.sdpTestDataReader.File_Reader_Manager;

@TestInstance(Lifecycle.PER_CLASS)
public class Runner_Test extends Base_Class {

	public static WebDriver driver = getBrowser("chrome");

	public static Page_Object_Manager pom = new Page_Object_Manager(driver);
	public static File_Reader_Manager frm = new File_Reader_Manager();
	
	@BeforeAll
	public void testFixtureInitialization() // executes a method before all tests
	{
		System.out.println("Fixture initiaqlization");
	}
	
	@BeforeEach
	public void testInitialization() // executed before each test method
	{
		System.out.println("Test initialization");
	}

	@Test
	public void method() throws IOException
	{
		getUrl(frm.configurationReaderObject().getTestData("url"));
		maximixe();
		inputValueElement(pom.getHomePageObject().NameField(), frm.configurationReaderObject().getTestData("userName"), Duration.ofSeconds(60));
		assertEquals(getText(pom.getHomePageObject().NameField()), "Aswin", "Wrong text entered");
	}
	
	@Test
	public void methodTwo() throws IOException
	{
		inputValueElement(pom.getHomePageObject().NameField(), frm.configurationReaderObject().getTestData("userName"), Duration.ofSeconds(60));
		assertEquals(getText(pom.getHomePageObject().NameField()), "Aswin", "Wrong text entered");
	}
	
	@AfterEach
	public void testClosure()  // executed after each test method
	{
		System.out.println("Test closure");
	}
	
	@AfterAll
	public void testFIxtureClosure()  // only after all tests have been executed
	{
		System.out.println("Test fixture closure");
	}

}
