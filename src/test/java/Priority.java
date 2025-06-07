import org.testng.annotations.Test;

// Con el atributo testName se puede cambiar el nombre del test que se muestra en la consola

public class Priority {

    @Test(priority = 1, testName = "TestPriority1")
    public void testOne() {
        System.out.println("Test One");
    }

    @Test(priority = 2, testName = "TestPriority2")
    public void testTwo() {
        System.out.println("Test Two");
    }

    @Test(priority = 3, testName = "TestPriority3")
    public void testThree() {
        System.out.println("Test Three");
    }

    @Test(priority = 4, testName = "TestPriority4")
    public void testFour() {
        System.out.println("Test Four");
    }

    @Test(priority = 5, testName = "TestPriority5")
    public void testFive() {
        System.out.println("Test Five");
    }


}
