package com.qa.practica5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Recruitment_Test extends Base_Test {

    @Test(description = "CP10 - Navegación exitosa al módulo Recruitment")
    public void testNavegacionRecruitment() {
        realizarLoginExitoso(); // Precondición

        WebElement menuRecruitment = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Recruitment']")));
        menuRecruitment.click();

        wait.until(ExpectedConditions.urlContains("/recruitment/viewCandidates"));
        WebElement headerRecruitment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Recruitment']")));
        Assert.assertTrue(headerRecruitment.isDisplayed(), "Fallo: No cargó el módulo Recruitment");
    }

    @Test(description = "CP11 - Interacción con Dropdown Vacancy")
    public void testDropdownVacancy() {
        realizarLoginExitoso(); // Precondición

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Recruitment']"))).click();
        wait.until(ExpectedConditions.urlContains("/recruitment/viewCandidates"));

        // Interacción con Dropdown (Búsqueda por label)
        WebElement vacancyDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[text()='Vacancy']/../following-sibling::div//div[contains(@class, 'oxd-select-text')]")));
        vacancyDropdown.click();

        // Seleccionar la segunda opción (usando índice dinámico)
        WebElement segundaVacante = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[@role='listbox']//span)[2]")));
        segundaVacante.click();

        // Clic en Search
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Validación
        WebElement btnSearch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        Assert.assertTrue(btnSearch.isDisplayed(), "Fallo: No se filtraron las vacantes en Recruitment");
    }
}