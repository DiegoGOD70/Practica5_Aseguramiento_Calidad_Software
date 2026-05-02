# Práctica 5: Automatización con Selenium (OrangeHRM)

## 📌 Datos del Proyecto y Equipo
* **Universidad:** Universidad Autónoma de Baja California (UABC)
* **Facultad:** Facultad de Ciencias Químicas e Ingeniería
* **Materia:** Aseguramiento de la Calidad del Software
* **Docente:** Luis Eloy Lazcano Ortiz
* **Grupo:** 371
* **Equipo:** Smiling Friends
* **Integrantes:**
  * Villanueva Estrada Diego - #1290586
  * Tellez Montoya Jose Gilberto - #1289980
  * Jimenez Carrillo Aaron Guadalupe - #1288978
* **Fecha:** 1 de mayo de 2026

---

## 📖 Descripción del Proyecto
Este repositorio contiene la automatización de la **Práctica 5**, enfocada en el diseño de una matriz de pruebas y la automatización de escenarios aplicados al sistema web **OrangeHRM**. 

El objetivo principal es aplicar el diseño de pruebas mediante una matriz funcional y posteriormente automatizar los escenarios utilizando Selenium WebDriver, implementando el uso de esperas explícitas (`WebDriverWait`) y la interacción con componentes dinámicos como combobox (dropdowns).

---

## 🛠️ Stack Tecnológico
Las herramientas y tecnologías utilizadas para la automatización son:
* **Lenguaje:** Java
* **Automatización Web:** Selenium WebDriver
* **Framework de Pruebas:** TestNG
* **Gestor de Dependencias:** Maven
* **Control de Navegadores:** WebDriverManager (Bonigarcia)

---

## 📂 Arquitectura y Estructura del Código
El proyecto sigue el estándar de Maven y está diseñado de forma modular para facilitar el trabajo colaborativo en equipo y evitar redundancia de código. El código fuente de las pruebas se encuentra en `src/test/java/com/qa/practica5/` y está dividido de la siguiente manera:

* `Base_Test.java`: Clase base que centraliza la inicialización del navegador, configuración del `WebDriverWait` (10 segundos) y un método auxiliar para el inicio de sesión.
* `Login_Test.java`: Casos de prueba de inicio de sesión (credenciales válidas, inválidas, campos vacíos y UI).
* `Dashboard_Test.java`: Casos de validación de carga y paneles (Quick Launch) del Dashboard.
* `Admin_Test.java`: Navegación e interacción con listas desplegables (User Role) en el módulo Admin.
* `PIM_Test.java`: Manejo de combobox dinámicos para filtrar el estatus de empleo (Employment Status).
* `Recruitment_Test.java`: Selección dinámica de vacantes a través de dropdowns personalizados.

---
