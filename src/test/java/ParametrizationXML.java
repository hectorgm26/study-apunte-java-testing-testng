import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametrizationXML {

    @Test
    @Parameters({"parameterFromXML"}) // Se coloca el nombre del parámetro definido en el XML
    public void testParameter(@Optional String parameterFromXML) {
        System.out.println("My parameter is: " + parameterFromXML);
    }
}
