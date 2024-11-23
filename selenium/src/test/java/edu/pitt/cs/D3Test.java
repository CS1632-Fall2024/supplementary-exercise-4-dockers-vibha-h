// Generated by Selenium IDE
package edu.pitt.cs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.*;
import java.time.Duration;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class D3Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void tEST1LINKS() {
    driver.get("http://localhost:8080/");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    {
      WebElement element = driver.findElement(By.linkText("Reset"));
      String attribute = element.getAttribute("href");
      vars.put("resetLink", attribute);
    }
    assertEquals("http://localhost:8080/reset", vars.get("resetLink").toString());
  }

  @Test
  public void tEST2RESET() {
    driver.get("http://localhost:8080/");
    js.executeScript("document.cookie = \"1=true\";document.cookie = \"2=true\";document.cookie = \"3=true\";");
    driver.findElement(By.linkText("Reset")).click();
    assertThat(driver.findElement(By.id("cat-id1")).getText(), is("ID 1. Jennyanydots"));
    assertThat(driver.findElement(By.id("cat-id2")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.id("cat-id3")).getText(), is("ID 3. Mistoffelees"));
  }

  @Test
  public void tEST3CATALOG() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Catalog")).click();
    {
      WebElement element = driver.findElement(By.xpath("/html/body/div/main/div[1]/ol/li[2]/img"));
      String attribute = element.getAttribute("src");
      vars.put("imgSrc", attribute);
    }
    assertTrue(vars.get("imgSrc").toString().contains("/images/cat2.jpg"));
  }

  @Test
  public void tEST4LISTING() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Catalog")).click();
    vars.put("itemCount", driver.findElements(By.xpath("//div/ul/li")).size());
    assertEquals(vars.get("itemCount").toString(), "3");
    assertThat(driver.findElement(By.cssSelector(".list-group-item:nth-child(3)")).getText(), is("ID 3. Mistoffelees"));
  }

  @Test
  public void tEST5RENTACAT() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Rent-A-Cat")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".form-group:nth-child(3) .btn"));
      assert (elements.size() > 0);
    }
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".form-group:nth-child(4) .btn"));
      assert (elements.size() > 0);
    }
  }

  @Test
  public void tEST6RENT() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Reset")).click();
    driver.findElement(By.linkText("Rent-A-Cat")).click();
    driver.findElement(By.id("rentID")).click();
    driver.findElement(By.id("rentID")).sendKeys("1");
    driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).click();
    assertThat(driver.findElement(By.xpath("//*[@id=\"rentResult\"]")).getText(), is("Success!"));
    assertThat(driver.findElement(By.xpath("//*[@id=\"cat-id1\"]")).getText(), is("Rented out"));
    assertThat(driver.findElement(By.xpath("//*[@id=\"cat-id2\"]")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.cssSelector(".list-group-item:nth-child(3)")).getText(), is("ID 3. Mistoffelees"));
  }

  @Test
  public void tEST7RETURN() {
    driver.get("http://localhost:8080/");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=true\";document.cookie = \"3=false\";");
    driver.findElement(By.linkText("Rent-A-Cat")).click();
    driver.findElement(By.id("returnID")).click();
    driver.findElement(By.id("returnID")).sendKeys("2");
    driver.findElement(By.cssSelector(".form-group:nth-child(4) .btn")).click();
    assertThat(driver.findElement(By.id("cat-id1")).getText(), is("ID 1. Jennyanydots"));
    assertThat(driver.findElement(By.id("cat-id2")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.id("cat-id3")).getText(), is("ID 3. Mistoffelees"));
    assertThat(driver.findElement(By.id("returnResult")).getText(), is("Success!"));
  }

  @Test
  public void tEST8FEEDACAT() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Feed-A-Cat")).click();
    {
      List<WebElement> elements = driver.findElements(By.xpath("//button[contains(.,'Feed')]"));
      assert (elements.size() > 0);
    }
  }

  @Test
  public void tEST9FEED() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Feed-A-Cat")).click();
    driver.findElement(By.id("catnips")).click();
    driver.findElement(By.id("catnips")).sendKeys("6");
    driver.findElement(By.cssSelector(".btn")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='feedResult' and text()='Nom, nom, nom.']")));
    }
    assertThat(driver.findElement(By.xpath("//div[2]/div[4]")).getText(), is("Nom, nom, nom."));
  }

  @Test
  public void tEST10GREETACAT() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.linkText("Greet-A-Cat")).click();
    {
      List<WebElement> elements = driver.findElements(By.xpath("//h4[contains(.,'Meow!Meow!Meow!')]"));
      assert (elements.size() > 0);
    }
  }

  @Test
  public void tEST11GREETACATWITHNAME() {
    driver.get("http://localhost:8080/greet-a-cat/Jennyanydots");
    {
      List<WebElement> elements = driver.findElements(By.xpath("//h4[contains(.,'Meow! from Jennyanydots.')]"));
      assert (elements.size() > 0);
    }
  }
}
