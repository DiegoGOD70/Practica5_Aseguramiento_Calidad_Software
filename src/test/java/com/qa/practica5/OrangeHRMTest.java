package com.qa.practica5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Clase de pruebas para el sitio demo de OrangeHRM.
 * Extiende BaseTest para reutilizar la configuración del navegador.
 */
public class OrangeHRMTest extends BaseTest {

    // -----------------------------------------------------------------------
    // Localizadores
    // -----------------------------------------------------------------------
    private static final By USERNAME_INPUT = By.name("username");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By LOGIN_BUTTON   = By.cssSelector("button[type='submit']");
    private static final By ADMIN_MENU     = By.xpath("//span[text()='Admin']");
    private static final By ERROR_MESSAGE  = By.cssSelector(".oxd-alert-content--error");
    private static final By USER_ROLE_DROPDOWN = By.xpath(
            "(//div[contains(@class,'oxd-select-text')])[1]");

    // -----------------------------------------------------------------------
    // TC-01 : Login exitoso y validación de URL
    // -----------------------------------------------------------------------
    @Test(description = "TC-01: Login exitoso con credenciales válidas y validación de URL del Dashboard")
    public void testLoginExitoso() {
        // Esperar a que el campo usuario esté visible
        WebElement usernameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
        usernameField.sendKeys("Admin");

        driver.findElement(PASSWORD_INPUT).sendKeys("admin123");
        driver.findElement(LOGIN_BUTTON).click();

        // Validar que la URL cambia al Dashboard
        wait.until(ExpectedConditions.urlContains("dashboard"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("dashboard"),
                "La URL debería contener 'dashboard' tras un login exitoso. URL actual: " + currentUrl);
    }

    // -----------------------------------------------------------------------
    // TC-02 : Login inválido y validación del mensaje de error
    // -----------------------------------------------------------------------
    @Test(description = "TC-02: Login con credenciales inválidas y validación del mensaje de error")
    public void testLoginInvalido() {
        WebElement usernameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
        usernameField.sendKeys("usuario_invalido");

        driver.findElement(PASSWORD_INPUT).sendKeys("contraseña_incorrecta");
        driver.findElement(LOGIN_BUTTON).click();

        // Validar que aparece el mensaje de error
        WebElement errorMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
        String errorText = errorMsg.getText();
        Assert.assertFalse(errorText.isEmpty(),
                "Debería mostrarse un mensaje de error para credenciales inválidas.");
        Assert.assertTrue(errorText.toLowerCase().contains("invalid"),
                "El mensaje de error debería indicar credenciales inválidas. Mensaje: " + errorText);
    }

    // -----------------------------------------------------------------------
    // TC-03 : Navegación al módulo Admin
    // -----------------------------------------------------------------------
    @Test(description = "TC-03: Navegación al módulo Admin tras login exitoso")
    public void testNavegacionModuloAdmin() {
        // Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT))
                .sendKeys("Admin");
        driver.findElement(PASSWORD_INPUT).sendKeys("admin123");
        driver.findElement(LOGIN_BUTTON).click();
        wait.until(ExpectedConditions.urlContains("dashboard"));

        // Navegar al módulo Admin
        WebElement adminMenu = wait.until(
                ExpectedConditions.elementToBeClickable(ADMIN_MENU));
        adminMenu.click();

        // Validar que la URL apunta al módulo Admin
        wait.until(ExpectedConditions.urlContains("admin"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("admin"),
                "La URL debería contener 'admin' tras navegar al módulo Admin. URL actual: " + currentUrl);
    }

    // -----------------------------------------------------------------------
    // TC-04 : Interacción con un combobox/dropdown dinámico en el módulo Admin
    // -----------------------------------------------------------------------
    @Test(description = "TC-04: Selección de una opción en el dropdown 'User Role' del módulo Admin")
    public void testInteraccionDropdownUserRole() {
        // Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT))
                .sendKeys("Admin");
        driver.findElement(PASSWORD_INPUT).sendKeys("admin123");
        driver.findElement(LOGIN_BUTTON).click();
        wait.until(ExpectedConditions.urlContains("dashboard"));

        // Ir al módulo Admin > User Management > Users
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");

        // Abrir el dropdown "User Role"
        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(USER_ROLE_DROPDOWN));
        dropdown.click();

        // Esperar a que las opciones sean visibles y seleccionar "Admin"
        WebElement adminOption = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@role='listbox']//span[text()='Admin']")));
        adminOption.click();

        // Validar que el dropdown muestra la opción seleccionada
        String selectedText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(USER_ROLE_DROPDOWN)).getText();
        Assert.assertTrue(selectedText.contains("Admin"),
                "El dropdown debería mostrar 'Admin' como opción seleccionada. Texto actual: " + selectedText);
    }
}
