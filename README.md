# Práctica 5: Automatización con Selenium

## Descripción del Proyecto

Este proyecto implementa un framework de **automatización de pruebas** para el sitio demo de [OrangeHRM](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login) utilizando:

- **Selenium WebDriver 4.x** – para la interacción con el navegador.
- **TestNG** – como framework de pruebas unitarias/funcionales.
- **WebDriverManager** – para la gestión automática de los binarios del controlador del navegador (sin necesidad de descargar `chromedriver.exe` manualmente).
- **Maven** – como herramienta de construcción y gestión de dependencias.

La arquitectura sigue las mejores prácticas de la industria:

- `BaseTest.java` centraliza la configuración del navegador (setup/teardown), evitando código repetido en las clases de prueba.
- `OrangeHRMTest.java` contiene únicamente la lógica de las pruebas, manteniéndola limpia y legible.

---

## Requisitos Previos

| Herramienta | Versión mínima |
|-------------|---------------|
| Java JDK    | 17            |
| Maven       | 3.8.x         |
| Google Chrome | Versión actual |

---

## Estructura del Proyecto

```
Practica5_Aseguramiento_Calidad_Software/
├── src/
│   └── test/
│       └── java/
│           └── com/
│               └── qa/
│                   └── practica5/
│                       ├── BaseTest.java
│                       └── OrangeHRMTest.java
├── pom.xml
├── testng.xml
├── .gitignore
└── README.md
```

---

## Instrucciones de Configuración y Ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/DiegoGOD70/Practica5_Aseguramiento_Calidad_Software.git
cd Practica5_Aseguramiento_Calidad_Software
```

### 2. Instalar las dependencias

```bash
mvn clean install -DskipTests
```

### 3. Ejecutar las pruebas

```bash
mvn test
```

> **Nota:** WebDriverManager descargará automáticamente el controlador de Chrome compatible con tu versión del navegador. No se requiere configuración adicional.

### 4. Ver los reportes

Los reportes de TestNG se generan en:

```
target/surefire-reports/
test-output/
```

---

## Casos de Prueba

### Pruebas implementadas en `OrangeHRMTest.java`

| ID    | Descripción |
|-------|-------------|
| TC-01 | Login exitoso con credenciales válidas y validación de URL del Dashboard |
| TC-02 | Login con credenciales inválidas y validación del mensaje de error |
| TC-03 | Navegación al módulo Admin tras login exitoso |
| TC-04 | Selección de una opción en el dropdown "User Role" del módulo Admin |

---

## Matriz de Pruebas

| ID | Módulo | Descripción | Precondiciones | Pasos | Datos de prueba | Resultado esperado | Resultado obtenido | Estado (Pass/Fail) |
|----|--------|-------------|----------------|-------|-----------------|-------------------|-------------------|-------------------|
| TC-01 | Login | | | | | | | |
| TC-02 | Login | | | | | | | |
| TC-03 | Login | | | | | | | |
| TC-04 | Recruitment | | | | | | | |
| TC-05 | Recruitment | | | | | | | |
| TC-06 | Recruitment | | | | | | | |
| TC-07 | PIM | | | | | | | |
| TC-08 | PIM | | | | | | | |
| TC-09 | PIM | | | | | | | |
| TC-10 | Dashboard | | | | | | | |
| TC-11 | Dashboard | | | | | | | |
| TC-12 | Dashboard | | | | | | | |

---

## Conclusiones y comentarios

*(Por completar)*

---

## Dificultades en el desarrollo

*(Por completar)*

---

## Referencias

*(Por completar)*
