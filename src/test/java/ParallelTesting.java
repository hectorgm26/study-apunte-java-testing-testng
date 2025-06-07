import org.testng.annotations.Test;

public class ParallelTesting {

    @Test
    public void test1() {
        System.out.println("Prueba corriendo en el hilo: " + Thread.currentThread().getId()); // Identificador del hilo
        // El procesador asigna el hilo de manera aleatoria, apartando en memoria el hilo para un metodo de prueba especifico
    }

    @Test
    public void test2() {
        System.out.println("Prueba corriendo en el hilo: " + Thread.currentThread().getId());
    }

    // Como le pusimos en el XML que fueran dos hilos, no se pueden creer mas de dos hilos
    // Por ende, este tercer metodo debe esperar a que uno de los dos hilos termine, desocupandose
    // y luego asignandosele a este metodo de prueba
    @Test
    public void test3() {
        System.out.println("Prueba corriendo en el hilo: " + Thread.currentThread().getId());
    }

    // SI SE QUIERE PROBAR UN SIMPLE METODO ASIGNANDO HILOS, PERO SIN DEPENDER DE UN XML, SE HACE LO SIGUIENTE:
    // threadPoolSize = 2 significa que se van a crear dos hilos para correr este metodo
    // invocationCount = 3 significa que se va a correr este metodo 3 veces, es decir, se repetira 3 veces el mismo metodo
    @Test(threadPoolSize = 3, invocationCount = 3)
    public void test4() {
        System.out.println("Prueba corriendo en el hilo: " + Thread.currentThread().getId());
    }
}
