import org.testng.annotations.Test;

// La prioridad por defecto es 0, y cuando todos los metodos tienen la misma prioridad, se determina de forma alfabetica por el nombre del metodo de prueba

public class Dependency {

    @Test
    public void ponerPanBase() {
        System.out.println("Pan base colocado");
    }

    @Test(dependsOnMethods = "ponerPanBase") // depende de que ya se haya puesto un pan base
    public void ponerAderezos() {
        System.out.println("Aderezos colocados");
    }

    @Test(dependsOnMethods = "ponerPanBase")
    public void ponerJamon() {
        System.out.println("Jamon colocado");
    }

    @Test(dependsOnMethods = {"ponerPanBase", "ponerAderezos", "ponerJamon"})
    // cuando son varios metodos de los que depende, se deben colocar con llaves {}
    public void ponerPanTapa() {
        System.out.println("Pan tapa colocado");
    }
}
