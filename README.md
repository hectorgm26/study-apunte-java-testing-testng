# Resumen Avanzado de TestNG

TestNG (Test Next Generation) es un **framework de testing para Java** que permite pruebas unitarias, de integración y funcionales. Ofrece una serie de características que lo hacen superior a JUnit en muchos aspectos.

---

## ✨ Ventajas Principales

* Reportes HTML automáticos (`emailable-report.html`).
* Anotaciones fuertemente tipadas.
* Agrupación, prioridad y dependencias flexibles.
* Ejecución paralela de pruebas.
* Parametrización avanzada (`@Parameters`, `@DataProvider`).

---

## 🔄 Orden de Ejecución de Anotaciones

```text
@BeforeSuite
    @BeforeTest
        @BeforeClass
            @BeforeGroups
                @BeforeMethod
                    @Test
                @AfterMethod
            @AfterGroups
        @AfterClass
    @AfterTest
@AfterSuite
```

---

## 🗂️ Anotaciones y Atributos Comunes

| Atributo             | Descripción                       |
| -------------------- | --------------------------------- |
| `description`        | Descripción del test              |
| `alwaysRun = true`   | Ejecutar siempre                  |
| `dataProvider`       | Datos desde `@DataProvider`       |
| `dependsOnMethods`   | Ejecutar solo si pasa otro método |
| `groups`             | Agrupar tests                     |
| `dependsOnGroups`    | Ejecutar solo si pasa otro grupo  |
| `priority`           | Orden (menor → primero)           |
| `enabled = false`    | Desactiva el test                 |
| `timeout = 1000`     | Tiempo máximo en ms               |
| `invocationCount`    | Ejecuta varias veces              |
| `expectedExceptions` | Excepciones esperadas             |

---

## 🛠️ Parametrización

### @Parameters (desde XML)

```java
@Test
@Parameters({"user"})
public void testParams(String user) {
    System.out.println("Usuario: " + user);
}
```

```xml
<parameter name="user" value="admin"/>
```

### @DataProvider (desde método)

```java
@DataProvider
public Object[][] data() {
    return new Object[][] {
        {"user1", "pass1"},
        {"user2", "pass2"}
    };
}

@Test(dataProvider = "data")
public void test(String u, String p) {
    System.out.println(u + " - " + p);
}
```

---

## 📊 Prioridades y Dependencias

* `priority`: orden de ejecución según valor.
* `dependsOnMethods`: ejecuta si otro método pasa.
* `dependsOnGroups`: igual que el anterior pero con grupos.

---

## 🔪 Hard vs Soft Assertions

| Tipo            | Característica                         |
| --------------- | -------------------------------------- |
| Hard Assertions | Se detiene al fallar                   |
| Soft Assertions | Ejecuta todo y reporta fallos al final |

### Ejemplo con SoftAssert

```java
SoftAssert sa = new SoftAssert();
sa.assertEquals(actual, expected);
sa.assertTrue(condicion);
sa.assertAll();
```

---

## 🤝 Ejecución Paralela (XML)

```xml
<suite name="ParallelSuite" parallel="methods" thread-count="3">
```

Valores de `parallel`:

* `methods`
* `classes`
* `tests`
* `instances`

---

## 👁️ Listeners

### ITestListener - Ejemplo:

```java
public class CustomListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Inicio: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Falló: " + result.getName());
    }
}
```

### Registro:

**Anotación:**

```java
@Listeners(CustomListener.class)
public class MyTest { }
```

**XML:**

```xml
<listeners>
    <listener class-name="paquete.CustomListener"/>
</listeners>
```

### Otros Listeners:

| Interfaz                 | Propósito               |
| ------------------------ | ----------------------- |
| `ITestListener`          | Eventos de pruebas      |
| `ISuiteListener`         | Eventos de suite        |
| `IMethodInterceptor`     | Reordenar ejecución     |
| `IReporter`              | Reportes personalizados |
| `IExecutionListener`     | Antes/después de todo   |
| `IConfigurationListener` | Para @Before y @After   |

---

## 📅 Reportes HTML

1. Run > Edit Configurations > Habilitar listener por defecto.
2. Ejecutar suite.
3. Ver carpeta `test-output/`.
4. Abrir `emailable-report.html`.

---

## 🗞️ XML de Configuración Completo

```xml
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="MySuite" parallel="classes" thread-count="3">
    <listeners>
        <listener class-name="listeners.CustomListener"/>
    </listeners>

    <test name="LoginTests">
        <groups>
            <define name="group1">
                <include name="login"/>
            </define>
            <run>
                <include name="group1"/>
                <exclude name="deprecatedTests"/>
            </run>
        </groups>

        <classes>
            <class name="com.tests.LoginTest"/>
        </classes>
    </test>
</suite>
```

---

## 🚀 Recomendaciones Finales

* Agrupá tests con `@Test(groups=...)` para controlar ejecuciones.
* Evitá `priority` con strings: usá números.
* Para tests repetitivos usá `invocationCount`.
* Validá todo con `SoftAssert.assertAll()` si usás soft assertions.
* Documentá tus suites XML para facilitar mantenimiento.

---
