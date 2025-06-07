import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;


// AQUI se define la clase ListenerConfig que implementa ITestListener
// Y CON ELLA PODEMOS CONFIGURAR LOS LISTENERS DE TESTNG,PARA CAMBIAR EL COMPORTAMIENTO DE LAS PRUEBAS
// AQUI LO QUE HACEMOS ES CAMBIAR EL LOG DE LA TERMINAL, PARA QUE MUESTRE INFORMACION DE LAS PRUEBAS QUE SE ESTAN EJECUTANDO
public class ListenerConfig implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("\n" + "Test started -> " + result.getName());
        System.out.println("Time: " + result.getStartMillis());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test succeeded -> " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed -> " + result.getName());
        System.out.println("Test failed Cause -> " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped -> " + result.getName());
        System.out.println("Test skipped Cause -> " + result.getSkipCausedBy());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Starting execution: " + "\n");
        System.out.println("Test tag names: " + context.getName() + "\n");
        ITestNGMethod[] methods = context.getAllTestMethods();
        for (ITestNGMethod method : methods) {
            System.out.println(method);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("\n" + "Finishing execution of test suite -> " + context.getName() + "\n");
    }

}
