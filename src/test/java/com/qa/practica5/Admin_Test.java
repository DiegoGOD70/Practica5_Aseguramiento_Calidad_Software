package com.qa.practica5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Admin_Test extends Base_Test {

    @Test(description = "CP06 y CP07 - Navegación a Admin e Interacción con Dropdown")
    public void testAdminYDropdown() {
        realizarLoginExitoso(); // Precondición

        // CP06: Navegación a Admin
        WebElement menuAdmin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Admin']")));
        menuAdmin.click();

        wait.until(ExpectedConditions.urlContains("/admin/viewSystemUsers"));
        Assert.assertTrue(driver.getCurrentUrl().contains("viewSystemUsers"), "Fallo: No se navegó al módulo Admin");

        // CP07: Interacción con Dropdown User Role
        WebElement userRoleDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class, 'oxd-select-text')])[1]")));
        userRoleDropdown.click();

        // Seleccionamos Admin de la lista desplegable
        WebElement adminOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='listbox']//span[text()='Admin']")));
        adminOption.click();

        // Clic en buscar
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Validación: Comprobar que el botón responde tras la búsqueda
        WebElement btnSearch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        Assert.assertTrue(btnSearch.isDisplayed(), "Fallo: El filtro por rol no se ejecutó correctamente");
    }
}