package com.qa.practica5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Pim_Test extends Base_Test {

    @Test(description = "CP08 - Navegación exitosa al módulo PIM")
    public void testNavegacionPIM() {
        realizarLoginExitoso(); // Precondición

        WebElement menuPIM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']")));
        menuPIM.click();

        wait.until(ExpectedConditions.urlContains("/pim/viewEmployeeList"));
        WebElement headerPIM = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='PIM']")));
        Assert.assertTrue(headerPIM.isDisplayed(), "Fallo: No cargó el módulo PIM");
    }

    @Test(description = "CP09 - Interacción con Dropdown Employment Status")
    public void testDropdownEmploymentStatus() {
        realizarLoginExitoso(); // Precondición

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']"))).click();
        wait.until(ExpectedConditions.urlContains("/pim/viewEmployeeList"));

        // Interacción con Dropdown (Búsqueda por label)
        WebElement statusDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[text()='Employment Status']/../following-sibling::div//div[contains(@class, 'oxd-select-text')]")));
        statusDropdown.click();

        // Seleccionamos la opción "Full-Time"
        WebElement fullTimeOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='listbox']//span[contains(text(), 'Full-Time')]")));
        fullTimeOption.click();

        // Clic en Search
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Validación
        WebElement btnSearch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        Assert.assertTrue(btnSearch.isDisplayed(), "Fallo: No se aplicó el filtro de Employment Status");
    }
}