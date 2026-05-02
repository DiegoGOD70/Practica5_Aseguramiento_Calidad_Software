package com.qa.practica5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_Test extends Base_Test {

    @Test(description = "CP01 - Login exitoso")
    public void testLoginExitoso() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        user.sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        wait.until(ExpectedConditions.urlContains("/dashboard/index"));
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Fallo: No redirigió al Dashboard");
    }

    @Test(description = "CP02 - Login inválido")
    public void testLoginInvalido() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        user.sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("clave_mala");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-alert-content-text")));
        Assert.assertEquals(errorMsg.getText(), "Invalid credentials", "Fallo: No apareció el mensaje de error");
    }

    @Test(description = "CP03 - Login con campos vacíos")
    public void testCamposVacios() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        btnLogin.click();

        // Validamos que aparezca el texto "Required"
        WebElement requiredMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(@class, 'oxd-input-field-error-message')]")));
        Assert.assertEquals(requiredMsg.getText(), "Required", "Fallo: No se validaron los campos vacíos");
    }

    @Test(description = "CP04 - Validación de UI en Login")
    public void testValidacionUI() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // Validamos que el logo de la empresa esté visible
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='company-branding']")));
        Assert.assertTrue(logo.isDisplayed(), "Fallo: El logo de OrangeHRM no es visible");
    }
}
