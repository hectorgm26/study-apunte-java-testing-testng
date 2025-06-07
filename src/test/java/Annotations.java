import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {

    @BeforeSuite(enabled = false)
    public void beforeSuite() {
        System.out.println("Este texto se ejecuta antes de la suite de pruebas");
    }

    @BeforeTest(enabled = false)
    public void beforeTest() {
        System.out.println("Este texto se ejecuta antes de cada test");
    }

    @BeforeClass(enabled = false)
    public void beforeClass() {
        System.out.println("Este texto se ejecuta antes de la clase de pruebas");
    }

    @BeforeMethod(enabled = false)
    public void beforeMethod() {
        System.out.println("Este texto se ejecuta antes de cada método de prueba");
    }

    @Test
    public void test1() {
        System.out.println("Este es el primer test");
    }

    @Test
    public void test2() {
        System.out.println("Este es el segundo test");
    }

    @Test
    public void test3() {
        System.out.println("Este es el tercer test");
    }

    @AfterMethod(enabled = false)
    public void afterMethod() {
        System.out.println("Este texto se ejecuta después de cada método de prueba");
    }

    @AfterClass(enabled = false)
    public void afterClass() {
        System.out.println("Este texto se ejecuta después de la clase de pruebas");
    }

    @AfterTest(enabled = false)
    public void afterTest() {
        System.out.println("Este texto se ejecuta después de cada test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Este texto se ejecuta después de la suite de pruebas");
    }


}
