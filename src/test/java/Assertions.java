import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {

    int num1 = 1;
    int num2 = 2;
    int sum = num1 + num2;

    @Test
    public void test1() {
        // En testNg, el metodo assertEquals se usa para comparar dos valores.
        // El primer valor es el esperado y el segundo es el valor que se va a comparar y que se espera que sea igual al primero.
        Assert.assertEquals(sum, 3, "Texto del assert");

        Assert.fail();

        Assert.assertEquals(num1, 1, "Mensaje del segundo assert");
        System.out.println("Ya se realizo el assert");
    }

    @Test
    public void test2() {
        Assert.assertEquals(sum, 3, "Texto del assert en test2");

        System.out.println("Ya se realizo el assert en test2");
    }

    // SOFT ASSERT - AQUELLOS QUE NO DETIENEN LA EJECUCION DEL TEST, SI NO QUE MUESTRAN LOS FALLIDOS AL FINAL
    @Test
    public void test3() {
        SoftAssert softAssert = new SoftAssert(); // Creacion del objeto SoftAssert. A traves de ese objeto se haran las asertaciones

        softAssert.assertEquals(sum, 89, "Mensaje del soft assert en test3");
        Assert.assertEquals(sum, 3, "Texto del assert en test3");
        softAssert.assertNotNull(sum, "Segundo mensaje del soft assert en test3");

        System.out.println("Ya se realizo el soft assert");

        // Lanzar las excepciones de los soft asserts - no se referenciasn automaticamente
        softAssert.assertAll(); // el assertAll() es el que lanza las excepciones de los soft asserts, si no se llama a este metodo, no se lanzaran las excepciones
    }
}
