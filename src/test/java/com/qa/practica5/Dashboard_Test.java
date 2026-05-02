package com.qa.practica5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Dashboard_Test extends Base_Test {

    @Test(description = "CP05 - Validar carga correcta del Dashboard")
    public void testCargaDashboard() {
        // Precondición: Utilizamos el método de la clase base para iniciar sesión
        realizarLoginExitoso();

        // REQUISITO: Espera explícita y validación de elemento visible
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h6[text()='Dashboard']")));

        // Validación obligatoria
        Assert.assertTrue(header.isDisplayed(), "Fallo: El encabezado del Dashboard no es visible.");
    }

    @Test(description = "CP12 - Validación de panel Quick Launch")
    public void testPanelQuickLaunch() {
        // Precondición: Utilizamos el método de la clase base para iniciar sesión
        realizarLoginExitoso();

        // REQUISITO: Espera explícita para buscar el widget en la pantalla principal
        WebElement quickLaunchWidget = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[text()='Quick Launch']")));

        // Validación obligatoria
        Assert.assertTrue(quickLaunchWidget.isDisplayed(), "Fallo: El panel de Quick Launch no se encuentra en el Dashboard.");
    }
}