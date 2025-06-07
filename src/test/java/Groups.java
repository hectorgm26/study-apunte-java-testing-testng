import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerConfig.class) // Configuracion de los listeners
// Podemos hacer anotaciones a nivel de clase. Todos los metodos de la clase pertenecen a Suite1, pero dentro de ella hay diferentes grupos.
@Test(groups = {"Suite1"})
public class Groups {

    // Esta prueba pertenece a 4 grupos
    @Test(groups = {"smoke", "regression", "defects", "backlog"})
    public void test1() {
        System.out.println("Test1");
    }

    @Test(groups = {"smoke", "regression"})
    public void test2() {
        System.out.println("Test2");
    }

    @Test(groups = {"backlog"})
    public void test3() {
        System.out.println("Test3");
    }

    @Test(groups = {"defects.fixed"})
    public void test4() {
        System.out.println("Test4");
    }

    @Test(groups = {"smoke", "defects.fixed"})
    public void test5() {
        System.out.println("Test5");
    }
}
