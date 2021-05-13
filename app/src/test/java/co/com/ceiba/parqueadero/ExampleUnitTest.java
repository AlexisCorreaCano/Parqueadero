package co.com.ceiba.parqueadero;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class ExampleUnitTest {
    PruebaCovertura pruebaCovertura = new PruebaCovertura();
    @Test
    public void addition_isCorrect() {
        int resultado = pruebaCovertura.sumar(2,2);

        assertEquals(resultado,4);
    }
}