import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParametrizationDataProvider {
    // Antes de pasar los datos a la prueba debemos crear el objeto Data Provider que contiene los datos
    @DataProvider
    public Object[][] testData() {
        // Creacion del objeto M*N (M filas y N columnas).
        // M sera el numero de iteraciones de la prueba y N sera el numero de parametros que se le pasaran al objeto
        Object[][] data = new Object[3][2];

        // Rellenado primera fila
        data[0][0] = "Fer@titanium";
        data[0][1] = "123456";

        // Rellenado segunda fila
        data[1][0] = "hache@titanium";
        data[1][1] = "123456";

        // Rellenado tercera fila
        data[2][0] = "yani@titanium";
        data[2][1] = "123456";

        return data;
    }

    // 2da forma de crear el Data Provider
    @DataProvider
    public Object[][] testData2() {
        return new Object[][]{ // No se limita a un numero de filas y columnas, ni a numeros de posiciones
                {"1", "Fer@titanium", "123456"},
                {"2", "hache@titanium", "123456"},
                {"3", "yani@titanium", "123456"}
        };
    }

    // Hay que indicarle a TestNG de donde se tomaran los datos que se necesitan para la prueba. se le pasa el nombre del Data Provider
    @Test(dataProvider = "testData")
    // Hay que pasar los argumentos del Data Provider al metodo de prueba
    public void test(String user, String pass) {
        System.out.println(user);
        System.out.println(pass);
    }

    @Test(dataProvider = "testData2")
    public void test2(String id, String user, String pass) {
        System.out.println(id);
        System.out.println(user);
        System.out.println(pass);
    }
}